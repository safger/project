package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.GyDmzd;
import com.sn.sdao.GyDmzdMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("gyDmzdService")
public class GyDmzdServiceImpl implements GyDmzdService{
	
	@Autowired
	private GyDmzdMapper gyDmzdMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(GyDmzd record) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.insert(record);
	}

	@Override
	public int insertSelective(GyDmzd record) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.insertSelective(record);
	}

	@Override
	public GyDmzd findById(String fuid) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(GyDmzd record) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(GyDmzd record) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(GyDmzd record){
		// TODO Auto-generated method stub
		return gyDmzdMapper.deleteByColum(record);
	}
	
	@Override
	public List<GyDmzd> selectByColum(GyDmzd record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return gyDmzdMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return gyDmzdMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<GyDmzd>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return gyDmzdMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<GyDmzd> findByPage(GyDmzd record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gyDmzdMapper.selectByColum(record));
	}

	@Override
	public PagedResult<GyDmzd> findByPageCustom(GyDmzd record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(gyDmzdMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(GyDmzd record) {
		// TODO Auto-generated method stub
		return gyDmzdMapper.countByColum(record);
	}
	@Override
	public List<GyDmzd> selectAll(String order){
		PageHelper.orderBy(order);
		return gyDmzdMapper.selectAll();
	}
}
