package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.ViWgaoLisReportResult;
import com.sn.odao.ViWgaoLisReportResultMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("viWgaoLisReportResultService")
public class ViWgaoLisReportResultServiceImpl implements ViWgaoLisReportResultService{
	
	@Autowired
	private ViWgaoLisReportResultMapper viWgaoLisReportResultMapper;

	 

	@Override
	public int deleteById(String fuid) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.deleteByPrimaryKey(fuid);
	}

	@Override
	public int insert(ViWgaoLisReportResult record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.insert(record);
	}

	@Override
	public int insertSelective(ViWgaoLisReportResult record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.insertSelective(record);
	}

	@Override
	public ViWgaoLisReportResult findById(String fuid) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.selectByPrimaryKey(fuid);
	}

	@Override
	public int updateSelective(ViWgaoLisReportResult record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(ViWgaoLisReportResult record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public  int deleteByColum(ViWgaoLisReportResult record){
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.deleteByColum(record);
	}
	
	@Override
	public List<ViWgaoLisReportResult> selectByColum(ViWgaoLisReportResult record,String orderBy) {
		// TODO Auto-generated method stub
		PageHelper.orderBy(orderBy);
		return viWgaoLisReportResultMapper.selectByColum(record);
	}
	
	@Override
	public int deleteByByPrimaryKeys(List<String> ids){
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.deleteByByPrimaryKeys(ids);
	}
	
	@Override
	public List<ViWgaoLisReportResult>  selectLikeColum (String columName,String value){
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.selectLikeColum(columName,value);
	}
	
	@Override
	public PagedResult<ViWgaoLisReportResult> findByPage(ViWgaoLisReportResult record, Integer pageNo,
			Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(viWgaoLisReportResultMapper.selectByColum(record));
	}

	@Override
	public PagedResult<ViWgaoLisReportResult> findByPageCustom(ViWgaoLisReportResult record, Integer pageNo,Integer pageSize,String orderBy) {
		// TODO Auto-generated method stub
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.orderBy(orderBy);
		PageHelper.startPage(pageNo, pageSize);
		return BeanUtil.toPagedResult(viWgaoLisReportResultMapper.selectByCustom(record));
	}
	@Override
	public int countByColum(ViWgaoLisReportResult record) {
		// TODO Auto-generated method stub
		return viWgaoLisReportResultMapper.countByColum(record);
	}
	@Override
	public List<ViWgaoLisReportResult> selectAll(String order){
		PageHelper.orderBy(order);
		return viWgaoLisReportResultMapper.selectAll();
	}
}
