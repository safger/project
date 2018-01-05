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



public interface GuserMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Guser record);

	    int insertSelective(Guser record);

	    Guser selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Guser record);

	    int updateByPrimaryKey(Guser record);
	    
	    List<Guser> selectByColum(Guser record);
	    
	    int deleteByColum(Guser record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Guser>  selectLikeColum (Guser record);
	    
	    List<Guser>  selectByCustom (Guser record);
	    
	    int countByColum(Guser record);
	    
	    List<Guser> selectAll();
	    
	   

}
