package com.sn.odao;

import java.util.List;

import com.sn.entity.VlisWeixinPatientinfo;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface VlisWeixinPatientinfoMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(VlisWeixinPatientinfo record);

	    int insertSelective(VlisWeixinPatientinfo record);

	    VlisWeixinPatientinfo selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(VlisWeixinPatientinfo record);

	    int updateByPrimaryKey(VlisWeixinPatientinfo record);
	    
	    List<VlisWeixinPatientinfo> selectByColum(VlisWeixinPatientinfo record);
	    
	    int deleteByColum(VlisWeixinPatientinfo record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<VlisWeixinPatientinfo>  selectLikeColum (String columName,String value);
	    
	    List<VlisWeixinPatientinfo>  selectByCustom (VlisWeixinPatientinfo record);
	    
	    int countByColum(VlisWeixinPatientinfo record);
	    
	    List<VlisWeixinPatientinfo> selectAll();

}
