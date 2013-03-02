/**   
 * @Title: AbstractAction.java 
 * @Package com.pub.action 
 * @author zgr  
 * @date 2012-8-10 下午2:37:28 
 * @version V1.0   
 */
package com.pub.action;

import java.util.List;
import java.util.Map;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.opensymphony.xwork2.ActionSupport;
import com.pub.webapp.ui.pagination.Page;
import com.pub.webapp.ui.pagination.PageHandle;
import com.pub.webapp.ui.util.OperateResult;
import com.sys.vo.SysFunction;

/** 
 * @ClassName: AbstractAction 
 * @author yangxb 
 * @date 2012-8-10 下午2:37:28 
 * @version 1.0 
 */
public abstract class AbstractAction extends ActionSupport implements IAction {
	private static final long serialVersionUID = 1L;
	
	public static final String DBERROR = "dberror";
	
	public static final String QUERY = "_query";
	
	public static final String VIEW = "_view";	
	
	public static final String UPDATE = "_update";
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Map<String, Object> session;
	
	public List<SysFunction> funcList;
	public Integer ids[];

	//the list of checkbox, seprate by ,
	public String cids;
	//the keywords
	public String keywords;
	
	public List<?> resultList;
	public OperateResult operateResult = new OperateResult();

	public PageHandle pageHandler;
	public Page page;
	public String pageMethod = "";
	public String pageNum;
	private String JSON_DATA="{\"statusCode\":\"200\"," +
			"\"message\":\"操作成功\"," +
			"\"navTabId\":\"\"," +
			"\"rel\":\"\"," +
			"\"callbackType\":\"\"," +
			"\"forwardUrl\":\"\"" +
			"}";;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<SysFunction> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<SysFunction> funcList) {
		this.funcList = funcList;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public OperateResult getOperateResult() {
		return operateResult;
	}

	public void setOperateResult(OperateResult operateResult) {
		this.operateResult = operateResult;
	}

	public PageHandle getPageHandler() {
		return pageHandler;
	}

	public void setPageHandler(PageHandle pageHandler) {
		this.pageHandler = pageHandler;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getPageMethod() {
		return pageMethod;
	}

	public void setPageMethod(String pageMethod) {
		this.pageMethod = pageMethod;
	}

	public String getCurrentPage() {
		return pageNum;
	}

	public void setCurrentPage(String currentPage) {
		this.pageNum = currentPage;
	}

	protected void setJsonData(int code,String message) {
		
		String result = "{\"statusCode\":\""+code+"\"," +
				"\"message\":\""+message+"\"," +
				"\"navTabId\":\"\"," +
				"\"rel\":\"\"," +
				"\"callbackType\":\"closeCurrent\"," +
				"\"forwardUrl\":\"\"" +
				"}";
		setJSON_DATA(result);
	}
	
	protected void setJsonData(int code,String message,String url) {
		
		String result = "{\"statusCode\":\""+code+"\"," +
				"\"message\":\""+message+"\"," +
				"\"navTabId\":\"navTab\"," +
				"\"rel\":\"\"," +
				"\"callbackType\":\"forward\"," +
				"\"forwardUrl\":\""+url+"\"" +
				"}";
		setJSON_DATA(result);
	}

	/** 
	 * @return jSON_DATA 
	 */
	public String getJSON_DATA() {
		return JSON_DATA;
	}

	/**
	 * @param jSON_DATA the jSON_DATA to set
	 */
	public void setJSON_DATA(String jSON_DATA) {
		JSON_DATA = jSON_DATA;
	}

	public String getCids() {
		return cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
}
