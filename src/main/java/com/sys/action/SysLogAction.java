/**   
 * @Title: SysLogAction.java 
 * @Package com.sys.action 
 * @author zgr  
 * @date 2012-5-10 下午2:55:34 
 * @version V1.0   
 */
package com.sys.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.enjoyor.util.date.DateUtil;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.webapp.ui.pagination.PageHandle;
import com.sys.service.SysLogService;
import com.sys.service.SysUserService;
import com.sys.vo.SysLog;
import com.sys.vo.SysLogExample;
import com.sys.vo.SysUser;

/**
 * @ClassName: SysLogAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-10 下午2:55:34
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class SysLogAction extends AbstractAction {

	private static final long serialVersionUID = 9031308829893765627L;
	@Resource
	private SysLogService sysLogService;
	@Resource
	private SysUserService sysUserService;
	private SysLog sysLog;
	private Integer logid;

	private Integer uid;

	private SysUser sysUser;
	private String ltype;

	private String memo;

	private Date logDate;

	private String userIp;

	private String beginTime;
	private String endTime;
	
	private List<SysUser> sysUsers;

	public String sysLogQuery() {
		sysUsers = sysUserService.selectByExample(null);
		Map<String, String> parms = new HashMap<String, String>();
		SysLogExample example = new SysLogExample();
		com.sys.vo.SysLogExample.Criteria criteria = example.createCriteria();
		if (uid != null && uid > 0) {
			criteria.andUidEqualTo(uid);
			parms.put(Constants.UID, this.uid.toString());
		}
		try {
			if (beginTime != null && endTime != null && beginTime.length() > 0
					&& endTime.length() > 0) {
				criteria.andLogDateBetween(
						DateUtil.parse(beginTime, "yyyy-MM-dd HH:mm:ss"),
						DateUtil.parse(endTime, "yyyy-MM-dd HH:mm:ss"));

				parms.put(Constants.BEGIN_TIME, this.beginTime);
			} else if (beginTime != null && beginTime.length() > 0) {
				criteria.andLogDateGreaterThanOrEqualTo(DateUtil.parse(
						beginTime, "yyyy-MM-dd HH:mm:ss"));
			} else if (endTime != null && endTime.length() > 0) {
				criteria.andLogDateLessThanOrEqualTo(DateUtil.parse(endTime,
						"yyyy-MM-dd HH:mm:ss"));
				parms.put(Constants.END_TIME, this.endTime);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int total = sysLogService.countByExample(example);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(parms, pageNum, pageMethod, total);
		resultList = sysLogService.selectPageByExample(example,
				page.getStartRow(), page.getNumPerPage());
		return SUCCESS;
	}

	public Integer getLogid() {
		return logid;
	}

	public void setLogid(Integer logid) {
		this.logid = logid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public SysLog getSysLog() {
		return sysLog;
	}

	public void setSysLog(SysLog sysLog) {
		this.sysLog = sysLog;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
}
