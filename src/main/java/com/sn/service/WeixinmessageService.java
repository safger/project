package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.User;
import com.sn.util.PagedResult;



import java.util.*;
import java.io.IOException;  
 

import com.sn.entity.*;
import com.sn.dao.*;
import com.sn.service.*;  
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;
import javax.servlet.http.HttpServletRequest;
import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  WeixinmessageService{ 
	
	public int deleteById(String id);

	public int insert(Weixinmessage record);

	public int insertSelective(Weixinmessage record);

	public Weixinmessage findById(String fuid);

	public int updateSelective(Weixinmessage record);

	public int update(Weixinmessage record);
    
	public List<Weixinmessage> selectByColum(Weixinmessage record,String orderBy);
	
	public  int deleteByColum(Weixinmessage record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Weixinmessage>  selectLikeColum (String columName,String value);
	
	public PagedResult<Weixinmessage> findByPage(Weixinmessage record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Weixinmessage> findByPageCustom(Weixinmessage record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Weixinmessage record);
	
	public List<Weixinmessage> selectAll(String order);
	
}
