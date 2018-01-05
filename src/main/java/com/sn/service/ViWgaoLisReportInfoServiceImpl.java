package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.ViWgaoLisReportInfo;
import com.sn.odao.ViWgaoLisReportInfoMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("viWgaoLisReportInfoService")
public class ViWgaoLisReportInfoServiceImpl implements ViWgaoLisReportInfoService{
	
	@Autowired
	private ViWgaoLisReportInfoMapper viWgaoLisReportInfoMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(ViWgaoLisReportInfo record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(ViWgaoLisReportInfo record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.insertSelective(record);
	}

	@Override
	public ViWgaoLisReportInfo findById(String fuid) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(ViWgaoLisReportInfo record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(ViWgaoLisReportInfo record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(ViWgaoLisReportInfo record){
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.deleteByColum(record);
	}
	
	@Override
	public List<ViWgaoLisReportInfo> selectByColum(ViWgaoLisReportInfo record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return viWgaoLisReportInfoMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<ViWgaoLisReportInfo>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<ViWgaoLisReportInfo> findByPage(ViWgaoLisReportInfo record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(viWgaoLisReportInfoMapper.selectByColum(record));
	}

	@Override
	public PagedResult<ViWgaoLisReportInfo> findByPageCustom(ViWgaoLisReportInfo record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(viWgaoLisReportInfoMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(ViWgaoLisReportInfo record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportInfoMapper.countByColum(record);
	}
	@Override
	public List<ViWgaoLisReportInfo> selectAll(String order){
		PageHelper.orderBy(order);
		return viWgaoLisReportInfoMapper.selectAll();
	}
}
