package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Greg;
import com.sn.entity.Guser;
import com.sn.entity.User;
import com.sn.util.BeanUtil;
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


@Service("gregService")
public class GregServiceImpl implements GregService{
	
	@Autowired
	private GregMapper gregMapper;

	public GregMapper getGregMapper() {
		return gregMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.gregMapper = gregMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return gregMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Greg record) {
		// TODO Auto-generated method stub
		return gregMapper.insert(record);
	}

	@Override
	public int insertSelective(Greg record) {
		// TODO Auto-generated method stub
		return gregMapper.insertSelective(record);
	}

	@Override
	public Greg findById(String fuid) {
		// TODO Auto-generated method stub
		return gregMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Greg record) {
		// TODO Auto-generated method stub
		return gregMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Greg record) {
		// TODO Auto-generated method stub
		return gregMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Greg record){
		// TODO Auto-generated method stub
		return gregMapper.deleteByColum(record);
	}
	
	@Override
	public List<Greg> selectByColum(Greg record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return gregMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return gregMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Greg>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return gregMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Greg> findByPage(Greg record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gregMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Greg> findByPageCustom(Greg record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gregMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Greg record) {
		// TODO Auto-generated method stub
		return gregMapper.countByColum(record);
	}
	@Override
	public List<Greg> selectAll(String order){
		PageHelper.orderBy(order);
		return gregMapper.selectAll();
	}

	@Override
	public List<Greg> selectByView(Guser record) {
		// TODO Auto-generated method stub
		return gregMapper.selectByView(record);
	}
}
