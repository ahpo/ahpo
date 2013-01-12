/**   
 * @Title: TblDictionaryService.java 
 * @Package com.easygo.service.ejdb 
 * @author zgr  
 * @date 2012-9-13 下午4:14:36 
 * @version V1.0   
 */
package com.easygo.service.ejdb;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.easygo.vo.ejdb.TblDictionary;
import com.easygo.vo.ejdb.TblDictionaryExample;
import com.pub.service.Service;

/**
 * @ClassName: TblDictionaryService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-13 下午4:14:36
 * @version 1.0
 */
public interface TblDictionaryService extends Service {
	int countByExample(TblDictionaryExample example);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(TblDictionary record);

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
	List<TblDictionary> selectPageByExample(
			@Param("example") TblDictionaryExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	TblDictionary selectByPrimaryKey(Integer id);

	int updateByPrimaryKey(TblDictionary record);

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
	public boolean checkSimilarity(TblDictionaryExample example, Integer id,
			int flag);
}
