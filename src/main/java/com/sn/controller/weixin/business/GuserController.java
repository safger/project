package com.sn.controller.weixin.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sn.common.TimeUtils;
import com.sn.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sn.common.FileUtils;
import com.sn.common.IdcardValidator;
import com.sn.common.UUIDCreater;
import com.sn.controller.weixin.base.GetAccessToken;
import com.sn.controller.weixin.base.ValidateCode;
import com.sn.controller.weixin.base.WeixinAction;
import com.sn.controller.weixin.base.userAppidReturn;
import com.sn.service.GloginerrorService;
import com.sn.service.GregService;
import com.sn.service.GuserService;
import com.sn.service.GyDmzdService;
import com.sn.service.IdentityService;
import com.sn.service.MsGhksService;
import com.sn.service.MsYspbMxService;
import com.sn.service.MsYspbService;
import com.sn.service.MsYydaService;
import com.sn.service.SmsrecordService;
import com.sn.service.YgdmService;
import com.sn.type.Result;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/weixin/guser")
public class GuserController {

	@Autowired
	private GuserService guserService;
	@Autowired
	private GloginerrorService gloginerrorService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private GregService gregService;
	@Autowired
	private MsGhksService msGhksService;
	@Autowired
	private MsYspbService msYspbService;
	@Autowired
	private MsYydaService msYydaService;
	@Autowired
	private MsYspbMxService msYspbMxService;
	@Autowired
	private YgdmService ygdmService;
	@Autowired
	private GyDmzdService gyDmzdService;
	@Autowired
	private SmsrecordService smsrecordService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	/**
	 * @see 定义接受的时间格式
	 */

