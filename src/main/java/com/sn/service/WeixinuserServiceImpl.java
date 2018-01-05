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


@Service("weixinuserService")
public class WeixinuserServiceImpl implements WeixinuserService{
	
	@Autowired
	private WeixinuserMapper weixinuserMapper;

	public WeixinuserMapper getWeixinuserMapper() {
		return weixinuserMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.weixinuserMapper = weixinuserMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return weixinuserMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Weixinuser record) {
		// TODO Auto-generated method stub
		return weixinuserMapper.insert(record);
	}

	@Override
	public int insertSelective(Weixinuser record) {
		// TODO Auto-generated method stub
		return weixinuserMapper.insertSelective(record);
	}

	@Override
	public Weixinuser findById(String fuid) {
		// TODO Auto-generated method stub
		return weixinuserMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Weixinuser record) {
		// TODO Auto-generated method stub
		return weixinuserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Weixinuser record) {
		// TODO Auto-generated method stub
		return weixinuserMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Weixinuser record){
		// TODO Auto-generated method stub
		return weixinuserMapper.deleteByColum(record);
	}
	
	@Override
	public List<Weixinuser> selectByColum(Weixinuser record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return weixinuserMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return weixinuserMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Weixinuser>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return weixinuserMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Weixinuser> findByPage(Weixinuser record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(weixinuserMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Weixinuser> findByPageCustom(Weixinuser record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(weixinuserMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Weixinuser record) {
		// TODO Auto-generated method stub
		return weixinuserMapper.countByColum(record);
	}
	@Override
	public List<Weixinuser> selectAll(String order){
		PageHelper.orderBy(order);
		return weixinuserMapper.selectAll();
	}
}
