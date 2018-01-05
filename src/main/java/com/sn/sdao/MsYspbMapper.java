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



public interface MsYspbMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(MsYspb record);

	    int insertSelective(MsYspb record);

	    MsYspb selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(MsYspb record);

	    int updateByPrimaryKey(MsYspb record);
	    
	    List<MsYspb> selectByColum(MsYspb record);
	    
	    int deleteByColum(MsYspb record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<MsYspb>  selectLikeColum (String columName,String value);
	    
	    List<MsYspb>  selectByCustom (MsYspb record);
	    
	    int countByColum(MsYspb record);
	    
	    List<MsYspb> selectAll();

}