	@InitBinder 
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}

	/**
	 * @see 显示注册界面
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showReg")
	public String showReg(String weixinid,Map<String, Object> model) {
		model.put("weixinid", weixinid);
		return "/weixin/reg";
	}
	/**
	 * @see 显示登录界面
	 * @param model
	 * @return
	 */
	@RequestMapping("showLogin")
	public String showLogin(String weixinid,Map<String, Object> model) {
		model.put("weixinid", weixinid);
		return "/weixin/login";
	}
	/**
	 * @see 显示我的信息
	 * @param model
	 * @return
	 */
	@RequestMapping("showUserInfo")
	public String showUserInfo(String weixinid,Map<String, Object> model) {
		String userid=(String)request.getSession().getAttribute("guserid");
		model.put("weixinid", weixinid);
		if(userid==null||userid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";  
		} 
		
		Guser my=guserService.findById(userid);
		Guser guser=new Guser();
		guser.setParentid(userid);
		List<Guser> child_list=guserService.selectByColum(guser, null);
		model.put("my", my);
		model.put("child_list", child_list);
		return "/weixin/myInfo";
	}
	/**
	 * @see 删除病人
	 * @param model
	 * @return
	 */
	@RequestMapping("delUser")
	public String delUser(String id,Map<String, Object> model) {
		if(id!=null&&id.length()>0){
			guserService.deleteById(id);
		}
		return "redirect:/weixin/guser/showUserInfo.html";
	}
	/**
	 * @see 显示修改界面
	 * @param model
	 * @return
	 */
	@RequestMapping("showUserUpdate")
	public String showUserUpdate(String parentid,String userid,Map<String, Object> model) {
		Guser my=guserService.findById(userid);
		model.put("my", my);
		model.put("parentid", parentid);
		return "/weixin/userEdit"; 
	}
	
	/**
	 * @see 显示修改界面
	 * @param model
	 * @return
	 * @throws ParseException 
	 */ 
	@RequestMapping("updateUser")
	public String updateUser(Guser guser,Map<String, Object> model) throws ParseException {
		String fuid=guser.getFuid();
		if(guser.getIdcard()==null||guser.getIdcard().length()==0){
			model.put("error", "身份证为空"); 
			return  "/weixin/userEdit";
		}
		Boolean check=IdcardValidator.isValidatedAllIdcard(guser.getIdcard());
		if(!check){
			model.put("error", "身份证错误");
			return  "/weixin/userEdit";
		} 
		Guser g=new Guser();
		g.setIdcard(guser.getIdcard());
		//int a=guserService.countByColum(g);
		if(fuid!=null&&fuid.length()>0){ 
			guserService.updateSelective(guser);
		}else{ 
			/*if(a>0){
				model.put("error", "身份证已经注册");
				return  "/weixin/userEdit"; 
			}*/
			guser.setFuid(UUIDCreater.getUUID());
			//识别身份证 332603720819007
			String idcard=guser.getIdcard(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			if(idcard.length()==15){
				String year="19"+idcard.substring(6,8);
				String month=idcard.substring(8,10);
				String day=idcard.substring(10,12);
				int sex=1;
				Integer s=Integer.parseInt(idcard.substring(14,15));
				if(s%2==0){
					sex=2;
				}
				if(sex%2!=0){
					sex=1;
				}
				Date birthday=dateFormat.parse(year+month+day);
				guser.setSex(sex);
				guser.setBirthday(birthday);
			}
			//识别身份证  
			if(idcard.length()==18){
				String year=idcard.substring(6,10);
				String month=idcard.substring(10,12);
				String day=idcard.substring(12,14);
				int sex=1;
				Integer s=Integer.parseInt(idcard.substring(16,17));
				if(s%2==0){
					sex=2;
				}
				if(sex%2!=0){
					sex=1;
				}
				Date birthday=dateFormat.parse(year+month+day);
				guser.setSex(sex);
				guser.setBirthday(birthday);
			}
			guser.setCreatedate(new Date());
			guserService.insert(guser);
		} 
		return "redirect:/weixin/guser/showUserInfo.html";
	}
	/**
	 * @see 显示绑定微信
	 * @param model
	 * @return
	 */
	@RequestMapping("showBwx")
	public String showBwx(String weixinid,Map<String, Object> model) {
		String userid=(String)request.getSession().getAttribute("guserid");
		model.put("weixinid", weixinid);
		if(userid==null||userid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";  
		}  
		Guser guser=new Guser();
		guser.setWeixinid(weixinid);
		guser.setIsBind(1);
		List<Guser> g_list=guserService.selectByColum(guser, null);
		if(g_list!=null&&g_list.size()>0){
			model.put("isBind", 1);
		}else{
			model.put("isBind", 0);
		}
		return "/weixin/bindWechat";
	}
	
	/**
	 * @see 绑定微信
	 * @param model
	 * @return
	 */
	@RequestMapping("bindWx")
	public String bindWx(String type,Map<String, Object> model) {
		String weixinid=(String)request.getSession().getAttribute("gweixinid");
		System.out.println("-----绑定微信"+weixinid);
		System.out.println("-----绑定微信type"+type);
		Guser guser=new Guser(); 
		guser.setWeixinid(weixinid);  
		List<Guser> g_list=guserService.selectByColum(guser, null);
		if(g_list!=null&&g_list.size()>0){
			if(type!=null&&type.equals("bd")){
				g_list.get(0).setWeixinid(weixinid);
				g_list.get(0).setIsBind(1);
				model.put("isBind", 1);
			}
			if(type!=null&&type.equals("qx")){
				g_list.get(0).setIsBind(0);
				model.put("isBind", 0);
			}
			guserService.updateSelective(g_list.get(0));
		}
		model.put("weixinid", weixinid);
		return "/weixin/bindWechat";
	}
	/**
	 * @see 登录
	 * @param guser
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(Guser guser,Map<String, Object> model) {
		guser.setWeixinid(null);  
		String weixinid=(String)request.getSession().getAttribute("gweixinid"); 
		System.out.println("-------------登录微信ID"+weixinid);
		if(guser!=null&&guser.getIdcard()!=null){
			List<Guser>  g_list=guserService.selectByColum(guser, null);
			Gloginerror gloginerror=new Gloginerror();
			if(g_list!=null&&g_list.size()>0){  
				if(g_list.get(0).getParentid()!=null&&g_list.get(0).getParentid().length()>0){
					gloginerror.setFuid(UUIDCreater.getUUID());
					gloginerror.setName(guser.getName());
					gloginerror.setIdcard(guser.getIdcard());
					gloginerror.setCreatedate(new Date());
					gloginerror.setContent("其他病人不能作为账号登录，请您使用主账户登录或重新注册！");
					gloginerrorService.insert(gloginerror);
					model.put("error", "其他病人不能作为账号登录，请您使用主账户登录或重新注册！");
					return "/weixin/login";
				}
				if(g_list.get(0).getWeixinid()==null||g_list.get(0).getWeixinid().length()==0){
					g_list.get(0).setWeixinid(weixinid);
					guserService.updateSelective(g_list.get(0));  
				} 
				request.getSession().setMaxInactiveInterval(6*60*60); 
				request.getSession().setAttribute("guserid", g_list.get(0).getFuid());
				request.getSession().setAttribute("gusername", g_list.get(0).getName());
				request.getSession().setAttribute("idcard", g_list.get(0).getIdcard());
				return "redirect:/weixin/guser/index.html";
			}else{  
				gloginerror.setFuid(UUIDCreater.getUUID());
				gloginerror.setName(guser.getName());
				gloginerror.setIdcard(guser.getIdcard());
				gloginerror.setCreatedate(new Date());
				gloginerror.setContent("您输入的身份证或姓名不存在!请重新注册！");
				gloginerrorService.insert(gloginerror);
				model.put("error", "您输入的身份证或姓名不存在!请重新注册！");
				return "/weixin/login";
			}
		} 
		return "/weixin/login";
	}
	
	/**
	 * @see 登出
	 * @param guser
	 * @param model
	 * @return
	 */ 
	@RequestMapping("loginOut")
	public String loginOut(String weixinid,Map<String, Object> model) {
		request.getSession().invalidate();
		model.put("weixinid", weixinid);
		return "/weixin/login";
	}
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model  
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException  
	 */
	@RequestMapping("index")
	public String index(String code, Map<String, Object> model) throws JsonParseException, JsonMappingException, IOException {
		// 获取用户weixinid
		String weixinid="";
		//String weixinid="oajWS0TNO8gn_DcjiO95yJpkaJiY"; 
		if (code != null && code.length() > 0) {
			String re = WeixinAction.postSendMessage("https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + GetAccessToken.AppId + "&secret=" + GetAccessToken.AppSecret + "&code=" + code + "&grant_type=authorization_code", "");
			ObjectMapper objectMapper = new ObjectMapper();
			userAppidReturn userAppid = objectMapper.readValue(re, userAppidReturn.class);
			weixinid = userAppid.getOpenid();
			if(weixinid==null||weixinid.length()==0){
				System.out.println("-------------index微信ID获取失败");
				model.put("error", "主页禁止刷新，信息获取失败，请关闭页面重新打开");
				return "/weixin/error"; 
			} 
			System.out.println("-------------index微信ID"+weixinid);
			request.getSession().setAttribute("gweixinid", weixinid);
		}
		String gu=(String)request.getSession().getAttribute("guserid");
		if(gu==null||gu.length()==0){
			if(weixinid!=null&&weixinid.length()>0){ 
				Guser guser=new Guser(); 
				guser.setIsBind(1);  
				guser.setWeixinid(weixinid); 
				List<Guser> g_list=guserService.selectByColum(guser, null);
				if(g_list!=null&&g_list.size()>0){
					request.getSession().setMaxInactiveInterval(6*60*60); 
					request.getSession().setAttribute("guserid", g_list.get(0).getFuid());
					request.getSession().setAttribute("gusername", g_list.get(0).getName());
					request.getSession().setAttribute("idcard", g_list.get(0).getIdcard());
				}else{ 
					//request.getSession().invalidate();
				} 
			}
		}
		model.put("weixinid", weixinid);
		return "/weixin/index";
	}

	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param guser
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 * @throws ParseException 
	 */
	@RequestMapping("reg") 
	public String reg(Guser guser,String vcode, String verification, Map<String, Object> model) throws IOException, ParseException {
		String weixinid=(String)request.getSession().getAttribute("gweixinid");
		model.put("weixinid", weixinid); 
		System.out.println("-------------注册微信ID"+weixinid);
		String idcard=guser.getIdcard(); 
		if(idcard==null||idcard.length()==0){ 
			System.out.println("-------------身份证不能为空");
			model.put("error", "身份证不能为空"); 
			return  "/weixin/reg"; 
		}
		 
		//验证身份证
		Boolean check=IdcardValidator.isValidatedAllIdcard(idcard);
		if(!check){
			System.out.println("-------------身份证错误");
			model.put("error", "身份证错误");
			return  "/weixin/reg"; 
		}  
		vcode=vcode==null?guser.getPhone():vcode;
		System.out.println("-------------注册微信手机"+vcode);
		if(vcode==null||vcode.length()==0){
			 
		} else{
			//验证手机
			Smsrecord smsrecord=new Smsrecord();
			smsrecord.setPhone(vcode);
			smsrecord.setSmscode(verification);
			int a=smsrecordService.countByColum(smsrecord);
			if(a==0){
				model.put("error", "手机验证码错误");
				return  "/weixin/reg"; 
			}
		}
		
		Guser u = new Guser();
		u.setIdcard(guser.getIdcard()); 
		int c = guserService.countByColum(u);
		if (c > 0) {
			model.put("error", "该身份证已经注册，请检查身份证是否正确");
			return  "/weixin/reg";
		} else {
			guser.setFuid(UUIDCreater.getUUID());
			guser.setIsBind(0);  
			guser.setPhone(vcode);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			//识别身份证 332603720819007
			if(idcard.length()==15){
				String year="19"+idcard.substring(6,8);
				String month=idcard.substring(8,10);
				String day=idcard.substring(10,12);
				int sex=1;
				Integer s=Integer.parseInt(idcard.substring(14,15));
				if(s%2==0){
					sex=2;
				}
				if(s%2!=0){
					sex=1;
				}
				Date birthday=dateFormat.parse(year+month+day);
				guser.setSex(sex);
				guser.setBirthday(birthday);
			}
			//识别身份证  
			if(idcard.length()==18){
				String year=idcard.substring(6,10);
				String month=idcard.substring(10,12);
				String day=idcard.substring(12,14);
				int sex=1;
				Integer s=Integer.parseInt(idcard.substring(16,17));
				if(s%2==0){
					sex=2;
				}
				if(s%2!=0){
					sex=1;
				}
				Date birthday=dateFormat.parse(year+month+day);
				guser.setSex(sex);
				guser.setBirthday(birthday);
			}
			guser.setWeixinid(weixinid);
			guser.setCreatedate(new Date());
			guserService.insertSelective(guser);
			request.getSession().setAttribute("guserid", guser.getFuid());
			request.getSession().setAttribute("gusername", guser.getName());
		}
	    return "redirect:/weixin/guser/index.html";
		//return null;
	} 
 
	/**
	 * @see 显示科室选择
	 * @param weixinid
	 * @param model
	 * @return  
	 * @throws IOException
	 */
	@RequestMapping("showKsCh")
	public String showKsCh(String weixinid, Map<String, Object> model) throws IOException {
		String guserid=(String)request.getSession().getAttribute("guserid");
		System.out.println("-----------showKsCh,guserid"+guserid);
		model.put("weixinid", weixinid);
		if(guserid==null||guserid.trim().length()==0){ 
			 return "redirect:/weixin/guser/showLogin.html";  
		} 
		return "/weixin/roomClass";
	}
	/** 
	 * @see 显示科室
	 * @param weixinid
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("showKs")
	public String showKs(Integer zjmz,String weixinid, Map<String, Object> model) throws IOException {
		String guserid=(String)request.getSession().getAttribute("guserid");
		model.put("weixinid", weixinid);
		if(guserid==null||guserid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";  
		}  
		MsGhks msGhks=new MsGhks();
		msGhks.setZjmz(zjmz);  
		msGhks.setMzlb(1); 
		List<MsGhks> g_list=msGhksService.selectByColum(msGhks, null); 
		model.put("g_list", g_list);
		return "/weixin/ksList";
	}
	  
	@RequestMapping("showDoctor")
	public String showDoctor(String weixinid,Date date,String ksdm, Map<String, Object> model) throws IOException, ParseException {
		//查询预约时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		MsYspbMx msy=new MsYspbMx();
		msy.setKsdm(ksdm);
		List<MsYspbMx> t_list=msYspbMxService.selectByGroupTime(msy);
		if(t_list!=null&&t_list.size()>0){
			if(date==null){
				date=t_list.get(0).getGzrq();
			}
			model.put("firstDate", dateFormat.format(date));
			model.put("lastDate", dateFormat.format(t_list.get(t_list.size()-1).getGzrq()));
			//查询预约时间端
			Date day=dateFormat.parse(dateFormat.format(date));
			MsYspbMx msYspbMx=new MsYspbMx();
			msYspbMx.setGzrq(day);
			msYspbMx.setZfpb(0);   //停诊
			msYspbMx.setYybz(0);   //已经预约
			msYspbMx.setKsdm(ksdm);
			List<MsYspbMx> m_list=msYspbMxService.selectByGroup(msYspbMx);
			for(MsYspbMx m:m_list){
				MsYspbMx mm=new MsYspbMx();
				mm.setZblb(m.getZblb());
				mm.setYybz(0); 
				mm.setZfpb(0); 
				mm.setYsdm(m.getYsdm()); 
				mm.setGzrq(day);
				int count=msYspbMxService.countByColum(mm);
				//查询员工级别
				Ygdm ygdm=ygdmService.findById(m.getYsdm());
				Integer jb=ygdm.getYgjb();
				GyDmzd gyDmzd=new GyDmzd();
				gyDmzd.setXtsb(0);
				gyDmzd.setDmsb(jb); 
				gyDmzd.setDmlb(27);
				List<GyDmzd> g_list=gyDmzdService.selectByColum(gyDmzd, null);
				if(g_list!=null&&g_list.size()>0){
					m.setYgjb(g_list.get(0).getDmmc());
				}
				//查询费用
				MsGhks msGhks=msGhksService.findById(m.getKsdm());
				Double fy=msGhks.getGhf()+msGhks.getZlf()+ygdm.getZjfy();
				m.setFy(fy);
				m.setXzpb(count);
			} 
			model.put("m_list", m_list);
		}
		model.put("ksdm", ksdm);
		model.put("weixinid", weixinid);
		return "/weixin/doctorList";
	}
	
	@RequestMapping("getDoctor")
	@ResponseBody
	public String getDoctor(Date date,String ksdm, Map<String, Object> model) throws IOException, ParseException {
		PrintWriter out=response.getWriter();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(date!=null){
			Date day=dateFormat.parse(dateFormat.format(date));
			MsYspbMx msYspbMx=new MsYspbMx();
			msYspbMx.setGzrq(day);
			msYspbMx.setZfpb(0);   //停诊
			msYspbMx.setYybz(0);   //已经预约
			msYspbMx.setKsdm(ksdm);
			List<MsYspbMx> m_list=msYspbMxService.selectByGroup(msYspbMx);
			for(MsYspbMx m:m_list){
				MsYspbMx mm=new MsYspbMx();
				mm.setZblb(m.getZblb());
				mm.setYybz(0); 
				mm.setZfpb(0); 
				mm.setYsdm(m.getYsdm()); 
				mm.setGzrq(day);
				int count=msYspbMxService.countByColum(mm);
				m.setXzpb(count);
				//查询员工级别
				Ygdm ygdm=ygdmService.findById(m.getYsdm());
				Integer jb=ygdm.getYgjb();
				GyDmzd gyDmzd=new GyDmzd();
				gyDmzd.setXtsb(0); 
				gyDmzd.setDmsb(jb); 
				gyDmzd.setDmlb(27);
				List<GyDmzd> g_list=gyDmzdService.selectByColum(gyDmzd, null);
				if(g_list!=null&&g_list.size()>0){
					m.setYgjb(g_list.get(0).getDmmc());
				}
				//查询费用
				MsGhks msGhks=msGhksService.findById(m.getKsdm());
				Double fy=msGhks.getGhf()+msGhks.getZlf()+ygdm.getZjfy();
				m.setFy(fy);
			}
			out.print(JSONArray.toJSON(m_list));
		}
		return null;
	}
	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param id
	 *            主键
	 * @param model
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid) {
		Result result = new Result();
		if (fuid != null && fuid.length() > 0) {
			guserService.deleteById(fuid);
		}
		return result;
	}
	
	/**
	 * @see 预约挂号
	 * @return
	 */
	@RequestMapping("showReservation")
	public String showReservation(String weixinid,MsYspbMx msYspbMx,Map<String, Object> model) {
		List<MsYspbMx> ms_yspb=msYspbMxService.selectByYsks(msYspbMx);
		if(ms_yspb!=null&&ms_yspb.size()>0){ 
		/*	try {
				for(MsYspbMx m:ms_yspb){
					String t=m.getJzsj().split("-")[0];
					m.setJzsj(t.substring(0,t.length()-3)); 
				}
			} catch (Exception e) {
			}*/
			model.put("msYspbMx", ms_yspb.get(0));
			model.put("ms_yspb", ms_yspb);
		}
		//病人列表
		String guserid=(String)request.getSession().getAttribute("guserid");
		Guser guser=new Guser();
		guser.setFuid(guserid);
		List<Guser>  g_list=guserService.selectLikeColum(guser);
		model.put("g_list", g_list);
		model.put("weixinid", weixinid);
		return "/weixin/reservation"; 
	}

	/**
	 * @see 显示我的预约挂号
	 * @return
	 */
	@RequestMapping("showMyReservation")
	public String showMyReservation(String weixinid,Map<String, Object> model) {
		model.put("weixinid", weixinid); 
		String guserid=(String)request.getSession().getAttribute("guserid");
		if(guserid==null||guserid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";
		} 
		Guser guser=new Guser();
		guser.setParentid(guserid); 
		List<Greg> reg_list=gregService.selectByView(guser);
		model.put("reg_list", reg_list);
		return "/weixin/myReservation";  
	} 
	@RequestMapping("reservationInfo")
	public String reservationInfo(String id,Map<String, Object> model) {
		Greg greg=gregService.findById(id);
		Date ytime=greg.getServiceDay();
		if(new Date().getTime()>ytime.getTime()){
			model.put("qx", 1);
		}
		model.put("greg", greg);
		return "/weixin/reservationInfo";
	}
	/**
	 * @see 显示联系我们
	 * @return
	 */
	@RequestMapping("showContactus")
	public String showContactus(Map<String, Object> model) {
		
		return "/weixin/contactus"; 
	}
	
	
	/**
	 * @see 预约挂号
	 * @return
	 */ 
	@RequestMapping("reservation") 
	public String reservation(String jzxh,String userid,Greg greg,Map<String, Object> model) {
		String weixinid=(String)request.getSession().getAttribute("gweixinid");
		String guserid=(String)request.getSession().getAttribute("guserid");
		model.put("weixinid", weixinid);
		if(guserid==null||guserid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";
		}
		 
		Guser guser=guserService.findById(userid);
		//查询并发情况
		MsYyda m2=new MsYyda();
		m2.setKsdm(greg.getDepartmentcode());
		m2.setYsdm(greg.getDoctorcode());
		m2.setYysj(greg.getServiceDay());
		m2.setFdsj(greg.getServiceHours());
		m2.setZblb(greg.getZblb());
		m2.setGhbz(1); 
		int b=msYydaService.countByColum(m2);
		if(b>0){
			
			model.put("error", "对不起，您晚了一步，该时间段刚刚被预约，请重新选择时间段预约！");
			return "/weixin/error";  
		}
		 
		 
		MsYyda m=new MsYyda();
		m.setBrxm(guser.getName());
		m.setSfzh(guser.getIdcard());
		m.setYsdm(greg.getDoctorcode());
		m.setKsdm(greg.getDepartmentcode());
		m.setGzrq(greg.getServiceDay()); 
		m.setGhbz(1);
		int a=msYydaService.countByColum(m); 
		if(a>0){
			//预约排序-------------------------- 
			MsYspbMx msYspbMx=new MsYspbMx();
			msYspbMx.setGzrq(greg.getServiceDay()); 
			msYspbMx.setJzsj(greg.getServiceHours());
			msYspbMx.setKsdm(greg.getDepartmentcode());
			msYspbMx.setYsdm(greg.getDoctorcode());
			msYspbMx.setXzpb(0);    //1为停诊
			List<MsYspbMx> ms_yspb=msYspbMxService.selectByColum(msYspbMx,null);
			if(ms_yspb!=null&&ms_yspb.size()==1){
				ms_yspb.get(0).setYybz(1);    //已经预约
				msYspbMxService.updateSelective(ms_yspb.get(0));
			}
			model.put("error", "一天同医生只能预约一次,要继续预约请先取消上次预约！");
			return "/weixin/error";  
		}
		greg.setPhone(guser.getPhone());
		greg.setStatus("1");
		greg.setQueue(Integer.parseInt(jzxh));
		greg.setWeixinid(weixinid);  
		greg.setUsername(guser.getName());
		greg.setAddress(guser.getAddress());
		greg.setFuid(UUIDCreater.getUUID());
		greg.setSex(guser.getSex());
		greg.setCreatedate(new Date()); 
		
		
		MsYyda msYyda=new MsYyda();
		msYyda.setBrxm(guser.getName());
		msYyda.setBrxb(guser.getSex());
		msYyda.setSfzh(guser.getIdcard());
		msYyda.setCsny(guser.getBirthday()); 
		msYyda.setHkdz(guser.getAddress());
		msYyda.setJtdh(guser.getPhone());  
		msYyda.setJzxh(Integer.parseInt(jzxh));  //------------
		msYyda.setYysj(greg.getServiceDay());
		msYyda.setGzrq(greg.getServiceDay());
		msYyda.setFdsj(greg.getServiceHours());
		msYyda.setZblb(greg.getZblb());
		msYyda.setCqjcyy("0"); 
		msYyda.setZklsh("WX"+new Date().getTime());
		msYyda.setDjgh("weixin");
		msYyda.setYylx(8); //预约类型  7为微信 
		msYyda.setJzlb(2);  //1为初诊  2为复诊
		msYyda.setYsdm(greg.getDoctorcode());
		msYyda.setKsdm(greg.getDepartmentcode());
		msYyda.setDjsj(new Date());
		//预约排序--------------------------
		MsYspbMx msYspbMx=new MsYspbMx();
		msYspbMx.setGzrq(greg.getServiceDay()); 
		msYspbMx.setJzsj(greg.getServiceHours());
		msYspbMx.setJzxh(Integer.parseInt(jzxh));
		msYspbMx.setKsdm(greg.getDepartmentcode());
		msYspbMx.setYsdm(greg.getDoctorcode());
		msYspbMx.setXzpb(0);    //1为停诊
		List<MsYspbMx> ms_yspbMx=msYspbMxService.selectByColum(msYspbMx,null);
		//-----更新医生排班表
		MsYspb msYspb=new MsYspb();
		msYspb.setGzrq(greg.getServiceDay());
		msYspb.setKsdm(greg.getDepartmentcode());
		msYspb.setYsdm(greg.getDoctorcode());
		msYspb.setZblb(greg.getZblb());
		List<MsYspb> yspb=msYspbService.selectByColum(msYspb, null);
		if(yspb!=null&&yspb.size()>0){
			yspb.get(0).setYyrs(yspb.get(0).getYyrs()+1);
			msYspbService.updateSelective(yspb.get(0)); 
		}
		if(ms_yspbMx!=null&&ms_yspbMx.size()==1){
			ms_yspbMx.get(0).setYybz(1);    //已经预约
			msYspbMxService.updateSelective(ms_yspbMx.get(0));
		}else{
			String content=new Date()+":"+JSONArray.toJSONString(msYspbMx);	
			FileUtils.writeFile("E:\\apache-tomcat-8.5.6\\webapps\\reg\\log\\log.txt", content);
			model.put("error", "预约失败，请关闭重试！");
			return "/weixin/error";   
		}
		//预约序号---------------------
		Identity identity=new Identity();
		identity.setTname("ms_yyda");
		List<Identity> i_list=identityService.selectByColum(identity, null);
		i_list.get(0).setValue(i_list.get(0).getValue()+1);
		msYyda.setYyid(i_list.get(0).getValue());  
		identityService.updateSelective(i_list.get(0));
		msYydaService.insertSelective(msYyda);
		greg.setSerial(msYyda.getYyid());
		gregService.insert(greg);
		
		//发送模板消息-------------  
		greg.setDepartmentcode(msYyda.getYyid()+""); 
		WeixinAction.sendMbMember(weixinid, greg);
		return "redirect:/weixin/guser/showMyReservation.html";
	}
	
	/** 
	 * @see 获取图片验证码路径
	 * @author xiao
	 * @throws IOException 
	 */ 
	@RequestMapping("VaildateImg")
	@ResponseBody
    public String VaildateImg(String weixinid, Map<String, Object> model) throws IOException{
		PrintWriter out=response.getWriter();
		if(weixinid==null){
			out.print("error");
			return null;
		} 
    	 ValidateCode vCode = new ValidateCode(120,30,5,50);  
         try {  
        	 String realPath = request.getSession().getServletContext()
 					.getRealPath("/validatesImg/");
        	 String filename=new Date().getTime()+".png";  
             String path=realPath+"\\"+filename; 
             vCode.write(path); 
             request.getSession().setMaxInactiveInterval(60*10);  
             request.getSession().setAttribute(weixinid, vCode.getCode());
             out.print("/validatesImg/"+filename);
         } catch (IOException e) {  
             e.printStackTrace();  
         }  
         return null;
    }
	/**
	 * @see 取消预约挂号
	 * @return
	 */
	@RequestMapping("cancelReservation")
	public String cancelReservation(String id) {
		if(id!=null&&id.length()>0){
			Greg greg=gregService.findById(id);
			greg.setStatus("2");
			gregService.updateSelective(greg);
			//---------------------
			MsYyda msYyda=new MsYyda();
			msYyda.setYyid(greg.getSerial());
			msYyda.setGhbz(2);
			msYydaService.updateSelective(msYyda);
			//---------------------
			MsYspbMx msYspbMx=new MsYspbMx();
			msYspbMx.setGzrq(greg.getServiceDay());
			msYspbMx.setJzsj(greg.getServiceHours());
			msYspbMx.setKsdm(greg.getDepartmentcode());
			msYspbMx.setYsdm(greg.getDoctorcode());
			msYspbMx.setXzpb(0);    //1为停诊
			List<MsYspbMx> ms_yspb=msYspbMxService.selectByColum(msYspbMx,null);
			if(ms_yspb!=null&&ms_yspb.size()>0){
				msYspbMx.setZblb(ms_yspb.get(0).getZblb());  //上午下午
				msYspbMx.setJzxh(ms_yspb.get(0).getJzxh());  //等待序号
			}
			msYspbMx.setYybz(0);    //已经预约
			msYspbMxService.updateSelective(msYspbMx);
			//-------减去排班数量
			MsYspb msYspb=new MsYspb();
			msYspb.setGzrq(greg.getServiceDay());
			msYspb.setKsdm(greg.getDepartmentcode());
			msYspb.setYsdm(greg.getDoctorcode());
			msYspb.setZblb(ms_yspb.get(0).getZblb());
			List<MsYspb> yb_list=msYspbService.selectByColum(msYspb, null);
			yb_list.get(0).setYyrs(yb_list.get(0).getYyrs()-1);
			msYspbService.updateSelective(yb_list.get(0));
			//发送模板消息
			WeixinAction.sendCancel(greg.getWeixinid(), greg);
		} 
		return "redirect:/weixin/guser/showMyReservation.html";
	}

	/**
	 * @deprecated  显示医生排班页
	 * @param model
	 * @return
	 */
	@RequestMapping("showPb")
	public String showPb(Integer timeint,Map<String, Object> model) {
		timeint=timeint==null?0:timeint;
		MsYspb msYspb=new MsYspb();
		msYspb.setGzrq(TimeUtils.addDay(new Date(),timeint));
		msYspb.setZjmz(1);
		List<MsYspb> pbks_zj=msYspbService.selectByYspb(msYspb);
		List<MsYspb> msYspbs_listzj=msYspbService.selectByYspbMx(msYspb);
		msYspb.setZjmz(0);
		List<MsYspb> pbks_pt=msYspbService.selectByYspb(msYspb);
		List<MsYspb> msYspbs_listpt=msYspbService.selectByYspbMx(msYspb);
		//时间处理
		Date date=new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("MM-dd");
		List<Time> t_list=new ArrayList<Time>();
		for(int a=0;a<5;a++){
			Time t=new Time();
			Date d=TimeUtils.addDay(date,a);
			t.setDate(date);
			t.setDateString(dateFm.format(d));
			t.setWeek(TimeUtils.getWeekOfDate(d));
			t.setValue(a);
			if(a==timeint){
				t.setIselect(1);
			}else{
				t.setIselect(0);
			}
			t_list.add(t);
		}
		model.put("time",t_list);
		model.put("pbks_zj",pbks_zj);
		model.put("pbks_pt",pbks_pt);
		model.put("msYspbs_listzj",msYspbs_listzj);
		model.put("msYspbs_listpt",msYspbs_listpt);
		return "/weixin/schedule";
	}
}
