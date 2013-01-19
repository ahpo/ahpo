package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.TblDictionary;
import com.sys.vo.TblDictionaryExample;

@Repository
public interface TblDictionaryMapper {
	int countByExample(TblDictionaryExample example);

	int deleteByExample(TblDictionaryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TblDictionary record);

	int insertSelective(TblDictionary record);

	List<TblDictionary> selectByExample(TblDictionaryExample example);

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

	int updateByExampleSelective(@Param("record") TblDictionary record,
			@Param("example") TblDictionaryExample example);

	int updateByExample(@Param("record") TblDictionary record,
			@Param("example") TblDictionaryExample example);

	int updateByPrimaryKeySelective(TblDictionary record);

	int updateByPrimaryKey(TblDictionary record);
}