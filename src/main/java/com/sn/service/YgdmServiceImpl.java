package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.Ygdm;
import com.sn.sdao.YgdmMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("ygdmService")
public class YgdmServiceImpl implements YgdmService{
	
	@Autowired
	private YgdmMapper ygdmMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return ygdmMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(Ygdm record) {
		// TODO Auto-generated method stub
		return ygdmMapper.insert(record);
	}

	@Override
	public int insertSelective(Ygdm record) {
		// TODO Auto-generated method stub
		return ygdmMapper.insertSelective(record);
	}

	@Override
	public Ygdm findById(String fuid) {
		// TODO Auto-generated method stub
		return ygdmMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(Ygdm record) {
		// TODO Auto-generated method stub
		return ygdmMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(Ygdm record) {
		// TODO Auto-generated method stub
		return ygdmMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(Ygdm record){
		// TODO Auto-generated method stub
		return ygdmMapper.deleteByColum(record);
	}
	
	@Override
	public List<Ygdm> selectByColum(Ygdm record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return ygdmMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return ygdmMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<Ygdm>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return ygdmMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<Ygdm> findByPage(Ygdm record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(ygdmMapper.selectByColum(record));
	}

	@Override
	public PagedResult<Ygdm> findByPageCustom(Ygdm record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(ygdmMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(Ygdm record) {
		// TODO Auto-generated method stub
		return ygdmMapper.countByColum(record);
	}
	@Override
	public List<Ygdm> selectAll(String order){
		PageHelper.orderBy(order);
		return ygdmMapper.selectAll();
	}
}
