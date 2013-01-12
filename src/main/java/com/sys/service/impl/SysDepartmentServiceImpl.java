/**   
 * @Title: SysDepartmentServiceImpl.java 
 * @Package com.sys.service.impl 
 * @author zgr  
 * @date 2012-5-5 上午10:57:44 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysDepartmentMapper;
import com.sys.service.SysDepartmentService;
import com.sys.vo.SysDepartment;
import com.sys.vo.SysDepartmentExample;

/**
 * @ClassName: SysDepartmentServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-5 上午10:57:44
 * @version 1.0
 */
@Service("sysDepartmentService")
public class SysDepartmentServiceImpl extends ServiceImpl implements
		SysDepartmentService {

	@Resource
	private SysDepartmentMapper sysDepartmentMapper;

	public SysDepartmentMapper getSysDepartmentMapper() {
		return sysDepartmentMapper;
	}

	public void setSysDepartmentMapper(SysDepartmentMapper sysDepartmentMapper) {
		this.sysDepartmentMapper = sysDepartmentMapper;
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.SysDepartmentService#countByExample(com.sys.vo.SysDepartmentExample)
	 */
	public int countByExample(SysDepartmentExample example) {
		logger.info("get count from sys_dept by example...");
		return sysDepartmentMapper.countByExample(example);
	}

	/**
	 * @param did
	 * @return
	 * @see com.sys.service.SysDepartmentService#deleteByPrimaryKey(java.lang.Integer)
	 */
	public int deleteByPrimaryKey(Integer did) {
		logger.info("delete from sys_dept by primarykey[" + did + "]...");
		int rtn = 0;
		try {
			rtn = sysDepartmentMapper.deleteByPrimaryKey(did);
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
		}
		return rtn;
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.SysDepartmentService#insertSelective(com.sys.vo.SysDepartment)
	 */
	public int insertSelective(SysDepartment record) {
		logger.info("insert record into sys_dept...");
		return sysDepartmentMapper.insertSelective(record);
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.SysDepartmentService#selectByExample(com.sys.vo.SysDepartmentExample)
	 */
	public List<SysDepartment> selectByExample(SysDepartmentExample example) {
		logger.info("select from sys_dept by example...");
		return sysDepartmentMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @param offset
	 * @param pageSize
	 * @return
	 * @see com.sys.service.SysDepartmentService#selectPageByExample(com.sys.vo.SysDepartmentExample,
	 *      int, int)
	 */
	public List<SysDepartment> selectPageByExample(
			SysDepartmentExample example, int offset, int pageSize) {
		logger.info("select page info from sys_dept by example...");
		return sysDepartmentMapper.selectPageByExample(example, offset,
				pageSize);
	}

	/**
	 * @param did
	 * @return
	 * @see com.sys.service.SysDepartmentService#selectByPrimaryKey(java.lang.Integer)
	 */
	public SysDepartment selectByPrimaryKey(Integer did) {
		logger.info("select record from sys_dept by primarykey[" + did + "]...");
		return sysDepartmentMapper.selectByPrimaryKey(did);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.SysDepartmentService#updateByPrimaryKey(com.sys.vo.SysDepartment)
	 */
	public int updateByPrimaryKey(SysDepartment record) {
		logger.info("update record into sys_dept by primarykey["
				+ record.getDid() + "]...");
		return sysDepartmentMapper.updateByPrimaryKey(record);
	}

	/**
	 * @param example
	 * @param did
	 * @param flag
	 * @return
	 * @see com.sys.service.SysDepartmentService#checkSimilarity(com.sys.vo.SysDepartmentExample,
	 *      java.lang.Integer, int)
	 */
	public boolean checkSimilarity(SysDepartmentExample example, Integer did,
			int flag) {
		List<SysDepartment> list = sysDepartmentMapper.selectByExample(example);
		if (list == null || list.size() < 1) {
			return true;
		}

		if (flag == 0) { // update
			if (list.size() == 1 && list.get(0).getDid() == did) {
				return true;
			}
		}

		return false;
	}

}
