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

public interface  SmsrecordService{ 
	
	public int deleteById(String id);

	public int insert(Smsrecord record);

	public int insertSelective(Smsrecord record);

	public Smsrecord findById(String fuid);

	public int updateSelective(Smsrecord record);

	public int update(Smsrecord record);
    
	public List<Smsrecord> selectByColum(Smsrecord record,String orderBy);
	
	public  int deleteByColum(Smsrecord record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Smsrecord>  selectLikeColum (String columName,String value);
	
	public PagedResult<Smsrecord> findByPage(Smsrecord record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Smsrecord> findByPageCustom(Smsrecord record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Smsrecord record);
	
	public List<Smsrecord> selectAll(String order);
	
}
