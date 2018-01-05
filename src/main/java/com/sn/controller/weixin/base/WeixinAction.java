package com.sn.controller.weixin.base;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSONArray;
import com.sn.common.SMS;
import com.sn.common.SMSconfig;
import com.sn.common.TimeUtils;
import com.sn.common.UUIDCreater;
import com.sn.common.common;
import com.sn.entity.Greg;
import com.sn.entity.Smsrecord;
import com.sn.entity.Weixinmessage;
import com.sn.entity.weixin.SendContext;
import com.sn.entity.weixin.content;
import com.sn.service.SmsrecordService;
import com.sn.service.WeixinmessageService;
import com.sn.util.PagedResult;

@Controller
@RequestMapping("/weixin/")
public class WeixinAction {

	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	@Autowired
	private WeixinmessageService weixinmessageService;
	@Autowired
	private SmsrecordService smsrecordService;
	/**
	 * 微信开发者验证
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	@RequestMapping("entrance")
	@ResponseBody
	public String Verification() throws IOException,
			ParserConfigurationException, SAXException {
		
//		  String signature = request.getParameter("signature");   // 微信加密签名
//		  String echostr = request.getParameter("echostr"); //随机字符串 
//		  String timestamp = request.getParameter("timestamp");// 时间戳  
//		  String nonce = request.getParameter("nonce");// 随机数
//		  
//		  String[] str = { GetAccessToken.TOKEN, timestamp, nonce };
//		  Arrays.sort(str); //字典序排序 
//		  String bigStr = str[0] + str[1] + str[2]; // SHA1加密
//		  String digest = new  SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase(); // 确认请求来至微信
//		 if (digest.equals(signature)) {
//			 response.getWriter().print(echostr);
//		  } 
//		  return null;
//		 

		response.setContentType("text/xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(request.getInputStream());
		getXmlString(doc);
		return null;
	}

	/**
	 * @see 解析消息 并返回各类信息
	 */
	public void getXmlString(Document doc) {
		// 开发者微信号
		NodeList _UserName = doc.getElementsByTagName("ToUserName");
		String ToUserName = _UserName != null && _UserName.getLength() > 0 ? _UserName.item(0).getFirstChild().getNodeValue(): "";
		// 发送方帐号
		NodeList _FromUserName = doc.getElementsByTagName("FromUserName");
		String FromUserName = _FromUserName != null&& _FromUserName.getLength() > 0 ? _FromUserName.item(0).getFirstChild().getNodeValue() : "";
		// 创建时间
		NodeList _CreateTime = doc.getElementsByTagName("CreateTime");
		String CreateTime = _CreateTime != null && _CreateTime.getLength() > 0 ? _CreateTime.item(0).getFirstChild().getNodeValue(): "0";
		// 消息类型
		NodeList _MsgType = doc.getElementsByTagName("MsgType");
		String MsgType = _MsgType != null && _MsgType.getLength() > 0 ? _MsgType.item(0).getFirstChild().getNodeValue(): "";
		// 文本消息内容
		NodeList _Content = doc.getElementsByTagName("Content");
		String Content = _Content != null && _Content.getLength() > 0 ? _Content.item(0).getFirstChild().getNodeValue(): "";
		// 消息ID
		NodeList _MsgId = doc.getElementsByTagName("MsgId");
		String MsgId = _MsgId != null && _MsgId.getLength() > 0 ? _MsgId.item(0).getFirstChild().getNodeValue() : "";
		// 图片路径
		NodeList _PicUrl = doc.getElementsByTagName("PicUrl");
		String PicUrl = _PicUrl != null && _PicUrl.getLength() > 0 ? _PicUrl.item(0).getFirstChild().getNodeValue() : "";
		// 语音消息ID
		NodeList _MediaId = doc.getElementsByTagName("MediaId");
		String MediaId = _MediaId != null && _MediaId.getLength() > 0 ? _MediaId.item(0).getFirstChild().getNodeValue(): "";
		// 语音格式 如amr，speex等
		NodeList _Format = doc.getElementsByTagName("Format");
		String Format = _Format != null && _Format.getLength() > 0 ? _Format.item(0).getFirstChild().getNodeValue() : "";
		// 事件类型
		NodeList _Event = doc.getElementsByTagName("Event");
		String Event = _Event != null && _Event.getLength() > 0 ? _Event.item(0).getFirstChild().getNodeValue() : "";
		NodeList _EventKey = doc.getElementsByTagName("EventKey");
		String EventKey = _EventKey != null && _EventKey.getLength() > 0 ? _EventKey.item(0).getFirstChild().getNodeValue(): "";
		// 响应不同事件
		if (Event != null && Event.trim().length() > 0) {
			// 用户订阅
			if (Event.equals("subscribe")) {
				String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
						+ GetAccessToken.AccessToken;
				
				// 发送文本消息类型
				 SendContext sendContext = new SendContext();
				  sendContext.setMsgtype("text");
				  sendContext.setTouser(FromUserName);
				 
				// 发送图文消息内容
				/*MessageXX messageXX = new MessageXX();
				messageXX.setMsgtype("news");
				messageXX.setTouser(FromUserName);

				WXnews wxnews = new WXnews();

				List<WXnewsXX> wxnewsXX_List = new ArrayList<WXnewsXX>();
				WXnewsXX wxnewsXX = new WXnewsXX();
				wxnewsXX.setDescription("内容");
				wxnewsXX.setPicurl("http://60.12.184.19/upload/11.jpg");
				wxnewsXX.setTitle("标题");
				wxnewsXX.setUrl("http://www.wicnews.cn/system/2014/11/17/020363486.shtml");
				wxnewsXX_List.add(wxnewsXX);
				wxnews.setArticles(wxnewsXX_List);
				messageXX.setNews(wxnews);
				String text = TransformJSON.toJSON(messageXX);*/
				// System.out.println(text);
				  
				  String con="您好，感谢您关注台州市一医院居家护理微信公众号！居家康复护理团队由专业护士、医生、康复治疗师等组成，竭诚为您提供专业、细心的服务，谢谢！";
				  con+="咨询服务对象请回复1";
				  con+="咨询康复项目请回复2";
				  con+="咨询联系方式请回复3";
				  System.out.println(con);
				  content content=new content(); 
				  content.setContent(con);  
				  sendContext.setText(content);
				  String text=JSONArray.toJSONString(sendContext);
				 
				postSendMessage(url, text);
			}
			// 用户取消订阅
			if (Event.equals("unsubscribe")) {
				
			}
			// 无事件 接受普通消息
		} else {
			
			Weixinmessage buWeixinmessage = new Weixinmessage();
			buWeixinmessage.setFuid(UUIDCreater.getUUID());
			buWeixinmessage.setContent(Content);
			buWeixinmessage.setFromusername(FromUserName);
			buWeixinmessage.setCreatedate(new Date());
			buWeixinmessage.setMessagetime(Integer.parseInt(CreateTime));
			buWeixinmessage.setMsgid(MsgId);
			buWeixinmessage.setMsgtype(MsgType);
			buWeixinmessage.setPicurl(PicUrl);
			buWeixinmessage.setMediaid(MediaId);
			weixinmessageService.insert(buWeixinmessage);
		}

	}

