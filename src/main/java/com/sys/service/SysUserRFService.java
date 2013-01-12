/**   
 * @Title: SysUserRFService.java 
 * @Package com.sys.service 
 * @author zgr  
 * @date 2012-5-8 上午9:40:03 
 * @version V1.0   
 */
package com.sys.service;

import com.pub.service.Service;

/**
 * @ClassName: SysUserRFService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-8 上午9:40:03
 * @version 1.0
 */
public interface SysUserRFService extends Service {

	/**
	 * 
	 * @Description: 插入数据到sys_user_rf表
	 * @author zgr  
	 * @date 2012-5-8 上午9:40:53
	 * @param uid
	 * @param resid
	 * @param funcid
	 * @return
	 */
	int insertIntoUserRF(Integer uid, Integer resid, Integer funcid);

	/**
	 * 
	 * @Description: 根据uid删除数据
	 * @author zgr  
	 * @date 2012-5-8 上午9:48:18
	 * @param uid
	 * @return
	 */
	int deleteUserRFByUid(Integer uid);
}
