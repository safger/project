package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.User;
import com.sn.util.PagedResult;



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

public interface  IdentityService{ 
	
	public int deleteById(String id);

	public int insert(Identity record);

	public int insertSelective(Identity record);

	public Identity findById(String fuid);

	public int updateSelective(Identity record);

	public int update(Identity record);
    
	public List<Identity> selectByColum(Identity record,String orderBy);
	
	public  int deleteByColum(Identity record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Identity>  selectLikeColum (String columName,String value);
	
	public PagedResult<Identity> findByPage(Identity record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Identity> findByPageCustom(Identity record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Identity record);
	
	public List<Identity> selectAll(String order);
	
}
