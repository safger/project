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



public interface YgdmMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Ygdm record);

	    int insertSelective(Ygdm record);

	    Ygdm selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Ygdm record);

	    int updateByPrimaryKey(Ygdm record);
	    
	    List<Ygdm> selectByColum(Ygdm record);
	    
	    int deleteByColum(Ygdm record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Ygdm>  selectLikeColum (String columName,String value);
	    
	    List<Ygdm>  selectByCustom (Ygdm record);
	    
	    int countByColum(Ygdm record);
	    
	    List<Ygdm> selectAll();

}
