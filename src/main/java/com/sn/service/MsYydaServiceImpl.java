package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.MsYyda;
import com.sn.sdao.MsYydaMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("msYydaService")
public class MsYydaServiceImpl implements MsYydaService{
	
	@Autowired
	private MsYydaMapper msYydaMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return msYydaMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(MsYyda record) {
		// TODO Auto-generated method stub
		return msYydaMapper.insert(record);
	}

	@Override
	public int insertSelective(MsYyda record) {
		// TODO Auto-generated method stub
		return msYydaMapper.insertSelective(record);
	}

	@Override
	public MsYyda findById(String fuid) {
		// TODO Auto-generated method stub
		return msYydaMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(MsYyda record) {
		// TODO Auto-generated method stub
		return msYydaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(MsYyda record) {
		// TODO Auto-generated method stub
		return msYydaMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(MsYyda record){
		// TODO Auto-generated method stub
		return msYydaMapper.deleteByColum(record);
	}
	
	@Override
	public List<MsYyda> selectByColum(MsYyda record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return msYydaMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return msYydaMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<MsYyda>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return msYydaMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<MsYyda> findByPage(MsYyda record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msYydaMapper.selectByColum(record));
	}

	@Override
	public PagedResult<MsYyda> findByPageCustom(MsYyda record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msYydaMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(MsYyda record) {
		// TODO Auto-generated method stub
		return msYydaMapper.countByColum(record);
	}
	@Override
	public List<MsYyda> selectAll(String order){
		PageHelper.orderBy(order);
		return msYydaMapper.selectAll();
	}
}
