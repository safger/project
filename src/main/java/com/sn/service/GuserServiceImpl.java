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


@Service("guserService")
public class GuserServiceImpl implements GuserService{
	
	@Autowired
	private GuserMapper guserMapper;

	public GuserMapper getGuserMapper() {
		return guserMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.guserMapper = guserMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return guserMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Guser record) {
		// TODO Auto-generated method stub
		return guserMapper.insert(record);
	}

	@Override
	public int insertSelective(Guser record) {
		// TODO Auto-generated method stub
		return guserMapper.insertSelective(record);
	}

	@Override
	public Guser findById(String fuid) {
		// TODO Auto-generated method stub
		return guserMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Guser record) {
		// TODO Auto-generated method stub
		return guserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Guser record) {
		// TODO Auto-generated method stub
		return guserMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Guser record){
		// TODO Auto-generated method stub
		return guserMapper.deleteByColum(record);
	}
	
	@Override
	public List<Guser> selectByColum(Guser record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return guserMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return guserMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Guser>  selectLikeColum (Guser record){
		// TODO Auto-generated method stub
		return guserMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<Guser> findByPage(Guser record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(guserMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Guser> findByPageCustom(Guser record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(guserMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Guser record) {
		// TODO Auto-generated method stub
		return guserMapper.countByColum(record);
	}
	@Override
	public List<Guser> selectAll(String order){
		PageHelper.orderBy(order);
		return guserMapper.selectAll();
	}
}
