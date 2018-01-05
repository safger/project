package com.sn.controller.weixin.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sn.entity.weixin.AccessToken;
import com.sn.entity.weixin.JsApiReturn;
public class GetAccessToken  { 
	  
	public static final String TOKEN = "qwer1234";
	public static final String AppId = "wx8e5a08ccb011d26c"; // 开发者ID
	public static final String AppSecret = "e722f6f4dd284a0f4a87fb5e90cd2f7f";
	 
	public static String AccessToken ="";
	public static String jsapi_ticket ="";
	
	public GetAccessToken() throws JsonParseException, JsonMappingException, IOException {  
		if(AccessToken.length()==0){
			BufferedReader in = null;
			String result="";
			String urlNameString = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + AppId + "&secret=" + AppSecret;
			try {

				URL realUrl = new URL(urlNameString);
				// 打开和URL之间的连接
				URLConnection connection = realUrl.openConnection();
				// 设置通用的请求属性
				connection.setRequestProperty("accept", "*/*");
				connection.setRequestProperty("connection", "Keep-Alive");
				connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
				// 建立实际的连接
				connection.connect();
				// 获取所有响应头字段
				Map<String, List<String>> map = connection.getHeaderFields();
				// 遍历所有的响应头字段
				for (String key : map.keySet()) {
					//System.out.println(key + "--->" + map.get(key));
				}
				// 定义 BufferedReader输入流来读取URL的响应
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
				 ObjectMapper objectMapper = new ObjectMapper();
				 AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
				// Gson gson = new Gson();
				// AccessToken accessToken= gson.fromJson(result,AccessToken.class);
				 AccessToken=accessToken.getAccess_token();
				 System.out.println("--------"+AccessToken);
			} catch (Exception e) {
				System.out.println("发送GET请求出现异常！" + e);
				e.printStackTrace();
			}
			// 使用finally块来关闭输入流
			finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		if(jsapi_ticket.length()==0){
			String httpsUrl="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ GetAccessToken.AccessToken+"&type=jsapi";
			HttpsURLConnection urlCon = null;
			String result = "";
			try {
				urlCon = (HttpsURLConnection) (new URL(httpsUrl)).openConnection();
				urlCon.setDoInput(true);
				urlCon.setDoOutput(true);
				urlCon.setRequestMethod("POST");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						urlCon.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			 ObjectMapper objectMapper = new ObjectMapper();
			 JsApiReturn jsApiReturn  = objectMapper.readValue(result, JsApiReturn.class);
			//Gson gson = new Gson();
			//JsApiReturn jsApiReturn = gson.fromJson(result, JsApiReturn.class);
			jsapi_ticket=jsApiReturn.getTicket();
			System.out.println("--------jsapi_ticket:"+jsapi_ticket);
		}
	}
	public static void newGetAccess() throws JsonParseException, JsonMappingException, IOException{
		AccessToken="";
		jsapi_ticket=""; 
		new GetAccessToken(); 
	}
	
	public static void main(String[] args) throws Exception {
		new GetAccessToken();
		
	}
}
