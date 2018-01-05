package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.Greg;
import com.sn.entity.Guser;
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

public interface  GregService{ 
	
	public int deleteById(String id);

	public int insert(Greg record);

	public int insertSelective(Greg record);

	public Greg findById(String fuid);

	public int updateSelective(Greg record);

	public int update(Greg record);
    
	public List<Greg> selectByColum(Greg record,String orderBy);
	
	public  int deleteByColum(Greg record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Greg>  selectLikeColum (String columName,String value);
	
	public PagedResult<Greg> findByPage(Greg record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Greg> findByPageCustom(Greg record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Greg record);
	
	public List<Greg> selectAll(String order);
	
	public  List<Greg> selectByView(Guser record);
}
