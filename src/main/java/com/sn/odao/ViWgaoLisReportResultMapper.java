package com.sn.odao;

import java.util.List;

import com.sn.entity.ViWgaoLisReportResult;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface ViWgaoLisReportResultMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(ViWgaoLisReportResult record);

	    int insertSelective(ViWgaoLisReportResult record);

	    ViWgaoLisReportResult selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(ViWgaoLisReportResult record);

	    int updateByPrimaryKey(ViWgaoLisReportResult record);
	    
	    List<ViWgaoLisReportResult> selectByColum(ViWgaoLisReportResult record);
	    
	    int deleteByColum(ViWgaoLisReportResult record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<ViWgaoLisReportResult>  selectLikeColum (String columName,String value);
	    
	    List<ViWgaoLisReportResult>  selectByCustom (ViWgaoLisReportResult record);
	    
	    int countByColum(ViWgaoLisReportResult record);
	    
	    List<ViWgaoLisReportResult> selectAll();

}
