package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
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


@Service("gloginerrorService")
public class GloginerrorServiceImpl implements GloginerrorService{
	
	@Autowired
	private GloginerrorMapper gloginerrorMapper;

	public GloginerrorMapper getGloginerrorMapper() {
		return gloginerrorMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.gloginerrorMapper = gloginerrorMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Gloginerror record) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.insert(record);
	}

	@Override
	public int insertSelective(Gloginerror record) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.insertSelective(record);
	}

	@Override
	public Gloginerror findById(String fuid) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Gloginerror record) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Gloginerror record) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Gloginerror record){
		// TODO Auto-generated method stub
		return gloginerrorMapper.deleteByColum(record);
	}
	
	@Override
	public List<Gloginerror> selectByColum(Gloginerror record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return gloginerrorMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return gloginerrorMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Gloginerror>  selectLikeColum (Gloginerror record,String orderBy){
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return gloginerrorMapper.selectLikeColum(record);
	}
	
	@Override
	public PagedResult<Gloginerror> findByPage(Gloginerror record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gloginerrorMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Gloginerror> findByPageCustom(Gloginerror record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gloginerrorMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Gloginerror record) {
		// TODO Auto-generated method stub
		return gloginerrorMapper.countByColum(record);
	}
	@Override
	public List<Gloginerror> selectAll(String order){
		PageHelper.orderBy(order);
		return gloginerrorMapper.selectAll();
	}
}
