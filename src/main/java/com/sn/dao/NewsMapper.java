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



public interface NewsMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(News record);

	    int insertSelective(News record);

	    News selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(News record);

	    int updateByPrimaryKey(News record);
	    
	    List<News> selectByColum(News record);
	    
	    int deleteByColum(News record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<News>  selectLikeColum (String columName,String value);
	    
	    List<News>  selectByCustom (News record);
	    
	    int countByColum(News record);
	    
	    List<News> selectAll();

}
