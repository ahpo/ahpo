/**   
 * @Title: TblLookupService.java 
 * @Package com.easygo.service.ejdb 
 * @author zgr  
 * @date 2012-9-11 上午10:16:32 
 * @version V1.0   
 */
package com.easygo.service.ejdb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygo.vo.ejdb.TblLookup;
import com.easygo.vo.ejdb.TblLookupExample;
import com.pub.service.Service;

/**
 * @ClassName: TblLookupService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-11 上午10:16:32
 * @version 1.0
 */
public interface TblLookupService extends Service {

	List<TblLookup> selectByExample(TblLookupExample example);

	int countByExample(TblLookupExample example);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(TblLookup record);

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
	List<TblLookup> selectPageByExample(
			@Param("example") TblLookupExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	TblLookup selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(TblLookup record);

	/**
	 * 相似性记录检查
	 * 
	 * @param example
	 * @param id
	 *            记录的id
	 * @param flag
	 *            表示符号 0:修改; 1:插入
	 * @return true:不存在相似的记录; false:存在相似记录
	 */
	public boolean checkSimilarity(TblLookupExample example, Integer id,
			int flag);
}
