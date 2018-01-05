package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.MsGhks;
import com.sn.sdao.MsGhksMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("msGhksService")
public class MsGhksServiceImpl implements MsGhksService{
	
	@Autowired
	private MsGhksMapper msGhksMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return msGhksMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(MsGhks record) {
		// TODO Auto-generated method stub
		return msGhksMapper.insert(record);
	}

	@Override
	public int insertSelective(MsGhks record) {
		// TODO Auto-generated method stub
		return msGhksMapper.insertSelective(record);
	}

	@Override
	public MsGhks findById(String fuid) {
		// TODO Auto-generated method stub
		return msGhksMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(MsGhks record) {
		// TODO Auto-generated method stub
		return msGhksMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(MsGhks record) {
		// TODO Auto-generated method stub
		return msGhksMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(MsGhks record){
		// TODO Auto-generated method stub
		return msGhksMapper.deleteByColum(record);
	}
	
	@Override
	public List<MsGhks> selectByColum(MsGhks record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return msGhksMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return msGhksMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<MsGhks>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return msGhksMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<MsGhks> findByPage(MsGhks record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msGhksMapper.selectByColum(record));
	}

	@Override
	public PagedResult<MsGhks> findByPageCustom(MsGhks record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msGhksMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(MsGhks record) {
		// TODO Auto-generated method stub
		return msGhksMapper.countByColum(record);
	}
	@Override
	public List<MsGhks> selectAll(String order){
		PageHelper.orderBy(order);
		return msGhksMapper.selectAll();
	}
}
