package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.SysResource;
import com.sys.vo.SysResourceExample;

public interface SysResourceService extends Service {

	int countByExample(SysResourceExample example);

    List<SysResource> selectByExample(SysResourceExample example);
    
    List<SysResourceExample> selectPageByExample(@Param("example") SysResourceExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

    SysResource selectByPrimaryKey(Integer resid);
    
    int updateByPrimaryKey(SysResource sysResource);
    
    int deleteByPrimaryKey(Integer resid);
}
