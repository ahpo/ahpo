package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.SysTask;
import com.sys.vo.SysTaskExample;

@Repository
public interface SysTaskMapper {
    int countByExample(SysTaskExample example);

    int deleteByExample(SysTaskExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(SysTask record);

    int insertSelective(SysTask record);

    List<SysTask> selectByExample(SysTaskExample example);

    SysTask selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByExample(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByPrimaryKeySelective(SysTask record);

    int updateByPrimaryKey(SysTask record);
    
    //manul
	List<SysTask> selectPageByExample(@Param("example") SysTaskExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);
}