package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysTaskMapper;
import com.sys.service.SysTaskService;
import com.sys.vo.SysTask;
import com.sys.vo.SysTaskExample;

@Service("sysTaskService")
public class SysTaskServiceImpl extends ServiceImpl implements SysTaskService {

	@Resource
	private SysTaskMapper sysTaskMapper;

	@Override
	public List<SysTask> selectPageByExample(
			@Param("example") SysTaskExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize) {
		logger.info("select page info from sys_task by example...");
		List<SysTask> list = null;
		try{
			list = sysTaskMapper.selectPageByExample(example, offset, pageSize);
		} catch(DataAccessException e){
			logger.error("mapper exception:", e);
		}
		return list;
	}

	@Override
	public int countByExample(SysTaskExample example) {
		return sysTaskMapper.countByExample(null);
	}
	
	
}
