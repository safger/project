package com.sn.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SMS {

 
	/**
	 * @see 联通短信发送
	 * @param username 用户名称
	 * @param Password 用户密码
	 * @param phonelist 下发信息的手机号码，多个手机号用半角逗号分隔，每个提交包控制在1000个手机号码内
	 * @param msg 下发信息的内容，70个字，超长系统自动截取,按每67个字计费一条
	 * @param longnum 系统分配下行长号码，如果未分配可以填空字符串
	 */
	
	public static String sendAsms( String phonelist, String msg){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String ul="http://ums.zj165.com:8888/sms/Api/Send.do";
		String SpCode="238059";
		String username="tyyjjhl";
		String password="tzdyyy20170101";
		String SerialNumber=simpleDateFormat.format(new Date());
		String ScheduleTime="";          //预约发送时间
		String result=null;   
		String MessageContent="您正在注册微信服务平台账号，验证码："+msg+"，150秒内输入有效。"; 
		URL url;
		try {
			url = new URL(ul);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.connect();
			OutputStream os = conn.getOutputStream();
			String request="SpCode="+SpCode+"&LoginName="+username+"&Password="+password+"&UserNumber="+phonelist+"&MessageContent="+MessageContent+"&SerialNumber="+SerialNumber+"&ScheduleTime=&f=1";
			os.write(request.getBytes("GB2312"));
			os.flush();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream in = conn.getInputStream();
			int ch = 0;
			while ((ch = in.read()) != -1) {
				baos.write(ch);
			}
			byte[] buf = baos.toByteArray();
			result = new String(buf, "GB2312").trim();
			System.out.println(result); 
		} catch (MalformedURLException e) {
			System.out.println("发送失败"); 
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("发送失败");
			e.printStackTrace();
		}
		return result;
	}
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	send("600068","tj99882","13656661844/#/$//#/$/test22");
		System.out.println(new Date());
		sendAsms("13656661844","6476");
	}
 
}
