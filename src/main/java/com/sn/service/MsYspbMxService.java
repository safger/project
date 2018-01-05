package com.sn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sn.entity.MsYspbMx;
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

public interface  MsYspbMxService{ 
	
	public int deleteById(String id);

	public int insert(MsYspbMx record);

	public int insertSelective(MsYspbMx record);

	public MsYspbMx findById(String fuid);

	public int updateSelective(MsYspbMx record);

	public int update(MsYspbMx record);
    
	public List<MsYspbMx> selectByColum(MsYspbMx record,String orderBy);
	
	public  int deleteByColum(MsYspbMx record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<MsYspbMx>  selectLikeColum (String columName,String value);
	
	public PagedResult<MsYspbMx> findByPage(MsYspbMx record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<MsYspbMx> findByPageCustom(MsYspbMx record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(MsYspbMx record);
	
	public List<MsYspbMx> selectAll(String order);
	
	public  List<MsYspbMx> selectByGroup(MsYspbMx record);
	
	public  List<MsYspbMx> selectByYsks(MsYspbMx record);  
	
	public List<MsYspbMx> selectByGroupTime(MsYspbMx record);  
	
}
