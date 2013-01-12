package com.pub.webapp.ui.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * <p><code>Result</code> 操作结果页Bean</p>
 * 
 * @author PuQiang
 * @version
 * 
 */
public class OperateResult {
	private String operation;	//操作类型
	private String result;		//操作结果（成功或失败�?
	private String reason;		//失败原因
	private String url;			//结果页返回的url
	private Map<String,String> parms = new HashMap<String, String>();     //�?��保存的查询条件，用于结果页返�?
	private Map<String,String> deleteResult = new LinkedHashMap<String, String>();  //保存删除时外键关联的数据
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getParms() {
		return parms;
	}
	public void setParms(Map<String, String> parms) {
		this.parms = parms;
	}
	public Map<String, String> getDeleteResult() {
		return deleteResult;
	}
	public void setDeleteResult(Map<String, String> deleteResult) {
		this.deleteResult = deleteResult;
	}
}
