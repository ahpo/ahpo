package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysUserMapper;
import com.sys.service.SysUserService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysUser;
import com.sys.vo.SysUserExample;

@Service("userService")
public class SysUserServiceImpl extends ServiceImpl implements SysUserService {

	@Resource
	private SysUserMapper sysUserMapper;

	public void setSysUserMapper(SysUserMapper userMapper) {
		this.sysUserMapper = userMapper;
	}

	public int deleteByPrimaryKey(Integer uid) {
		logger.info("delete user from sys_user by primarykey[" + uid + "]...");
		int rtn = 0;
		try {
			rtn = sysUserMapper.deleteByPrimaryKey(uid);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rtn;
	}

	public int insertSelective(SysUser record) {
		logger.info("insert record into sys_user...");
		return sysUserMapper.insertSelective(record);
	}

	public List<SysUser> selectByExample(SysUserExample example) {
		logger.info("select from sys_user by example...");
		return sysUserMapper.selectByExample(example);
	}

	public List<SysUser> selectPageByExample(SysUserExample example,
			int offset, int pageSize) {
		logger.info("select page info from sys_user by example...");
		List<SysUser> list = null;
		try{
			list = sysUserMapper.selectPageByExample(example, offset, pageSize);
		} catch(DataAccessException e){
			logger.error("mapper exception:", e);
		}
		return list;
	}

	public SysUser selectByPrimaryKey(Integer uid) {
		logger.info("select record from sys_user by primarykey[" + uid + "]...");
		return sysUserMapper.selectByPrimaryKey(uid);
	}

	public int updateByPrimaryKey(SysUser record) {
		logger.info("update record to sys_user by primarykey["
				+ record.getUid() + "]...");
		return sysUserMapper.updateByPrimaryKey(record);
	}

	public int countByExample(SysUserExample example) {
		logger.info("get count from sys_user by example...");
		return sysUserMapper.countByExample(example);
	}

	public List<SysResFuncRelation> selectResFuncByUserId(Integer uid) {
		logger.info("select resFuncRelation from union table by userid[" + uid
				+ "]...");
		return sysUserMapper.selectResFuncByUserId(uid);
	}

	/**
	 * 相似性记录检查
	 * 
	 * @param example
	 * @param id
	 *            sys_user的id
	 * @param flag
	 *            表示符号 0:修改; 1:插入
	 * @return true:不存在相似的记录; false:存在相似记录
	 */
	public boolean checkSimilarity(SysUserExample example, Integer uid, int flag) {
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list == null || list.size() < 1) {
			return true;
		}

		if (flag == 0) { // update
			if (list.size() == 1 && list.get(0).getUid() == uid) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param uid
	 * @param resCode
	 * @return
	 * @see com.sys.service.SysUserService#selectFuncByUidAndResCode(java.lang.Integer,
	 *      java.lang.String)
	 */
	public List<SysFunction> selectFuncByUidAndResCode(Integer uid,
			String resCode) {
		if (uid == null || resCode == null || "".equals(resCode)) {
			return null;
		}
		return sysUserMapper.selectFuncByUidAndResCode(uid, resCode);
	}

	/**
	 * @param uid
	 * @param resCode
	 * @param funcMemo
	 * @return
	 * @see com.sys.service.SysUserService#checkPrivilegeByUidAndResCodeAndFunc(java.lang.Integer,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean checkPrivilegeByUidAndResCodeAndFunc(Integer uid,
			String resCode, String funcMemo) {
		if (uid == null || resCode == null || funcMemo == null
				|| "".equals(resCode) || "".equals(funcMemo)) {
			return false;
		}
		List<Integer> list = sysUserMapper.selectURFIDByUidAndResCodeAndFunc(
				uid, resCode, funcMemo);
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
