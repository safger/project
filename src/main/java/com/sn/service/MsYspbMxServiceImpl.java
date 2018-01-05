package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.MsYspbMx;
import com.sn.sdao.MsYspbMxMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("msYspbMxService")
public class MsYspbMxServiceImpl implements MsYspbMxService{
	
	@Autowired
	private MsYspbMxMapper msYspbMxMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.insert(record);
	}

	@Override
	public int insertSelective(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.insertSelective(record);
	}

	@Override
	public MsYspbMx findById(String fuid) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(MsYspbMx record){
		// TODO Auto-generated method stub
		return msYspbMxMapper.deleteByColum(record);
	}
	
	@Override
	public List<MsYspbMx> selectByColum(MsYspbMx record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return msYspbMxMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return msYspbMxMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<MsYspbMx>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return msYspbMxMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<MsYspbMx> findByPage(MsYspbMx record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msYspbMxMapper.selectByColum(record));
	}

	@Override
	public PagedResult<MsYspbMx> findByPageCustom(MsYspbMx record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(msYspbMxMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.countByColum(record);
	}
	@Override
	public List<MsYspbMx> selectAll(String order){
		PageHelper.orderBy(order);
		return msYspbMxMapper.selectAll();
	}

	@Override
	public List<MsYspbMx> selectByGroup(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.selectByGroup(record);
	}

	@Override
	public List<MsYspbMx> selectByYsks(MsYspbMx record) { 
		// TODO Auto-generated method stub
		return msYspbMxMapper.selectByYsks(record);
	}

	@Override
	public List<MsYspbMx> selectByGroupTime(MsYspbMx record) {
		// TODO Auto-generated method stub
		return msYspbMxMapper.selectByGroupTime(record);
	}
}
