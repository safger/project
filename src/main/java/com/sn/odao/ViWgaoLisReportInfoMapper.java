package com.sn.odao;

import java.util.List;

import com.sn.entity.ViWgaoLisReportInfo;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface ViWgaoLisReportInfoMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(ViWgaoLisReportInfo record);

	    int insertSelective(ViWgaoLisReportInfo record);

	    ViWgaoLisReportInfo selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(ViWgaoLisReportInfo record);

	    int updateByPrimaryKey(ViWgaoLisReportInfo record);
	    
	    List<ViWgaoLisReportInfo> selectByColum(ViWgaoLisReportInfo record);
	    
	    int deleteByColum(ViWgaoLisReportInfo record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<ViWgaoLisReportInfo>  selectLikeColum (String columName,String value);
	    
	    List<ViWgaoLisReportInfo>  selectByCustom (ViWgaoLisReportInfo record);
	    
	    int countByColum(ViWgaoLisReportInfo record);
	    
	    List<ViWgaoLisReportInfo> selectAll();

}
