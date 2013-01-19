/**   
 * @Title: SysLogServiceImpl.java 
 * @Package com.sys.service.impl 
 * @author zgr  
 * @date 2012-5-9 下午3:42:56 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysLogMapper;
import com.sys.service.SysLogService;
import com.sys.vo.SysLog;
import com.sys.vo.SysLogExample;

/**
 * @ClassName: SysLogServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-9 下午3:42:56
 * @version 1.0
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl implements SysLogService {

	@Resource
	private SysLogMapper sysLogMapper;

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.SysLogService#countByExample(com.sys.vo.SysLogExample)
	 */
	public int countByExample(SysLogExample example) {
		logger.info("get count of sys_log by example...");
		return sysLogMapper.countByExample(example);
	}

	/**
	 * @param logid
	 * @return
	 * @see com.sys.service.SysLogService#deleteByPrimaryKey(java.lang.Integer)
	 */
	public int deleteByPrimaryKey(Integer logid) {
		logger.info("delete from sys_log by primarykey[" + logid + "]...");
		return sysLogMapper.deleteByPrimaryKey(logid);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.SysLogService#insertSelective(com.sys.vo.SysLog)
	 */
	public int insertSelective(SysLog record) {
		logger.info("insert record into sys_log...");
		return sysLogMapper.insertSelective(record);
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.SysLogService#selectByExample(com.sys.vo.SysLogExample)
	 */
	public List<SysLog> selectByExample(SysLogExample example) {
		logger.info("select from sys_log by example...");
		return sysLogMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @param offset
	 * @param pageSize
	 * @return
	 * @see com.sys.service.SysLogService#selectPageByExample(com.sys.vo.SysLogExample,
	 *      int, int)
	 */
	public List<SysLog> selectPageByExample(SysLogExample example, int offset,
			int pageSize) {
		logger.info("select page info from sys_log by example...");
		List<SysLog> list = null;
		try {
			list = sysLogMapper.selectPageByExample(example, offset, pageSize);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	/**
	 * @param logid
	 * @return
	 * @see com.sys.service.SysLogService#selectByPrimaryKey(java.lang.Integer)
	 */
	public SysLog selectByPrimaryKey(Integer logid) {
		logger.info("select from sys_log by primarykey[" + logid + "]...");
		return sysLogMapper.selectByPrimaryKey(logid);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.SysLogService#updateByPrimaryKey(com.sys.vo.SysLog)
	 */
	public int updateByPrimaryKey(SysLog record) {
		logger.info("update by primarykey[" + record.getLogid() + "]...");
		return sysLogMapper.updateByPrimaryKey(record);
	}

}
