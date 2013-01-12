package com.sys.service.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysResourceMapper;
import com.sys.service.SysResourceService;
import com.sys.vo.SysResource;
import com.sys.vo.SysResourceExample;
@Service("sysResourceService")
public class SysResourceServiceImpl extends ServiceImpl implements SysResourceService {

	@javax.annotation.Resource
	private SysResourceMapper sysResourceMapper;

	public SysResourceMapper getSysResourceMapper() {
		return sysResourceMapper;
	}

	public void setSysResourceMapper(SysResourceMapper sysResourceMapper) {
		this.sysResourceMapper = sysResourceMapper;
	}

	public int countByExample(SysResourceExample example) {
		logger.info("get count from sys_res...");
		return sysResourceMapper.countByExample(example);
	}

	public List<com.sys.vo.SysResource> selectByExample(SysResourceExample example) {
		logger.info("select from sys_res by example...");
		return sysResourceMapper.selectByExample(example);
	}

	public com.sys.vo.SysResource selectByPrimaryKey(Integer resid) {
		logger.info("select from sys_res by primarykey["+resid+"]...");
		return sysResourceMapper.selectByPrimaryKey(resid);
	}
	
	public int updateByPrimaryKey(SysResource sysResource){
		logger.info("update sys_res by primarykey["+sysResource.getResid()+"]...");
		return sysResourceMapper.updateByPrimaryKey(sysResource);
	}
	
	public int deleteByPrimaryKey(Integer resid) {
		logger.info("delete sys_res by primarykey["+resid+"]...");
		return sysResourceMapper.deleteByPrimaryKey(resid);
	}
	
	

	@Override
	public List<SysResourceExample> selectPageByExample(SysResourceExample example,
			int offset, int pageSize) {
		logger.info("select page info from sys_res by example...");
		List<SysResourceExample> list = null;
		try{
			list = sysResourceMapper.selectPageByExample(example, offset, pageSize);
		} catch(DataAccessException e){
			logger.error("mapper exception:", e);
		}
		return list;
	}
}
