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


@Service("smsrecordService")
public class SmsrecordServiceImpl implements SmsrecordService{
	
	@Autowired
	private SmsrecordMapper smsrecordMapper;

	public SmsrecordMapper getSmsrecordMapper() {
		return smsrecordMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.smsrecordMapper = smsrecordMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return smsrecordMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Smsrecord record) {
		// TODO Auto-generated method stub
		return smsrecordMapper.insert(record);
	}

	@Override
	public int insertSelective(Smsrecord record) {
		// TODO Auto-generated method stub
		return smsrecordMapper.insertSelective(record);
	}

	@Override
	public Smsrecord findById(String fuid) {
		// TODO Auto-generated method stub
		return smsrecordMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Smsrecord record) {
		// TODO Auto-generated method stub
		return smsrecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Smsrecord record) {
		// TODO Auto-generated method stub
		return smsrecordMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Smsrecord record){
		// TODO Auto-generated method stub
		return smsrecordMapper.deleteByColum(record);
	}
	
	@Override
	public List<Smsrecord> selectByColum(Smsrecord record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return smsrecordMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return smsrecordMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Smsrecord>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return smsrecordMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Smsrecord> findByPage(Smsrecord record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(smsrecordMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Smsrecord> findByPageCustom(Smsrecord record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(smsrecordMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Smsrecord record) {
		// TODO Auto-generated method stub
		return smsrecordMapper.countByColum(record);
	}
	@Override
	public List<Smsrecord> selectAll(String order){
		PageHelper.orderBy(order);
		return smsrecordMapper.selectAll();
	}
}
