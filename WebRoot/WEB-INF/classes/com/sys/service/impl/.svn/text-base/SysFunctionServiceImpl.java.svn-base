/**   
 * @Title: SysFunctionServiceImpl.java 
 * @Package com.sys.service.impl 
 * @author zgr  
 * @date 2012-5-7 下午1:21:53 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysFunctionMapper;
import com.sys.service.SysFunctionService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysFunctionExample;

/** 
 * @ClassName: SysFunctionServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zgr 
 * @date 2012-5-7 下午1:21:53 
 * @version 1.0 
 */
@Service("SysFunctionService")
public class SysFunctionServiceImpl extends ServiceImpl implements
		SysFunctionService {

	@Resource
	private SysFunctionMapper sysFunctionMapper;
	
	public SysFunctionMapper getSysFunctionMapper() {
		return sysFunctionMapper;
	}

	public void setSysFunctionMapper(SysFunctionMapper sysFunctionMapper) {
		this.sysFunctionMapper = sysFunctionMapper;
	}

	/**
	 * @param example
	 * @return 
	 * @see com.sys.service.SysFunctionService#countByExample(com.sys.vo.SysFunctionExample)
	 */
	public int countByExample(SysFunctionExample example) {
		logger.info("count from sys_func by example...");
		return sysFunctionMapper.countByExample(example);
	}

	/**
	 * @param funcid
	 * @return 
	 * @see com.sys.service.SysFunctionService#deleteByPrimaryKey(java.lang.Integer)
	 */
	public int deleteByPrimaryKey(Integer funcid) {
		logger.info("delete record from sys_func by primarykey["+funcid+"]...");
		return sysFunctionMapper.deleteByPrimaryKey(funcid);
	}

	/**
	 * @param record
	 * @return 
	 * @see com.sys.service.SysFunctionService#insertSelective(com.sys.vo.SysFunction)
	 */
	public int insertSelective(SysFunction record) {
		logger.info("insert record into sys_func...");
		return sysFunctionMapper.insertSelective(record);
	}

	/**
	 * @param example
	 * @return 
	 * @see com.sys.service.SysFunctionService#selectByExample(com.sys.vo.SysFunctionExample)
	 */
	public List<SysFunction> selectByExample(SysFunctionExample example) {
		logger.info("select from sys_record by example...");
		return sysFunctionMapper.selectByExample(example);
	}

	/**
	 * @param funcid
	 * @return 
	 * @see com.sys.service.SysFunctionService#selectByPrimaryKey(java.lang.Integer)
	 */
	public SysFunction selectByPrimaryKey(Integer funcid) {
		logger.info("select from sys_func by primarykey["+funcid+"]...");
		return sysFunctionMapper.selectByPrimaryKey(funcid);
	}

	/**
	 * @param record
	 * @return 
	 * @see com.sys.service.SysFunctionService#updateByPrimaryKey(com.sys.vo.SysFunction)
	 */
	public int updateByPrimaryKey(SysFunction record) {
		logger.info("update record into sys_func by primarykey["+record.getFuncid()+"]...");
		return sysFunctionMapper.updateByPrimaryKey(record);
	}

}
