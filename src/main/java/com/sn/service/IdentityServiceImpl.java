package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Identity;
import com.sn.sdao.IdentityMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("identityService")
public class IdentityServiceImpl implements IdentityService{
	
	@Autowired
	private IdentityMapper identityMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return identityMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Identity record) {
		// TODO Auto-generated method stub
		return identityMapper.insert(record);
	}

	@Override
	public int insertSelective(Identity record) {
		// TODO Auto-generated method stub
		return identityMapper.insertSelective(record);
	}

	@Override
	public Identity findById(String fuid) {
		// TODO Auto-generated method stub
		return identityMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Identity record) {
		// TODO Auto-generated method stub
		return identityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Identity record) {
		// TODO Auto-generated method stub
		return identityMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Identity record){
		// TODO Auto-generated method stub
		return identityMapper.deleteByColum(record);
	}
	
	@Override
	public List<Identity> selectByColum(Identity record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return identityMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return identityMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Identity>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return identityMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Identity> findByPage(Identity record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(identityMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Identity> findByPageCustom(Identity record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(identityMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Identity record) {
		// TODO Auto-generated method stub
		return identityMapper.countByColum(record);
	}
	@Override
	public List<Identity> selectAll(String order){
		PageHelper.orderBy(order);
		return identityMapper.selectAll();
	}
}