	/**
	 * @see 上传下载多媒体文件
	 * @param fileType
	 *            文件类型
	 * @param filePath
	 *            文件路径
	 */
	public static String sendUpload(String fileType, String filePath)
			throws Exception {
		String result = null;
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}
		/**
		 * 第一部分
		 */
		URL urlObj = new URL("http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="
						+ GetAccessToken.AccessToken + "&type=" + fileType + "");
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存
		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");
		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);
		// 请求正文信息
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // 必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		byte[] head = sb.toString().getBytes("utf-8");
		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);
		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		return result;
	}

	 

	 

	/**
	 * @see post 发消息
	 */
	public static String postSendMessage(String httpsUrl, String context) {
		HttpsURLConnection urlCon = null;
		String result = "";
		try {
			urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("Content-Length",
					String.valueOf(context.getBytes().length));
			urlCon.setUseCaches(false);
			urlCon.getOutputStream().write(context.getBytes("utf-8"));
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlCon.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				result += line;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @see 发送信息至用户（模板消息）
	 * @param
	 * @throws Exception 
	 */
	public static String sendMbMember(String weixinid,Greg greg){
		 String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+GetAccessToken.AccessToken;
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 if(weixinid!=null&&weixinid.length()>0){ 
			 String json="";
			  json+="{";   
			  json+="\"touser\":\""+weixinid+"\",";
			  json+="\"template_id\":\"EGORMDPtTtsGPH74DJCashNf-VJxNffWW5CAaw5IaVo\",";
			  json+="\"url\":\""+"http://hl.tzrmyy.cn/reg/weixin/guser/reservationInfo.html?id="+greg.getFuid()+"\",";
			  json+="\"topcolor\":\"#FF0000\",";
			  json+="\"data\":{";
			  json+="\"first\":{";
			  json+="\"value\":\"您好，您已经成功预约\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"patientName\":{";
			  json+="\"value\":\""+greg.getUsername()+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},"; 
			  json+="\"patientSex\":{";
			  json+="\"value\":\""+(greg.getSex()==1?"男":"女")+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"hospitalName\":{"; 
			  json+="\"value\":\"台州市第一人民医院\","; 
			  json+="\"color\":\"#173177\""; 
			  json+="},";
			  json+="\"department\":{";
			  json+="\"value\":\""+greg.getDepartment()+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"doctor\":{";
			  json+="\"value\":\""+greg.getDoctor()+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},"; 
			  json+="\"seq\":{"; 
			  json+="\"value\":\""+greg.getDepartmentcode()+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"remark\":{";
			  String h=greg.getServiceHours(); 
			  json+="\"value\":\""+"预约时间："+simpleDateFormat.format(greg.getServiceDay())+" "+h.split("-")[0]+",请提前15分钟到门诊取号，建议使用自助设备，过时自动取消预约，敬请注意！如有问题请致电0576-84016923（工作时间：8:00-17:00）"+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="}";
			  json+="}"; 
			  json+="}"; 
			  postSendMessage(url, json);
		}
		return null; 
	} 
	
	/**
	 * @see 发送信息至用户（模板消息）
	 * @param
	 * @throws Exception 
	 */
	public static String sendCancel(String weixinid,Greg greg){
		 String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+GetAccessToken.AccessToken;
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 if(weixinid!=null&&weixinid.length()>0){ 
			 String json="";
			  json+="{";   
			  json+="\"touser\":\""+weixinid+"\",";
			  json+="\"template_id\":\"8Z0Wz0W8hPB8JFboq-7SQEs9nrHTEmKG-WN0uiCrmrM\",";
			  json+="\"url\":\""+"http://hl.tzrmyy.cn/reg/weixin/guser/reservationInfo.html?id="+greg.getFuid()+"\",";
			  json+="\"topcolor\":\"#FF0000\",";
			  json+="\"data\":{";
			  json+="\"first\":{";
			  json+="\"value\":\"您好，您预约的号源已经成功取消。取消号源信息如下：\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"keynote1\":{"; 
			  String h=greg.getServiceHours(); 
			  json+="\"value\":\""+greg.getUsername()+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},"; 
			  json+="\"keynote2\":{";
			  json+="\"value\":\""+(simpleDateFormat.format(greg.getServiceDay()))+" "+h.split("-")[0]+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="},";
			  json+="\"keynote3\":{"; 
			  json+="\"value\":\""+greg.getDoctor()+"\","; 
			  json+="\"color\":\"#173177\"";  
			  json+="},";
			  json+="\"keynote4\":{";  
			  json+="\"value\":\"台州市第一人民医院\",";    
			  json+="\"color\":\"#173177\"";
			  json+="},"; 
			  json+="\"remark\":{";
			  json+="\"value\":\"如有问题请致电0576-84016923（工作时间：8:00-17:00）"+"\",";
			  json+="\"color\":\"#173177\"";
			  json+="}";
			  json+="}"; 
			  json+="}"; 
			  postSendMessage(url, json);
		}
		return null; 
	} 
	
	/**
	 * @see 发送短信验证
	 * @author xiao
	 * @throws IOException 
	 */ 
	@RequestMapping("smsSend")
	@ResponseBody
	public String smsSend(String weixinid,String phone,String code, Map<String, Object> model) throws IOException {
		PrintWriter out=response.getWriter();
		String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";   
		Pattern p = Pattern.compile(regExp);  
		Matcher m = p.matcher(phone); 
		if(!m.find()){
			out.print("手机格式错误");
			return null;
		}
		//验证验证码
		/*String vcode=(String)request.getSession().getAttribute(weixinid);
		if(vcode==null||vcode.trim().length()==0){
			out.print("验证码超时,5分钟内有效！"); 
			System.out.println("---------验证码超时");
			return null;
		}*/
		/*if(!vcode.toLowerCase().equals(code.toLowerCase())){
			out.print("验证码错误！");
			return null; 
		}*/
		//当天同一IP发送短信次数
		String ip=common.getIpAddr(request);
		Smsrecord smsrecord=new Smsrecord();
		smsrecord.setIp(ip);
		smsrecord.setCreatedate(new Date());
		int count_ip=smsrecordService.countByColum(smsrecord);
		if(count_ip>=SMSconfig.IpMostDayNum){
			out.print("当前IP发送验证码次数过多！");
			return null;
		}
		//当天同一手机发送短信次数
		smsrecord.setIp(null);
		smsrecord.setPhone(phone);
		int count_phone=smsrecordService.countByColum(smsrecord);
		if(count_phone>=SMSconfig.PhoneMostDayNum){
			out.print("当前手机号发送验证码次数过多！");
			return null;
		}
		//发送短信验证间隔
		PagedResult<Smsrecord>  page_list=smsrecordService.findByPage(smsrecord, 1, 1, "createdate desc");
		List<Smsrecord> sms_list=page_list.getDataList();
		int interval=0;
		if(sms_list!=null&&sms_list.size()>0){
			Date create=sms_list.get(0).getCreatedate();
			interval=(int) TimeUtils.getBetweenDaysHH(new Date(),create);
		}  
		if(interval>SMSconfig.TimeInterval){
			out.print("当前手机号发送验证码间隔过短！");
			return null;
		}
		int rom = (int)(Math.random()*(999999-100000+1))+100000;
		String tre="0";
		String re=SMS.sendAsms(phone, rom+""); 
		try {
			String su=re.split("&")[0].split("=")[1];
			//记录短信发送
			if(su.equals("0")){
				Smsrecord sms=new Smsrecord();
				sms.setIp(ip);
				sms.setCreatedate(new Date());
				sms.setFuid(UUIDCreater.getUUID());
				sms.setPhone(phone);
				sms.setSmscode(rom+""); 
				sms.setWeixinid(weixinid);
				smsrecordService.insert(sms);
			
			}else{
				String tt=re.split("&")[1].split("=")[1];
				tre=tt;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		out.print(tre);
		return null;
	}
	 
}