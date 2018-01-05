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

public interface  MsYspbService{ 
	
	public int deleteById(String id);

	public int insert(MsYspb record);

	public int insertSelective(MsYspb record);

	public MsYspb findById(String fuid);

	public int updateSelective(MsYspb record);

	public int update(MsYspb record);
    
	public List<MsYspb> selectByColum(MsYspb record,String orderBy);
	
	public  int deleteByColum(MsYspb record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<MsYspb>  selectLikeColum (String columName,String value);
	
	public PagedResult<MsYspb> findByPage(MsYspb record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<MsYspb> findByPageCustom(MsYspb record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(MsYspb record);
	
	public List<MsYspb> selectAll(String order);
	
}
