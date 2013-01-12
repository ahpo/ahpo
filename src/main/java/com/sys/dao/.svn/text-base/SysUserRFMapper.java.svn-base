/**   
 * @Title: SysUserRFMapper.java 
 * @Package com.sys.dao 
 * @author zgr  
 * @date 2012-5-8 上午9:16:41 
 * @version V1.0   
 */
package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SysUserRFMapper
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-8 上午9:16:41
 * @version 1.0
 */
@Repository
public interface SysUserRFMapper {

	List<Integer> selectIDFromRFByResIdAndFuncId(@Param("resid") Integer resid,
			@Param("funcid") Integer funcid);

	int insertIntoUserRF(@Param("uid") Integer uid, @Param("rfid") Integer rfid);

	int deleteUserRFByUid(Integer uid);
}
