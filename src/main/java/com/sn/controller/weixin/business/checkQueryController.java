package com.sn.controller.weixin.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sn.entity.Guser;
import com.sn.entity.ViWgaoLisReportInfo;
import com.sn.entity.ViWgaoLisReportResult;
import com.sn.service.GregService;
import com.sn.service.GuserService;
import com.sn.service.IdentityService;
import com.sn.service.MsGhksService;
import com.sn.service.MsYspbMxService;
import com.sn.service.MsYydaService;
import com.sn.service.ViWgaoLisReportInfoService;
import com.sn.service.ViWgaoLisReportResultService;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/weixin/checkQuery")
public class checkQueryController {

	@Autowired
	private GuserService guserService;
	@Autowired
	private IdentityService identityService;
	@Autowired
	private GregService gregService;
	@Autowired
	private MsGhksService msGhksService;
	@Autowired
	private MsYydaService msYydaService;
	@Autowired 
	private MsYspbMxService msYspbMxService;
	@Autowired
	private ViWgaoLisReportInfoService viWgaoLisReportInfoService;
	@Autowired
	private ViWgaoLisReportResultService viWgaoLisReportResultService;
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
	 * @see 显示查询类型
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("queryType")
	public String queryType(String weixinid,Map<String, Object> model) {
		String guserid=(String)request.getSession().getAttribute("guserid");
		String username=(String)request.getSession().getAttribute("gusername");
		String idcard=(String)request.getSession().getAttribute("idcard");
		model.put("weixinid", weixinid);
		model.put("username", username);
		model.put("idcard", idcard);
		model.put("userid", guserid);
		if(guserid==null||guserid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";  
		} 
		return "/weixin/ckType";
	}
	/**
	 * @see 显示血液等检测
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("userQuery")
	public String userQuery(String weixinid,Map<String, Object> model) {
		String guserid=(String)request.getSession().getAttribute("guserid");
		model.put("weixinid", weixinid);
		String idcard=(String)request.getSession().getAttribute("idcard");
		if(guserid==null||guserid.trim().length()==0){
			 return "redirect:/weixin/guser/showLogin.html";  
		} 
		Guser guser=new Guser();
		guser.setParentid(guserid);
		String cardList="'"+idcard+"'";
		List<Guser> guser_list=guserService.selectByColum(guser, null);
		for(Guser u:guser_list){
			cardList+=",'"+u.getIdcard()+"'";
		}
		
		//idcard="332603196807063596";
		if(idcard!=null&&idcard.length()>0){
			ViWgaoLisReportInfo vlisAppPatientinfo=new ViWgaoLisReportInfo();
			vlisAppPatientinfo.setIdcard(cardList);
			List<ViWgaoLisReportInfo> v_list=viWgaoLisReportInfoService.selectByColum(vlisAppPatientinfo, " reporttime desc");
			if(v_list!=null&&v_list.size()>0){
				Map <String,List<ViWgaoLisReportResult>> m=new HashMap<String, List<ViWgaoLisReportResult>>();
				for(int a=0;a<v_list.size();a++){
					String sampleno=v_list.get(0).getSampleno();
					ViWgaoLisReportResult vlisAppResult=new ViWgaoLisReportResult();
					vlisAppResult.setSampleno(sampleno);
					List<ViWgaoLisReportResult> r_list=viWgaoLisReportResultService.selectByColum(vlisAppResult, null);
					m.put(sampleno, r_list);
				} 
				model.put("c_map", m); 
				model.put("v_list", v_list);
			}
		}
		return "/weixin/checkQuery"; 
	}
	 
}
