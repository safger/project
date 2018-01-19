package com.sn.service;

import com.sn.entity.Doctors;
import com.sn.util.PagedResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

public interface  DoctorsService{ 
	
	public int deleteById(String id);

	public int insert(Doctors record);

	public int insertSelective(Doctors record);
	
	public int insertImgSelective(Doctors record, MultipartFile file1, MultipartFile file2) throws IOException ;

	public int updateImgSelective(Doctors record, MultipartFile file1, MultipartFile file2) throws IOException ;

	public Doctors findById(String fuid);

	public int updateSelective(Doctors record);

	public int update(Doctors record);

	public List<Doctors> selectByColum(Doctors record, String orderBy);

	public  int deleteByColum(Doctors record);

	public int deleteByByPrimaryKeys(List<String> ids);

	public List<Doctors>  selectLikeColum(Doctors record, String orderBy);

	public PagedResult<Doctors> findByPage(Doctors record, Integer indexPage, Integer pageSize, String orderBy);

	public PagedResult<Doctors> findByPageCustom(Doctors record, Integer indexPage, Integer pageSize, String orderBy);
	
	public int countByColum(Doctors record);
	
	public List<Doctors> selectAll(String order);
	
}
