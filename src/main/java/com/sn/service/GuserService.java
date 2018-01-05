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

public interface  GuserService{ 
	
	public int deleteById(String id);

	public int insert(Guser record);

	public int insertSelective(Guser record);

	public Guser findById(String fuid);

	public int updateSelective(Guser record);

	public int update(Guser record);
    
	public List<Guser> selectByColum(Guser record,String orderBy);
	
	public  int deleteByColum(Guser record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<Guser>  selectLikeColum (Guser record);
	
	public PagedResult<Guser> findByPage(Guser record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<Guser> findByPageCustom(Guser record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(Guser record);
	
	public List<Guser> selectAll(String order);
	
	
}
