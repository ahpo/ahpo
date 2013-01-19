package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sys.vo.SysTask;
import com.sys.vo.SysTaskExample;

public interface SysTaskService {

	List<SysTask> selectPageByExample(@Param("example") SysTaskExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);
	
	int countByExample(SysTaskExample example);
}
