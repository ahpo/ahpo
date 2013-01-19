/**   
 * @Title: TblExcAction.java 
 * @Package com.easygo.action.ejdb 
 * @author zgr  
 * @date 2012-9-14 下午2:10:14 
 * @version V1.0   
 */
package com.sys.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;

import com.enjoyor.util.date.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.webapp.ui.pagination.Page;
import com.pub.webapp.ui.pagination.PageHandle;
import com.pub.webapp.ui.util.OperateResult;
import com.pub.webapp.ui.util.WebConstants;
import com.sys.service.TblExcService;
import com.sys.service.TblLookupService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.TblExc;
import com.sys.vo.TblExcExample;
import com.sys.vo.TblLookupExample;

/**
 * @ClassName: TblExcAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-14 下午2:10:14
 * @version 1.0
 */
public class TblExcAction extends AbstractAction {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -3307650883528298487L;
	@Resource
	private TblExcService tblExcService;
	@Resource
	private TblLookupService tblLookupService;
	
	private Integer id;
	private String project;
	private String type;
	private String status;
	private String operate;
	private Date time;
	private String message;

	private TblExc tblExc;
	private List<SysFunction> funcList;
	private Integer ids[];
	private List<?> resultList;
	private List<?> typeList;
	private OperateResult operateResult = new OperateResult();

	private PageHandle pageHandler;
	private Page page;
	private String pageMethod = "";
	private String currentPage;

	private String projectNameQuery;
	private String excTypeQuery;
	private String excStatusQuery;
	private String beginTime;
	private String endTime;

	public void setTblLookupService(TblLookupService tblLookupService) {
		this.tblLookupService = tblLookupService;
	}

	public void setTblExcService(TblExcService tblExcService) {
		this.tblExcService = tblExcService;
	}

