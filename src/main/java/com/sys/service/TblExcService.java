/**   
 * @Title: TblExcService.java 
 * @Package com.easygo.service.ejdb 
 * @author zgr  
 * @date 2012-9-14 上午10:15:54 
 * @version V1.0   
 */
package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.TblExc;
import com.sys.vo.TblExcExample;

/**
 * @ClassName: TblExcService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-14 上午10:15:54
 * @version 1.0
 */
public interface TblExcService extends Service {
	int countByExample(TblExcExample example);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(TblExc record);

	/**
	 * 获取分页信息
	 * 
	 * @param example
	 * @param offset
	 *            行偏移
	 * @param pageSize
	 *            分页大小
	 * @return
	 */
	List<TblExc> selectPageByExampleWithBLOBs(
			@Param("example") TblExcExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	TblExc selectByPrimaryKey(Integer id);

	int updateByPrimaryKeyWithBLOBs(TblExc record);
}
