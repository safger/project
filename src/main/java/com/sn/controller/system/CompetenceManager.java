package com.sn.controller.system;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.sn.common.FileUtils;
import com.sn.common.TimeUtils;
import com.sn.common.common;
import com.sn.controller.weixin.base.GetAccessToken;
import com.sn.controller.weixin.base.WeixinAction;
import com.sn.entity.Datadictionary;
import com.sn.entity.Greg;
import com.sn.entity.MenuRole;
import com.sn.entity.Operating;
import com.sn.entity.Organize;
import com.sn.entity.Scope;
import com.sn.service.DatadictionaryService;
import com.sn.service.GregService;
import com.sn.service.MenuRoleService;
import com.sn.service.MenuService;
import com.sn.service.OrganizeService;
import com.sn.service.ScopeService;
import com.sn.service.UserRoleService;

public class CompetenceManager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static List<Operating> Operating_list;
	public static List<MenuRole> baseMenuRole_list;
	public static List<Scope> baseScope_list;
	public static List<Organize> baseOrganize_list;
	public MenuRoleService baseMenuRoleService;
	public UserRoleService baseUserRoleService;
	public OrganizeService baseOrganizeService;
	public MenuService baseMenuService;
	public ScopeService baseScopeService;
	public DatadictionaryService baseDatadictionaryService;
	public List<String> or = new ArrayList<String>();
	public WebApplicationContext context;
	private ServletContext servlets;
	private GregService gregService;
	/**
	 * 图片存储路径
	 */
	static public String IMAGE_PATH;
	/**
	 * 项目根路径
	 */
	static public String ROOT_PATH;

	public CompetenceManager() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext servlet = this.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		System.out.println("开始缓存时间：" + new Date());
 
		this.weixin();
  
		try { 
			this.deleteCalidatesImg(servlet);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		this.DataRoleMenu(servlet);
		this.DataScope(servlet);
		this.Datadictionary(servlet);
		this.DataOrganize(servlet); 
		System.out.println("结束缓存时间：" + new Date());

		ROOT_PATH = getServletContext().getRealPath("/");
		// 创建路径
		IMAGE_PATH = getServletContext().getRealPath("/") + "/upload/";
		FileUtils.createFilePath(IMAGE_PATH);

	} 

	public void sendNews(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		Calendar cal = Calendar.getInstance();
		// 每天定点执行
		cal.set(Calendar.HOUR_OF_DAY, 7);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				class MyThread extends Thread {
					public void run() {
						try {
							if (gregService == null) {
								gregService = (GregService) context.getBean("gregService");
							}
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Greg g = new Greg();
							g.setServiceDay(sdf.parse(sdf.format(new Date())));
							List<Greg> g_list = gregService.selectByColum(g, null);
							if (g_list != null) {
								for (Greg greg : g_list) {
									if (greg.getWeixinid() != null && greg.getWeixinid().length() > 0) {
										WeixinAction.sendMbMember(greg.getWeixinid(), greg);
									}
								}
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				MyThread myThread = new MyThread();
				Thread t1 = new Thread(myThread);
				t1.start();
			}
		}, cal.getTime(), 24 * 60 * 60 * 1000);
	}

	public void DataScope(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseScopeService = (ScopeService) context.getBean("scopeService");
		baseScope_list = baseScopeService.selectScope();
	}

	public void DataOrganize(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseOrganizeService = (OrganizeService) context.getBean("organizeService");
		baseOrganize_list = baseOrganizeService.selectByColum(null, null);
	}

	public void DataRoleMenu(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseMenuRoleService = (MenuRoleService) context.getBean("menuRoleService");
		baseMenuRole_list = baseMenuRoleService.selectMenuOp();
	}

	public void Datadictionary(ServletContext servlet) {
		if (context == null) {
			context = WebApplicationContextUtils.getWebApplicationContext(servlet);
		}
		baseDatadictionaryService = (DatadictionaryService) context.getBean("datadictionaryService");
		List<Datadictionary> baseDatadictionary_list = baseDatadictionaryService.selectByColum(null, null);
		Map<String, String> DatadictionaryMap = new HashMap<String, String>();
		for (Datadictionary t : baseDatadictionary_list) {
			DatadictionaryMap.put(t.getCode().toString(), t.getFullname());
		}

		servlet.setAttribute("DatadictionaryMap", DatadictionaryMap);
		servlet.setAttribute("baseDatadictionary_list", JSON.toJSONString(baseDatadictionary_list));
	}

	public void weixin() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					GetAccessToken.newGetAccess();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer();
		long intevalPeriod = 1 * 1800 * 1000; // 半小时小时执行一次
		timer.schedule(task, 0, intevalPeriod);
	}

	public static ComData getCom(String roleid, String menuid) {
		String ro[] = null;
		if (roleid != null && roleid.length() > 0) {
			ro = roleid.split(",");
		}
		ComData com = new ComData();
		if (baseMenuRole_list != null) {
			for (int a = 0; a < baseMenuRole_list.size(); a++) {
				if (ro != null) {
					for (int b = 0; b < ro.length; b++) {
						if (baseMenuRole_list.get(a).getMenuId() != null && baseMenuRole_list.get(a).getMenuId().equals(menuid) && baseMenuRole_list.get(a).getRoleId() != null && baseMenuRole_list.get(a).getRoleId().equals(ro[b])) {
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_show")) {
								com.setHisSelect(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_add")) {
								com.setHisAdd(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_del")) {
								com.setHisDelete(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().equals("base_update")) {
								com.setHisUpdate(true);
							}
							if (baseMenuRole_list.get(a).getOperatingId().startsWith("business")) {
								com.getHisOther().put(baseMenuRole_list.get(a).getOperatingId(), true);
							}

						}
					}
				}
			}
		}
		System.out.println(menuid + "-----add:" + com.getHisAdd());
		System.out.println(menuid + "-----del:" + com.getHisDelete());
		System.out.println(menuid + "-----sel:" + com.getHisSelect());
		System.out.println(menuid + "-----update:" + com.getHisUpdate());
		return com;
	}

	public static String getScope(String MenuUrl, String RoleId) {
		String OrganizeId = "";
		if (baseScope_list != null && baseScope_list.size() > 0) {
			for (int a = 0; a < baseScope_list.size(); a++) {
				String menu_url = baseScope_list.get(a).getMenuId();
				String role_id = baseScope_list.get(a).getRoleId();
				if (menu_url != null && menu_url.equals(MenuUrl) && role_id != null && role_id.equals(RoleId)) {
					OrganizeId += "'" + baseScope_list.get(a).getOrganizeId() + "',";
				}
			}

		}
		OrganizeId = OrganizeId.length() > 0 ? OrganizeId.substring(0, OrganizeId.length() - 1) : OrganizeId;
		return OrganizeId;
	}

	public String getOrganizeChild(String OrganizeId) {
		if (baseOrganize_list != null && baseOrganize_list.size() > 0) {
			for (int a = 0; a < baseOrganize_list.size(); a++) {
				if (baseOrganize_list.get(a).getParentid().equals(OrganizeId)) {
					or.add(baseOrganize_list.get(a).getFuid());
					getOrganizeChild(baseOrganize_list.get(a).getFuid());
				}
			}
		}
		String Organize_Id = "";
		if (or != null && or.size() > 0) {
			for (int a = 0; a < or.size(); a++) {
				Organize_Id += "'" + or.get(a) + "',";
			}
		}
		Organize_Id = Organize_Id.length() > 0 ? Organize_Id.substring(0, Organize_Id.length() - 1) : "'" + OrganizeId + "'";
		Organize_Id += ",'" + OrganizeId + "'";
		return Organize_Id;
	}

	public void deleteCalidatesImg(ServletContext servlet) throws ParseException {
		this.servlets = servlet;
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				String realPath = servlets.getRealPath("/validatesImg/") + "\\";
				File file = new File(realPath);
				File[] tempFile = file.listFiles();
				for (int i = 0; i < tempFile.length; i++) {
					String fileName = tempFile[i].getName();
					fileName = fileName.split("\\.")[0];
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long time = new Long(fileName);
					String d = format.format(time);
					Date date;
					try {
						date = format.parse(d);
						int dd = TimeUtils.getBetweenDaysDD(date, new Date());
						if (dd >= 1) {
							common.deleteFile(realPath + tempFile[i].getName());
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Timer timer = new Timer();
		long intevalPeriod = 24 * 3600 * 1000; // 24小时小时执行一次
		timer.schedule(task, 0, intevalPeriod);
	}

	public void refreshRoleMenu(ServletContext servlet) {
		this.DataRoleMenu(servlet);
	}

	public void RefreshDatadictionary(ServletContext servlet) {
		this.Datadictionary(servlet);
	}

	public void RefreshDataScope(ServletContext servlet) {
		this.DataScope(servlet);
	}

	public void RefreshDataOrganize(ServletContext servlet) {
		this.DataOrganize(servlet);
	}

	public void clear() {
		baseMenuRole_list = null;
	}

	public List<String> getOr() {
		return or;
	}

	public void setOr(List<String> or) {
		this.or = or;
	}

	public static List<Operating> getOperating_list() {
		return Operating_list;
	}

	public static void setOperating_list(List<Operating> operating_list) {
		Operating_list = operating_list;
	}

	public static List<MenuRole> getBaseMenuRole_list() {
		return baseMenuRole_list;
	}

	public static void setBaseMenuRole_list(List<MenuRole> baseMenuRole_list) {
		CompetenceManager.baseMenuRole_list = baseMenuRole_list;
	}

	public static List<Scope> getBaseScope_list() {
		return baseScope_list;
	}

	public static void setBaseScope_list(List<Scope> baseScope_list) {
		CompetenceManager.baseScope_list = baseScope_list;
	}

	public static List<Organize> getBaseOrganize_list() {
		return baseOrganize_list;
	}

	public static void setBaseOrganize_list(List<Organize> baseOrganize_list) {
		CompetenceManager.baseOrganize_list = baseOrganize_list;
	}

	public MenuRoleService getBaseMenuRoleService() {
		return baseMenuRoleService;
	}

	public void setBaseMenuRoleService(MenuRoleService baseMenuRoleService) {
		this.baseMenuRoleService = baseMenuRoleService;
	}

	public UserRoleService getBaseUserRoleService() {
		return baseUserRoleService;
	}

	public void setBaseUserRoleService(UserRoleService baseUserRoleService) {
		this.baseUserRoleService = baseUserRoleService;
	}

	public OrganizeService getBaseOrganizeService() {
		return baseOrganizeService;
	}

	public void setBaseOrganizeService(OrganizeService baseOrganizeService) {
		this.baseOrganizeService = baseOrganizeService;
	}

	public MenuService getBaseMenuService() {
		return baseMenuService;
	}

	public void setBaseMenuService(MenuService baseMenuService) {
		this.baseMenuService = baseMenuService;
	}

	public ScopeService getBaseScopeService() {
		return baseScopeService;
	}

	public void setBaseScopeService(ScopeService baseScopeService) {
		this.baseScopeService = baseScopeService;
	}

	public DatadictionaryService getBaseDatadictionaryService() {
		return baseDatadictionaryService;
	}

	public void setBaseDatadictionaryService(DatadictionaryService baseDatadictionaryService) {
		this.baseDatadictionaryService = baseDatadictionaryService;
	}

	public static String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public static void setIMAGE_PATH(String iMAGE_PATH) {
		IMAGE_PATH = iMAGE_PATH;
	}

	public static String getROOT_PATH() {
		return ROOT_PATH;
	}

	public static void setROOT_PATH(String rOOT_PATH) {
		ROOT_PATH = rOOT_PATH;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
