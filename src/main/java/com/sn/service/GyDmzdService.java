package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

public interface  GyDmzdService{ 
	
	public int deleteById(String id);

	public int insert(GyDmzd record);

	public int insertSelective(GyDmzd record);

	public GyDmzd findById(String fuid);

	public int updateSelective(GyDmzd record);

	public int update(GyDmzd record);
    
	public List<GyDmzd> selectByColum(GyDmzd record,String orderBy);
	
	public  int deleteByColum(GyDmzd record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<GyDmzd>  selectLikeColum (String columName,String value);
	
	public PagedResult<GyDmzd> findByPage(GyDmzd record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<GyDmzd> findByPageCustom(GyDmzd record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(GyDmzd record);
	
	public List<GyDmzd> selectAll(String order);
	
}
