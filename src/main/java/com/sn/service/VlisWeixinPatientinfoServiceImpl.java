package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.VlisWeixinPatientinfo;
import com.sn.odao.VlisWeixinPatientinfoMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("vlisWeixinPatientinfoService")
public class VlisWeixinPatientinfoServiceImpl implements VlisWeixinPatientinfoService{
	
	@Autowired
	private VlisWeixinPatientinfoMapper vlisWeixinPatientinfoMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VlisWeixinPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.insert(record);
	}

	@Override
	public int insertSelective(VlisWeixinPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.insertSelective(record);
	}

	@Override
	public VlisWeixinPatientinfo findById(String fuid) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VlisWeixinPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VlisWeixinPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VlisWeixinPatientinfo record){
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.deleteByColum(record);
	}
	
	@Override
	public List<VlisWeixinPatientinfo> selectByColum(VlisWeixinPatientinfo record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vlisWeixinPatientinfoMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VlisWeixinPatientinfo>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VlisWeixinPatientinfo> findByPage(VlisWeixinPatientinfo record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisWeixinPatientinfoMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VlisWeixinPatientinfo> findByPageCustom(VlisWeixinPatientinfo record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisWeixinPatientinfoMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VlisWeixinPatientinfo record) {
		// TODO Auto-generated method stub
		return vlisWeixinPatientinfoMapper.countByColum(record);
	}
	@Override
	public List<VlisWeixinPatientinfo> selectAll(String order){
		PageHelper.orderBy(order);
		return vlisWeixinPatientinfoMapper.selectAll();
	}
}
