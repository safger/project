package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.VlisAppPatientinfo;
import com.sn.odao.VlisAppPatientinfoMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("vlisAppPatientinfoService")
public class VlisAppPatientinfoServiceImpl implements VlisAppPatientinfoService{
	
	@Autowired
	private VlisAppPatientinfoMapper vlisAppPatientinfoMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VlisAppPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.insert(record);
	}

	@Override
	public int insertSelective(VlisAppPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.insertSelective(record);
	}

	@Override
	public VlisAppPatientinfo findById(String fuid) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VlisAppPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VlisAppPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VlisAppPatientinfo record){
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.deleteByColum(record);
	}
	
	@Override
	public List<VlisAppPatientinfo> selectByColum(VlisAppPatientinfo record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vlisAppPatientinfoMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VlisAppPatientinfo>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VlisAppPatientinfo> findByPage(VlisAppPatientinfo record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisAppPatientinfoMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VlisAppPatientinfo> findByPageCustom(VlisAppPatientinfo record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisAppPatientinfoMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VlisAppPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisAppPatientinfoMapper.countByColum(record);
	}
	@Override
	public List<VlisAppPatientinfo> selectAll(String order){
		PageHelper.orderBy(order);
		return vlisAppPatientinfoMapper.selectAll();
	}
}
