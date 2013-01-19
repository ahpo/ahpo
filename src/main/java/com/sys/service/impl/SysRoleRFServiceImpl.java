/**   
 * @Title: SysRoleRFServiceImpl.java 
 * @Package com.sys.service.impl 
 * @author zgr  
 * @date 2012-5-8 下午12:12:43 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.sys.dao.SysRoleRFMapper;
import com.sys.service.SysRoleRFService;

/**
 * @ClassName: SysRoleRFServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-8 下午12:12:43
 * @version 1.0
 */
@Service("SysRoleRFService")
public class SysRoleRFServiceImpl extends ServiceImpl implements
		SysRoleRFService {

	@Resource
	private SysRoleRFMapper sysRoleRFMapper;

	/**
	 * @param rid
	 * @param resid
	 * @param funcid
	 * @return
	 * @see com.sys.service.SysRoleRFService#insertIntoRoleRF(java.lang.Integer,
	 *      java.lang.Integer, java.lang.Integer)
	 */
	public int insertIntoRoleRF(Integer rid, Integer resid, Integer funcid) {
		if (rid == null || resid == null || funcid == null) {
			logger.info("failed to insert record into sys_role_rf, for rid or resid or funid is null...");
			return 0;
		} else {
			List<Integer> rfids = sysRoleRFMapper
					.selectIDFromRFByResIdAndFuncId(resid, funcid);
			if (rfids.isEmpty()) {
				logger.info("failed to insert record into sys_role_rf, for rfid is null...");
				return 0;
			} else {
				logger.info("insert record into sys_role_rf...");
				return sysRoleRFMapper.insertIntoRoleRF(rid, rfids.get(0));
			}
		}
	}

	/**
	 * @param rid
	 * @return
	 * @see com.sys.service.SysRoleRFService#deleteRoleRFByUid(java.lang.Integer)
	 */
	public int deleteRoleRFByRid(Integer rid) {
		if (rid == null) {
			logger.info("delete from sys_role_rf failed, for rid is null...");
			return 0;
		} else {
			logger.info("delete from sys_role_rf by rid[" + rid + "]...");
			int rtn = 0;
			try {
				rtn = sysRoleRFMapper.deleteRoleRFByRid(rid);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			return rtn;
		}
	}

}
