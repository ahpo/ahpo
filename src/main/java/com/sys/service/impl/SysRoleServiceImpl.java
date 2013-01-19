package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysRoleMapper;
import com.sys.service.SysRoleService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysRole;
import com.sys.vo.SysRoleExample;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl implements SysRoleService {

	@Resource
	private SysRoleMapper sysRoleMapper;


	public int countByExample(SysRoleExample example) {
		logger.info("get count of sys_role by example...");
		return sysRoleMapper.countByExample(example);
	}

	public int deleteByPrimaryKey(Integer rid) {
		logger.info("delete from sys_role by primarykey[" + rid + "]...");
		int rtn = 0;
		try {
			rtn = sysRoleMapper.deleteByPrimaryKey(rid);
		} catch (DataAccessException e) {
			logger.error("Exception type:" + e.getClass());
			logger.error(e.getMessage());
		}
		return rtn;
	}

	public int insertSelective(SysRole record) {
		logger.info("insert record into sys_role...");
		return sysRoleMapper.insertSelective(record);
	}

	public List<SysRole> selectByExample(SysRoleExample example) {
		logger.info("select from sys_role by example...");
		return sysRoleMapper.selectByExample(example);
	}

	public List<SysRole> selectPageByExample(SysRoleExample example,
			int offset, int pageSize) {
		logger.info("select page info from sys_role by example...");
		return sysRoleMapper.selectPageByExample(example, offset, pageSize);
	}

	public SysRole selectByPrimaryKey(Integer rid) {
		logger.info("select record from sys_role by primarykey[" + rid + "]...");
		return sysRoleMapper.selectByPrimaryKey(rid);
	}

	public int updateByPrimaryKey(SysRole record) {
		logger.info("update record into sys_role by primarykey["
				+ record.getRid() + "]...");
		return sysRoleMapper.updateByPrimaryKey(record);
	}

	public List<SysResFuncRelation> selectResFuncByRoleId(Integer rid) {
		logger.info("select recfuncRelation from union table...");
		return sysRoleMapper.selectResFuncByRoleId(rid);
	}

	/**
	 * @param example
	 * @param rid
	 * @param flag
	 * @return
	 * @see com.sys.service.SysRoleService#checkSimilarity(com.sys.vo.SysUserExample,
	 *      java.lang.Integer, int)
	 */
	public boolean checkSimilarity(SysRoleExample example, Integer rid, int flag) {
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		if (list == null || list.size() < 1) {
			return true;
		}

		if (flag == 0) { // update
			if (list.size() == 1 && list.get(0).getRid() == rid) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param rid
	 * @param resCode
	 * @return
	 * @see com.sys.service.SysRoleService#selectFuncByRidAndResCode(java.lang.Integer,
	 *      java.lang.String)
	 */
	public List<SysFunction> selectFuncByRidAndResCode(Integer rid,
			String resCode) {
		if (rid == null || resCode == null || "".equals(resCode)) {
			return null;
		}
		return sysRoleMapper.selectFuncByRidAndResCode(rid, resCode);
	}

	/**
	 * @param rid
	 * @param resCode
	 * @param funcMemo
	 * @return
	 * @see com.sys.service.SysRoleService#checkPrivilegeByRidAndResCodeAndFunc(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean checkPrivilegeByRidAndResCodeAndFunc(Integer rid,
			String resCode, String funcMemo) {
		if (rid == null || resCode == null || funcMemo == null
				|| "".equals(resCode) || "".equals(funcMemo)) {
			return false;
		}
		List<Integer> list = sysRoleMapper.selectRRFIDByRidAndResCodeAndFunc(
				rid, resCode, funcMemo);
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
