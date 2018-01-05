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



public interface MsYspbMxMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(MsYspbMx record);

	    int insertSelective(MsYspbMx record);

	    MsYspbMx selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(MsYspbMx record);

	    int updateByPrimaryKey(MsYspbMx record);
	    
	    List<MsYspbMx> selectByColum(MsYspbMx record);
	    
	    int deleteByColum(MsYspbMx record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<MsYspbMx>  selectLikeColum (String columName,String value);
	    
	    List<MsYspbMx>  selectByCustom (MsYspbMx record);
	    
	    int countByColum(MsYspbMx record);
	    
	    List<MsYspbMx> selectAll();
	    
	    List<MsYspbMx> selectByGroup(MsYspbMx record);
	    
	    List<MsYspbMx> selectByYsks(MsYspbMx record);  
	    
	    List<MsYspbMx> selectByGroupTime(MsYspbMx record);  

}
