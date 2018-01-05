package com.sn.dao;

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


import java.util.List; 



public interface SmsrecordMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Smsrecord record);

	    int insertSelective(Smsrecord record);

	    Smsrecord selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Smsrecord record);

	    int updateByPrimaryKey(Smsrecord record);
	    
	    List<Smsrecord> selectByColum(Smsrecord record);
	    
	    int deleteByColum(Smsrecord record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Smsrecord>  selectLikeColum (String columName,String value);
	    
	    List<Smsrecord>  selectByCustom (Smsrecord record);
	    
	    int countByColum(Smsrecord record);
	    
	    List<Smsrecord> selectAll();

}
