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

public interface  VlisAppResultService{ 
	
	public int deleteById(String id);

	public int insert(VlisAppResult record);

	public int insertSelective(VlisAppResult record);

	public VlisAppResult findById(String fuid);

	public int updateSelective(VlisAppResult record);

	public int update(VlisAppResult record);
    
	public List<VlisAppResult> selectByColum(VlisAppResult record,String orderBy);
	
	public  int deleteByColum(VlisAppResult record);
	
	public int deleteByByPrimaryKeys(List<String> ids);
	
	public List<VlisAppResult>  selectLikeColum (String columName,String value);
	
	public PagedResult<VlisAppResult> findByPage(VlisAppResult record,Integer indexPage,Integer pageSize,String orderBy );
	
	public PagedResult<VlisAppResult> findByPageCustom(VlisAppResult record, Integer indexPage,Integer pageSize,String orderBy);
	
	public int countByColum(VlisAppResult record);
	
	public List<VlisAppResult> selectAll(String order);
	
}
