package com.easygo.dao.ejdb;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.easygo.vo.ejdb.TblExc;
import com.easygo.vo.ejdb.TblExcExample;

@Repository
public interface TblExcMapper {
	int countByExample(TblExcExample example);

	int deleteByExample(TblExcExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(TblExc record);

	int insertSelective(TblExc record);

	List<TblExc> selectByExampleWithBLOBs(TblExcExample example);

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

	List<TblExc> selectByExample(TblExcExample example);

	TblExc selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") TblExc record,
			@Param("example") TblExcExample example);

	int updateByExampleWithBLOBs(@Param("record") TblExc record,
			@Param("example") TblExcExample example);

	int updateByExample(@Param("record") TblExc record,
			@Param("example") TblExcExample example);

	int updateByPrimaryKeySelective(TblExc record);

	int updateByPrimaryKeyWithBLOBs(TblExc record);

	int updateByPrimaryKey(TblExc record);
}