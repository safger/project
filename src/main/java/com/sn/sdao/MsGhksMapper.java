package com.sn.sdao;

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



public interface MsGhksMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(MsGhks record);

	    int insertSelective(MsGhks record);

	    MsGhks selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(MsGhks record);

	    int updateByPrimaryKey(MsGhks record);
	    
	    List<MsGhks> selectByColum(MsGhks record);
	    
	    int deleteByColum(MsGhks record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<MsGhks>  selectLikeColum (String columName,String value);
	    
	    List<MsGhks>  selectByCustom (MsGhks record);
	    
	    int countByColum(MsGhks record);
	    
	    List<MsGhks> selectAll();

}
