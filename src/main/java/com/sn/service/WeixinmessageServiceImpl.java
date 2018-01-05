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


@Service("weixinmessageService")
public class WeixinmessageServiceImpl implements WeixinmessageService{
	
	@Autowired
	private WeixinmessageMapper weixinmessageMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Weixinmessage record) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.insert(record);
	}

	@Override
	public int insertSelective(Weixinmessage record) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.insertSelective(record);
	}

	@Override
	public Weixinmessage findById(String fuid) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Weixinmessage record) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Weixinmessage record) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Weixinmessage record){
		// TODO Auto-generated method stub
		return weixinmessageMapper.deleteByColum(record);
	}
	
	@Override
	public List<Weixinmessage> selectByColum(Weixinmessage record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return weixinmessageMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return weixinmessageMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Weixinmessage>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return weixinmessageMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Weixinmessage> findByPage(Weixinmessage record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(weixinmessageMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Weixinmessage> findByPageCustom(Weixinmessage record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(weixinmessageMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Weixinmessage record) {
		// TODO Auto-generated method stub
		return weixinmessageMapper.countByColum(record);
	}
	@Override
	public List<Weixinmessage> selectAll(String order){
		PageHelper.orderBy(order);
		return weixinmessageMapper.selectAll();
	}
}
