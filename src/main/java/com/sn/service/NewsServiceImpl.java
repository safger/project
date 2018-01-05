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


@Service("newsService")
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsMapper newsMapper;

	public NewsMapper getNewsMapper() {
		return newsMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.newsMapper = newsMapper;
	} 

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return newsMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insert(record);
	}

	@Override
	public int insertSelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.insertSelective(record);
	}

	@Override
	public News findById(String fuid) {
		// TODO Auto-generated method stub
		return newsMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(News record) {
		// TODO Auto-generated method stub
		return newsMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(News record){
		// TODO Auto-generated method stub
		return newsMapper.deleteByColum(record);
	}
	
	@Override
	public List<News> selectByColum(News record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return newsMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return newsMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<News>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return newsMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<News> findByPage(News record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(newsMapper.selectByColum(record));
	}

	@Override
	public PagedResult<News> findByPageCustom(News record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(newsMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(News record) {
		// TODO Auto-generated method stub
		return newsMapper.countByColum(record);
	}
	@Override
	public List<News> selectAll(String order){
		PageHelper.orderBy(order);
		return newsMapper.selectAll();
	}
}
