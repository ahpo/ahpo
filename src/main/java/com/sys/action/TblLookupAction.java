/**   
 * @Title: TblLookupAction.java 
 * @Package com.easygo.action.ejdb 
 * @author zgr  
 * @date 2012-9-13 下午2:44:23 
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
import com.sys.service.TblLookupService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.TblLookup;
import com.sys.vo.TblLookupExample;

/**
 * @ClassName: TblLookupAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-13 下午2:44:23
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class TblLookupAction extends AbstractAction {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -8408257014867756031L;
	@Resource
	private TblLookupService tblLookupService;
	
	private Integer id;
	private String lookupName;
	private String lookupKey;
	private String lookupValue;
	private String describeinfo;
	private Date updatetime;

	private List<SysFunction> funcList;
	private TblLookup tblLookup;

	private Integer ids[];
	private List<?> resultList;
	private OperateResult operateResult = new OperateResult();

	private PageHandle pageHandler;
	private Page page;
	private String pageMethod = "";
	private String currentPage;

	public String tblLookupQuery() {
		String resCode = Constants.QUERY_TBLLOOKUP_QUERY;
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
			int total = tblLookupService.countByExample(null);
			pageHandler = new PageHandle();
			page = pageHandler.getPage(null, currentPage, pageMethod, total);
			resultList = tblLookupService.selectPageByExample(null,
					page.getStartRow(), page.getNumPerPage());
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}

		return SUCCESS;
	}

	public String tblLookupToUpdate() {
		try {
			tblLookup = tblLookupService.selectByPrimaryKey(id);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		return SUCCESS;
	}

	public String tblLookupUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", currentPage);
		operateResult.setParms(parms);
		operateResult.setOperation(WebConstants.TBLLOOKUP_UPDATE);
		operateResult.setUrl("tblLookupQuery.action");

		TblLookupExample example = new TblLookupExample();
		example.createCriteria().andLookupNameEqualTo(lookupName)
				.andLookupKeyEqualTo(lookupKey);
		try {
			if (!tblLookupService.checkSimilarity(example, id,
					Constants.CHECKSIMILARITY_MODE_UPDATE)) {
				logger.info("cannot update, for the inputed lookupName["
						+ lookupName + "] with lookupKey[" + lookupKey
						+ "] is already exist");
				operateResult.setResult(WebConstants.OPERATE_RESULT_FAIL);
				operateResult
						.setReason(WebConstants.OPERATERESULT_REASON_TBLLOOKUP_UPDATE);
				return ERROR;
			}
			tblLookup = tblLookupService.selectByPrimaryKey(id);
			tblLookup.setLookupName(lookupName);
			tblLookup.setLookupKey(lookupKey);
			tblLookup.setLookupValue(lookupValue);
			if(describeinfo == null || "".equals(describeinfo)) {
				describeinfo = null;
			}
			tblLookup.setDescribeinfo(describeinfo);
			tblLookup.setUpdatetime(new Date());
			tblLookupService.updateByPrimaryKey(tblLookup);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		logger.info("tblLookup[" + id + "] is updated successfully");
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	public String tblLookupToCreate() {
		return SUCCESS;
	}

	public String tblLookupCreate() {
		operateResult.setOperation(WebConstants.TBLLOOKUP_CREATE);
		operateResult.setUrl("tblLookupQuery.action");

		TblLookupExample example = new TblLookupExample();
		example.createCriteria().andLookupNameEqualTo(lookupName)
				.andLookupKeyEqualTo(lookupKey);
		try {
			if (!tblLookupService.checkSimilarity(example, id,
					Constants.CHECKSIMILARITY_MODE_CREATE)) {
				logger.info("cannot create, for the inputed lookupName["
						+ lookupName + "] with lookupKey[" + lookupKey
						+ "] is already exist");
				operateResult.setResult(WebConstants.OPERATE_RESULT_FAIL);
				operateResult
						.setReason(WebConstants.OPERATERESULT_REASON_TBLLOOKUP_CREATE);
				return ERROR;
			}
			tblLookup = new TblLookup();
			tblLookup.setLookupName(lookupName);
			tblLookup.setLookupKey(lookupKey);
			tblLookup.setLookupValue(lookupValue);
			if(describeinfo == null || "".equals(describeinfo)) {
				describeinfo = null;
			}
			tblLookup.setDescribeinfo(describeinfo);
			tblLookup.setUpdatetime(new Date());
			tblLookupService.insertSelective(tblLookup);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	public String tblLookupDelete() {
		operateResult.setOperation(WebConstants.TBLLOOKUP_DELETE);
		operateResult.setUrl("tblLookupQuery.action");
		for (int i = 0; i < ids.length; i++) {
			tblLookupService.deleteByPrimaryKey(ids[i]);
			logger.info("tblLookup[" + ids[i] + "] is deleted");
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

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
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

	public List<SysFunction> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<SysFunction> funcList) {
		this.funcList = funcList;
	}

	public TblLookup getTblLookup() {
		return tblLookup;
	}

	public void setTblLookup(TblLookup tblLookup) {
		this.tblLookup = tblLookup;
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
