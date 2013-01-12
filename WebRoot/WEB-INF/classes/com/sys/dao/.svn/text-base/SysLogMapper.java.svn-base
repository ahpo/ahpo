package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.SysLog;
import com.sys.vo.SysLogExample;
@Repository
public interface SysLogMapper {
    int countByExample(SysLogExample example);

    int deleteByExample(SysLogExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

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
	List<SysLog> selectPageByExample(@Param("example") SysLogExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

    SysLog selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByExample(@Param("record") SysLog record, @Param("example") SysLogExample example);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}