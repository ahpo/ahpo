package com.sys.dao;

import com.sys.vo.SysFunction;
import com.sys.vo.SysFunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface SysFunctionMapper {
    int countByExample(SysFunctionExample example);

    int deleteByExample(SysFunctionExample example);

    int deleteByPrimaryKey(Integer funcid);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    List<SysFunction> selectByExample(SysFunctionExample example);

    SysFunction selectByPrimaryKey(Integer funcid);

    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}