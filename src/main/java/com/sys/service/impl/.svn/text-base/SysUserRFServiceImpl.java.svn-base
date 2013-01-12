/**   
 * @Title: SysUserRFServiceImpl.java 
 * @Package com.sys.service.impl 
 * @author zgr  
 * @date 2012-5-8 上午9:49:20 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysUserRFMapper;
import com.sys.service.SysUserRFService;

/**
 * @ClassName: SysUserRFServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-8 上午9:49:20
 * @version 1.0
 */
@Service("sysUserRFService")
public class SysUserRFServiceImpl extends ServiceImpl implements
		SysUserRFService {

	@Resource
	private SysUserRFMapper sysUserRFMapper;

	public SysUserRFMapper getSysUserRFMapper() {
		return sysUserRFMapper;
	}

	public void setSysUserRFMapper(SysUserRFMapper sysUserRFMapper) {
		this.sysUserRFMapper = sysUserRFMapper;
	}

	/**
	 * @param uid
	 * @param resid
	 * @param funcid
	 * @return
	 * @see com.sys.service.SysUserRFService#insertIntoUserRF(java.lang.Integer,
	 *      java.lang.Integer, java.lang.Integer)
	 */
	public int insertIntoUserRF(Integer uid, Integer resid, Integer funcid) {
		if (uid == null || resid == null || funcid == null) {
			logger.info("insert into sys_user_rf failed, for uid or resid or funcid is null...");
			return 0;
		} else {
			List<Integer> rfids = sysUserRFMapper
					.selectIDFromRFByResIdAndFuncId(resid, funcid);
			if (rfids.isEmpty()) {
				logger.info("insert into sys_user_rf failed, for rfid is null...");
				return 0;
			} else {
				logger.info("insert into sys_user_rf...");
				return sysUserRFMapper.insertIntoUserRF(uid, rfids.get(0));
			}
		}
	}

	/**
	 * @param uid
	 * @return
	 * @see com.sys.service.SysUserRFService#deleteUserRFByUid(java.lang.Integer)
	 */
	public int deleteUserRFByUid(Integer uid) {
		if (uid == null) {
			logger.info("delete from sys_user_rf failed, for uid is null...");
			return 0;
		} else {
			logger.info("delete from sys_user_rf by uid[" + uid + "]...");
			return sysUserRFMapper.deleteUserRFByUid(uid);
		}
	}

}
