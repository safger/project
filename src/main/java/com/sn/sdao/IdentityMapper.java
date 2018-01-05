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



public interface IdentityMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(Identity record);

	    int insertSelective(Identity record);

	    Identity selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(Identity record);

	    int updateByPrimaryKey(Identity record);
	    
	    List<Identity> selectByColum(Identity record);
	    
	    int deleteByColum(Identity record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<Identity>  selectLikeColum (String columName,String value);
	    
	    List<Identity>  selectByCustom (Identity record);
	    
	    int countByColum(Identity record);
	    
	    List<Identity> selectAll();

}
