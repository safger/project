package com.sn.odao;

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



public interface VlisAppPatientinfoMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(VlisAppPatientinfo record);

	    int insertSelective(VlisAppPatientinfo record);

	    VlisAppPatientinfo selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(VlisAppPatientinfo record);

	    int updateByPrimaryKey(VlisAppPatientinfo record);
	    
	    List<VlisAppPatientinfo> selectByColum(VlisAppPatientinfo record);
	    
	    int deleteByColum(VlisAppPatientinfo record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<VlisAppPatientinfo>  selectLikeColum (String columName,String value);
	    
	    List<VlisAppPatientinfo>  selectByCustom (VlisAppPatientinfo record);
	    
	    int countByColum(VlisAppPatientinfo record);
	    
	    List<VlisAppPatientinfo> selectAll();

}
