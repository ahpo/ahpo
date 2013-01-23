/**   
 * @Title: TblDictionaryAction.java 
 * @Package com.easygo.action.ejdb 
 * @author zgr  
 * @date 2012-9-13 下午4:31:48 
 * @version V1.0   
 */
package com.sys.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pub.action.AbstractAction;
import com.pub.webapp.ui.pagination.PageHandle;
import com.sys.service.SysTaskService;
import com.sys.vo.SysTask;

/**
 * @ClassName: SysTaskAction
 * @Description:
 * @author yangxb
 * @date 2012-9-13 下午4:31:48
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class SysTaskAction extends AbstractAction {

	private static final long serialVersionUID = -7819798116219419018L;
	@Resource
	private SysTaskService sysTaskService;
	
	private SysTask sysTask;
	
	private List<SysTask> sysTasks;

	public SysTask getSysTask() {
		return sysTask;
	}

	public void setSysTask(SysTask sysTask) {
		this.sysTask = sysTask;
	}
	
	public List<SysTask> getSysTasks() {
		return sysTasks;
	}

	public void setSysTasks(List<SysTask> sysTasks) {
		this.sysTasks = sysTasks;
	}

	/** function list area **/
	
	public String query() {
		int total = sysTaskService.countByExample(null);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(null, pageNum, pageMethod, total);
		sysTasks = sysTaskService.selectPageByExample(null,
		page.getStartRow(), page.getNumPerPage());
				
		return SUCCESS+QUERY; 
	}
}
