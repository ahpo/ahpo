package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.TblLookup;
import com.sys.vo.TblLookupExample;
@Repository
public interface TblLookupMapper {
    int countByExample(TblLookupExample example);

    int deleteByExample(TblLookupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblLookup record);

    int insertSelective(TblLookup record);

    List<TblLookup> selectByExample(TblLookupExample example);

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
	List<TblLookup> selectPageByExample(@Param("example") TblLookupExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

    TblLookup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblLookup record, @Param("example") TblLookupExample example);

    int updateByExample(@Param("record") TblLookup record, @Param("example") TblLookupExample example);

    int updateByPrimaryKeySelective(TblLookup record);

    int updateByPrimaryKey(TblLookup record);
}