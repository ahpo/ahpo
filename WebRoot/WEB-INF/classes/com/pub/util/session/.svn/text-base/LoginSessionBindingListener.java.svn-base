/**   
 * @Title: SessionBindingListener.java 
 * @Package com.pub.util.session 
 * @author xhh  
 * @date 2012-6-5 下午12:49:27 
 * @version V1.0   
 */
package com.pub.util.session;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.pub.util.constant.Constants;
import com.sys.service.SysLogService;
import com.sys.vo.SysLog;

/**
 * @ClassName: SessionBindingListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xhh
 * @date 2012-6-5 下午12:49:27
 * @version 1.0
 */
public class LoginSessionBindingListener implements HttpSessionBindingListener {
	private Logger logger = LoggerFactory
			.getLogger(LoginSessionBindingListener.class);
	private SysLogService sysLogService;
	private Integer uid;
	private String loginIp;

	/**
	 * @param loginIp
	 * @param uid
	 * @param sysLogService
	 * @Description
	 */
	public LoginSessionBindingListener(SysLogService sysLogService,
			Integer uid, String loginIp) {
		this.sysLogService = sysLogService;
		this.uid = uid;
		this.loginIp = loginIp;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		logger.info("---------------start bound login session-------------");
		SysLog record = new SysLog();
		record.setUid(uid);
		record.setMemo(Constants.LOGIN_IN_LOG);
		record.setLogDate(new Date());
		record.setUserIp(loginIp);
		sysLogService.insertSelective(record);
	}

	/**
	 * @param arg0
	 * @see javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logger.info("---------------unbound login session-------------");
		// 记录退出操作日志
		SysLog record = new SysLog();
		record.setUid(uid);
		record.setMemo(Constants.LOGIN_OUT_LOG);
		record.setLogDate(new Date());
		record.setUserIp(loginIp);
		sysLogService.insertSelective(record);
	}

}
