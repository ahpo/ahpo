/**   
 * @Title: SysRoleRFMapper.java 
 * @Package com.sys.dao 
 * @author zgr  
 * @date 2012-5-8 下午12:06:02 
 * @version V1.0   
 */
package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SysRoleRFMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-8 下午12:06:02
 * @version 1.0
 */
@Repository
public interface SysRoleRFMapper {

	List<Integer> selectIDFromRFByResIdAndFuncId(@Param("resid") Integer resid,
			@Param("funcid") Integer funcid);

	int insertIntoRoleRF(@Param("rid") Integer rid, @Param("rfid") Integer rfid);

	int deleteRoleRFByRid(Integer rid);
}
