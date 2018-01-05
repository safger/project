package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.VlisAppResult;
import com.sn.odao.VlisAppResultMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */
 

@Service("vlisAppResultService")
public class VlisAppResultServiceImpl implements VlisAppResultService{
	
	@Autowired
	private VlisAppResultMapper vlisAppResultMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(VlisAppResult record) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.insert(record);
	}

	@Override
	public int insertSelective(VlisAppResult record) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.insertSelective(record);
	}

	@Override
	public VlisAppResult findById(String fuid) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(VlisAppResult record) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(VlisAppResult record) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(VlisAppResult record){
		// TODO Auto-generated method stub
		return vlisAppResultMapper.deleteByColum(record);
	}
	
	@Override
	public List<VlisAppResult> selectByColum(VlisAppResult record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return vlisAppResultMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return vlisAppResultMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<VlisAppResult>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return vlisAppResultMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<VlisAppResult> findByPage(VlisAppResult record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisAppResultMapper.selectByColum(record));
	}

	@Override
	public PagedResult<VlisAppResult> findByPageCustom(VlisAppResult record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(vlisAppResultMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(VlisAppResult record) {
		// TODO Auto-generated method stub
		return vlisAppResultMapper.countByColum(record);
	}
	@Override
	public List<VlisAppResult> selectAll(String order){
		PageHelper.orderBy(order);
		return vlisAppResultMapper.selectAll();
	}
}
