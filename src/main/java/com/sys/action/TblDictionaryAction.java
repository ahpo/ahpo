/**   
 * @Title: TblDictionaryAction.java 
 * @Package com.easygo.action.ejdb 
 * @author zgr  
 * @date 2012-9-13 下午4:31:48 
 * @version V1.0   
 */
package com.sys.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.webapp.ui.pagination.Page;
import com.pub.webapp.ui.pagination.PageHandle;
import com.pub.webapp.ui.util.OperateResult;
import com.pub.webapp.ui.util.WebConstants;
import com.sys.service.TblDictionaryService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.TblDictionary;
import com.sys.vo.TblDictionaryExample;

/**
 * @ClassName: TblDictionaryAction
 * @Description: Dictionary variables action servlet
 * @author zgr
 * @date 2012-9-13 下午4:31:48
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class TblDictionaryAction extends AbstractAction {

	private static final long serialVersionUID = -7819798116219419018L;
	@Resource
	private TblDictionaryService tblDictionaryService;
	private Integer id;
	private String lookupkey;
	private String lookupvalue;
	private String describeinfo;
	private Date updatetime;
	private String backup;
	private TblDictionary tblDictionary;

	private List<SysFunction> funcList;
	private Integer ids[];
	private List<?> resultList;
	private OperateResult operateResult = new OperateResult();

	private PageHandle pageHandler;
	private Page page;
	private String pageMethod = "";
	private String currentPage;

	public String query() {
		String resCode = Constants.QUERY_TBLDICTIONARY_QUERY;
		Map<String, Object> session = ActionContext.getContext().getSession();

		funcList = new ArrayList<SysFunction>();
		@SuppressWarnings("unchecked")
		List<SysResFuncRelation> list = (List<SysResFuncRelation>) session
				.get(Constants.PRIVILEGE);
		if (list != null) {
			for (SysResFuncRelation relation : list) {
				if (resCode.equals(relation.getSysResource().getResCode())) {
					funcList.add(relation.getSysFunction());
				}
			}
		}
		if (funcList == null || funcList.isEmpty()) {
			return LOGIN;
		}
		try {
			int total = tblDictionaryService.countByExample(null);
			pageHandler = new PageHandle();
			page = pageHandler.getPage(null, currentPage, pageMethod, total);
			resultList = tblDictionaryService.selectPageByExample(null,
					page.getStartRow(), page.getNumPerPage());
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}

		return SUCCESS+QUERY;
	}

	public String update() {
		try {
			tblDictionary = tblDictionaryService.selectByPrimaryKey(id);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}

		return SUCCESS+UPDATE;
	}

	public String tblDictionaryUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", currentPage);
		operateResult.setParms(parms);
		operateResult.setOperation(WebConstants.TBLDICTIONARY_UPDATE);
		operateResult.setUrl("tblDictionaryQuery.action");

		TblDictionaryExample example = new TblDictionaryExample();
		example.createCriteria().andLookupkeyEqualTo(lookupkey);
		try {
			if (!tblDictionaryService.checkSimilarity(example, id,
					Constants.CHECKSIMILARITY_MODE_UPDATE)) {
				logger.info("cannot update, for the inputed lookupkey["
						+ lookupkey + "] is already exist");
				operateResult.setResult(WebConstants.OPERATE_RESULT_FAIL);
				operateResult
						.setReason(WebConstants.OPERATERESULT_REASON_TBLDICTIONARY_UPDATE);
				return ERROR;
			}
			tblDictionary = tblDictionaryService.selectByPrimaryKey(id);
			tblDictionary.setLookupkey(lookupkey);
			tblDictionary.setLookupvalue(lookupvalue);
			if (describeinfo == null || "".equals(describeinfo)) {
				describeinfo = null;
			}
			tblDictionary.setDescribeinfo(describeinfo);
			tblDictionary.setUpdatetime(new Date());
			if (backup == null || "".equals(backup)) {
				backup = null;
			}
			tblDictionary.setBackup(backup);
			tblDictionaryService.updateByPrimaryKey(tblDictionary);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		logger.info("tblDictionary[" + id + "] is updated successfully");
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		setJsonData(200, "修改成功", "sysDict_query.action");
		return SUCCESS;
	}

	public String tblDictionaryToCreate() {
		return SUCCESS;
	}

	public String tblDictionaryCreate() {
		operateResult.setOperation(WebConstants.TBLDICTIONARY_CREATE);
		operateResult.setUrl("tblDictionaryQuery.action");

		TblDictionaryExample example = new TblDictionaryExample();
		example.createCriteria().andLookupkeyEqualTo(lookupkey);
		try {
			if (!tblDictionaryService.checkSimilarity(example, id,
					Constants.CHECKSIMILARITY_MODE_CREATE)) {
				logger.info("cannot create, for the inputed lookupkey["
						+ lookupkey + "] is already exist");
				operateResult.setResult(WebConstants.OPERATE_RESULT_FAIL);
				operateResult
						.setReason(WebConstants.OPERATERESULT_REASON_TBLDICTIONARY_CREATE);
				return ERROR;
			}
			tblDictionary = new TblDictionary();
			tblDictionary.setLookupkey(lookupkey);
			tblDictionary.setLookupvalue(lookupvalue);
			if (describeinfo == null || "".equals(describeinfo)) {
				describeinfo = null;
			}
			tblDictionary.setDescribeinfo(describeinfo);
			tblDictionary.setUpdatetime(new Date());
			if (backup == null || "".equals(backup)) {
				backup = null;
			}
			tblDictionary.setBackup(backup);
			tblDictionaryService.insertSelective(tblDictionary);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	public String tblDictionaryDelete() {
		operateResult.setOperation(WebConstants.TBLDICTIONARY_DELETE);
		operateResult.setUrl("tblDictionaryQuery.action");
		for (int i = 0; i < ids.length; i++) {
			tblDictionaryService.deleteByPrimaryKey(ids[i]);
			logger.info("tblDictionary[" + ids[i] + "] is deleted");
		}
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLookupkey() {
		return lookupkey;
	}

	public void setLookupkey(String lookupkey) {
		this.lookupkey = lookupkey;
	}

	public String getLookupvalue() {
		return lookupvalue;
	}

	public void setLookupvalue(String lookupvalue) {
		this.lookupvalue = lookupvalue;
	}

	public String getDescribeinfo() {
		return describeinfo;
	}

	public void setDescribeinfo(String describeinfo) {
		this.describeinfo = describeinfo;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getBackup() {
		return backup;
	}

	public void setBackup(String backup) {
		this.backup = backup;
	}

	public TblDictionary getTblDictionary() {
		return tblDictionary;
	}

	public void setTblDictionary(TblDictionary tblDictionary) {
		this.tblDictionary = tblDictionary;
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
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
}
