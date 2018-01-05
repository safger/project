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



public interface GregMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Greg record);

	    int insertSelective(Greg record);

	    Greg selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Greg record);

	    int updateByPrimaryKey(Greg record);
	    
	    List<Greg> selectByColum(Greg record);
	    
	    int deleteByColum(Greg record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Greg>  selectLikeColum (String columName,String value);
	    
	    List<Greg>  selectByCustom (Greg record);
	    
	    int countByColum(Greg record);
	    
	    List<Greg> selectAll();
	    List<Greg> selectByView(Guser record);
}
