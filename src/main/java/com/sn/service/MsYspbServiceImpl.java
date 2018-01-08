package com.sn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sn.entity.MsYspb;
import com.sn.sdao.MsYspbMapper;
import com.sn.util.BeanUtil;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */


@Service("msYspbService")
public class MsYspbServiceImpl implements MsYspbService {

    @Autowired
    private MsYspbMapper msYspbMapper;


    @Override
    public int deleteById(String fuid) {
        // TODO Auto-generated method stub
        return msYspbMapper.deleteByPrimaryKey(fuid);
    }

    @Override
    public int insert(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.insert(record);
    }

    @Override
    public int insertSelective(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.insertSelective(record);
    }

    @Override
    public MsYspb findById(String fuid) {
        // TODO Auto-generated method stub
        return msYspbMapper.selectByPrimaryKey(fuid);
    }

    @Override
    public int updateSelective(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int update(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByColum(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.deleteByColum(record);
    }

    @Override
    public List<MsYspb> selectByColum(MsYspb record, String orderBy) {
        // TODO Auto-generated method stub
        PageHelper.orderBy(orderBy);
        return msYspbMapper.selectByColum(record);
    }

    @Override
    public int deleteByByPrimaryKeys(List<String> ids) {
        // TODO Auto-generated method stub
        return msYspbMapper.deleteByByPrimaryKeys(ids);
    }

    @Override
    public List<MsYspb> selectLikeColum(String columName, String value) {
        // TODO Auto-generated method stub
        return msYspbMapper.selectLikeColum(columName, value);
    }

    @Override
    public PagedResult<MsYspb> findByPage(MsYspb record, Integer pageNo,
                                          Integer pageSize, String orderBy) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.orderBy(orderBy);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(msYspbMapper.selectByColum(record));
    }

    @Override
    public PagedResult<MsYspb> findByPageCustom(MsYspb record, Integer pageNo, Integer pageSize, String orderBy) {
        // TODO Auto-generated method stub
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.orderBy(orderBy);
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(msYspbMapper.selectByCustom(record));
    }

    @Override
    public int countByColum(MsYspb record) {
        // TODO Auto-generated method stub
        return msYspbMapper.countByColum(record);
    }

    @Override
    public List<MsYspb> selectAll(String order) {
        PageHelper.orderBy(order);
        return msYspbMapper.selectAll();
    }

    @Override
    public List<MsYspb> selectByYspb(MsYspb msYspb) {

        return msYspbMapper.selectByYspb(msYspb);
    }

    @Override
    public List<MsYspb> selectByYspbMx(MsYspb msYspb) {
        return msYspbMapper.selectByYspbMx(msYspb);
    }

}
