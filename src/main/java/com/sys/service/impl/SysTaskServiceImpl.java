package com.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysTaskMapper;
import com.sys.service.SysTaskService;

@Service("sysTaskService")
public class SysTaskServiceImpl extends ServiceImpl implements SysTaskService {

	@Resource
	private SysTaskMapper sysTaskMapper;
	
}
