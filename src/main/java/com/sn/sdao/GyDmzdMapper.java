package com.sn.sdao;

import java.util.List;

import com.sn.entity.GyDmzd;
/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



public interface GyDmzdMapper {
	
	 int deleteByPrimaryKey(String fuid);

	    int insert(GyDmzd record);

	    int insertSelective(GyDmzd record);

	    GyDmzd selectByPrimaryKey(String fuid);

	    int updateByPrimaryKeySelective(GyDmzd record);

	    int updateByPrimaryKey(GyDmzd record);
	    
	    List<GyDmzd> selectByColum(GyDmzd record);
	    
	    int deleteByColum(GyDmzd record);
	 
	    int deleteByByPrimaryKeys(List<String> ids);
	    
	    List<GyDmzd>  selectLikeColum (String columName,String value);
	    
	    List<GyDmzd>  selectByCustom (GyDmzd record);
	    
	    int countByColum(GyDmzd record);
	    
	    List<GyDmzd> selectAll();

}
