package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.SysResource;
import com.sys.vo.SysResourceExample;
@Repository
public interface SysResourceMapper {
    int countByExample(SysResourceExample example);

    int deleteByExample(SysResourceExample example);

    int deleteByPrimaryKey(Integer resid);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    List<SysResource> selectByExample(SysResourceExample example);

    SysResource selectByPrimaryKey(Integer resid);

    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

	List<SysResourceExample> selectPageByExample(@Param("example") SysResourceExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);
}