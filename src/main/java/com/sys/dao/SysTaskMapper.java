package com.sys.dao;

import com.sys.vo.SysTask;
import com.sys.vo.SysTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}