	public String tblExcToQuery() {
		try {
			TblLookupExample example = new TblLookupExample();
			example.createCriteria().andLookupNameEqualTo(
					Constants.EG_EXC_STATUS);
			resultList = tblLookupService.selectByExample(example);
			example.clear();
			example.createCriteria()
					.andLookupNameEqualTo(Constants.EG_EXC_TYPE);
			typeList = tblLookupService.selectByExample(example);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		return SUCCESS;
	}

	public String tblExcQuery() {
		String resCode = Constants.QUERY_TBLEXC_QUERY;
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
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("projectNameQuery", projectNameQuery);
		parms.put("excTypeQuery", excTypeQuery);
		parms.put("excStatusQuery", excStatusQuery);
		parms.put("beginTime", beginTime);
		parms.put("endTime", endTime);

		TblExcExample tblExcExample = null;
		if (!"".equals(projectNameQuery) || !"".equals(excTypeQuery)
				|| !"".equals(excStatusQuery) || !"".equals(beginTime)
				|| !"".equals(endTime)) {
			tblExcExample = new TblExcExample();
			TblExcExample.Criteria criteria = tblExcExample.createCriteria();
			if (!"".equals(projectNameQuery)) {
				criteria.andProjectEqualTo(projectNameQuery);
			}
			if (!"".equals(excTypeQuery)) {
				criteria.andTypeEqualTo(excTypeQuery);
			}
			if (!"".equals(excStatusQuery)) {
				criteria.andStatusEqualTo(excStatusQuery);
			}
			if (!"".equals(beginTime)) {
				criteria.andTimeGreaterThanOrEqualTo(DateUtil.parse(beginTime));
			}
			if (!"".equals(endTime)) {
				criteria.andTimeLessThanOrEqualTo(DateUtil.parse(endTime));
			}
		}
		int total = tblExcService.countByExample(tblExcExample);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(parms, currentPage, pageMethod, total);
		try {
			resultList = tblExcService.selectPageByExampleWithBLOBs(
					tblExcExample, page.getStartRow(), page.getPageSize());
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}

		return SUCCESS;
	}

	public String tblExcToUpdate() {
		try {
			TblLookupExample example = new TblLookupExample();
			example.createCriteria().andLookupNameEqualTo(
					Constants.EG_EXC_STATUS);
			resultList = tblLookupService.selectByExample(example);
			example.clear();
			example.createCriteria()
					.andLookupNameEqualTo(Constants.EG_EXC_TYPE);
			typeList = tblLookupService.selectByExample(example);
			tblExc = tblExcService.selectByPrimaryKey(id);
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
		}
		return SUCCESS;
	}

	public String tblExcUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", currentPage);
		parms.put("projectNameQuery", projectNameQuery);
		parms.put("excTypeQuery", excTypeQuery);
		parms.put("excStatusQuery", excStatusQuery);
		parms.put("beginTime", beginTime);
		parms.put("endTime", endTime);

		operateResult.setOperation(WebConstants.TBLEXC_UPDATE);
		operateResult.setUrl("tblExcQuery.action");
		operateResult.setParms(parms);
		try {
			tblExc = tblExcService.selectByPrimaryKey(id);
			tblExc.setProject(project);
			tblExc.setMessage(message);
			tblExc.setType(type);
			tblExc.setStatus(status);
			tblExc.setTime(new Date());
			tblExcService.updateByPrimaryKeyWithBLOBs(tblExc);
		} catch (DataAccessException e) {
			logger.error("databse exception-->", e);
			return DBERROR;
		}

		logger.info("tblExc[" + id + "] is updated successfully");
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	/*public String tblExcToCreate() {
		try {
			TblLookupExample example = new TblLookupExample();
			example.createCriteria().andLookupNameEqualTo(
					Constants.EG_EXC_STATUS);
			resultList = tblLookupService.selectByExample(example);
			example.clear();
			example.createCriteria()
					.andLookupNameEqualTo(Constants.EG_EXC_TYPE);
			typeList = tblLookupService.selectByExample(example);
		} catch (DataAccessException e) {
			LOGGER.error("database exception-->", e);
			return DBERROR;
		}
		return SUCCESS;
	}

	public String tblExcCreate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("projectNameQuery", projectNameQuery);
		parms.put("excTypeQuery", excTypeQuery);
		parms.put("excStatusQuery", excStatusQuery);
		parms.put("beginTime", beginTime);
		parms.put("endTime", endTime);

		operateResult.setOperation(WebConstants.TBLEXC_CREATE);
		operateResult.setUrl("tblExcQuery.action");
		operateResult.setParms(parms);

		try {
			tblExc = new TblExc();
			tblExc.setProject(project);
			tblExc.setMessage(message);
			tblExc.setType(type);
			tblExc.setStatus(status);
			tblExc.setTime(new Date());
			tblExcService.insertSelective(tblExc);
		} catch (DataAccessException e) {
			LOGGER.error("database exception-->", e);
			return DBERROR;
		}
		LOGGER.info("tblExc is created successfully");
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}*/

	public String tblExcDelete() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("projectNameQuery", projectNameQuery);
		parms.put("excTypeQuery", excTypeQuery);
		parms.put("excStatusQuery", excStatusQuery);
		parms.put("beginTime", beginTime);
		parms.put("endTime", endTime);
		operateResult.setOperation(WebConstants.TBLEXC_DELETE);
		operateResult.setUrl("tblExcQuery.action");
		operateResult.setParms(parms);
		try {
			for (int i = 0; i < ids.length; i++) {
				tblExcService.deleteByPrimaryKey(ids[i]);
				logger.info("tblExc [" + ids[i] + "] is deleted");
			}
		} catch (DataAccessException e) {
			logger.error("database exception-->", e);
			return DBERROR;
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

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TblExc getTblExc() {
		return tblExc;
	}

	public void setTblExc(TblExc tblExc) {
		this.tblExc = tblExc;
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

	public List<?> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<?> typeList) {
		this.typeList = typeList;
	}

	public String getProjectNameQuery() {
		return projectNameQuery;
	}

	public void setProjectNameQuery(String projectNameQuery) {
		this.projectNameQuery = projectNameQuery;
	}

	public String getExcTypeQuery() {
		return excTypeQuery;
	}

	public void setExcTypeQuery(String excTypeQuery) {
		this.excTypeQuery = excTypeQuery;
	}

	public String getExcStatusQuery() {
		return excStatusQuery;
	}

	public void setExcStatusQuery(String excStatusQuery) {
		this.excStatusQuery = excStatusQuery;
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
}
