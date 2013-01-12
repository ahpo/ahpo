/**   
 * @Title: SysDeptAction.java 
 * @Package com.sys.action 
 * @author zgr  
 * @date 2012-5-11 上午9:06:03 
 * @version V1.0   
 */
package com.sys.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.util.interceptor.SysOperLogAnnotation;
import com.pub.webapp.ui.pagination.PageHandle;
import com.sys.service.SysDepartmentService;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserService;
import com.sys.vo.SysDepartment;
import com.sys.vo.SysDepartmentExample;

/**
 * @ClassName: SysDeptAction
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-11 上午9:06:03
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class SysDeptAction extends AbstractAction {

	
	private static final long serialVersionUID = 2610732170527001408L;
	private SysDepartment sysDept;
	private Integer did;

	private String dname;

	private String memo;

	private String enable;

	private Integer parentId;

	private String imgUrl;

	@Resource
	private SysDepartmentService sysDepartmentService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysRoleService sysRoleService;

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public void setSysDepartmentService(
			SysDepartmentService sysDepartmentService) {
		this.sysDepartmentService = sysDepartmentService;
	}

	public String sysDeptQuery() {
		String resCode = Constants.QUERY_SYSDEPT_QUERY;
		Map<String, Object> session = ActionContext.getContext().getSession();

		String resType = (String) session.get(Constants.RES_TYPE);
		Integer urid;
		if (Constants.RES_TYPE_USER.equals(resType)) {
			urid = (Integer) session.get(Constants.UID);
			funcList = sysUserService.selectFuncByUidAndResCode(urid, resCode);
		} else {
			urid = (Integer) session.get(Constants.RID);
			funcList = sysRoleService.selectFuncByRidAndResCode(urid, resCode);
		}
		if (funcList == null || funcList.isEmpty()) {
			return LOGIN;
		}
		int total = sysDepartmentService.countByExample(null);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(null, pageNum, pageMethod, total);
		resultList = sysDepartmentService.selectPageByExample(null,
				page.getStartRow(), page.getNumPerPage());
		return SUCCESS;
	}

	public String sysDeptToUpdate() {
		sysDept = sysDepartmentService.selectByPrimaryKey(did);
		if (sysDept != null) {
			SysDepartmentExample example = new SysDepartmentExample();
			example.createCriteria().andDidNotEqualTo(did);
			resultList = sysDepartmentService.selectByExample(example);
			return SUCCESS;
		} else {
			Map<String, String> parms = new HashMap<String, String>();
			parms.put("currentPage", pageNum);
			operateResult.setParms(parms);
			operateResult.setOperation("修改部门信息");
			operateResult.setUrl("sysDeptQuery.action");
			operateResult.setResult("操作失败");
			operateResult.setReason("该部门信息不存在");
			return ERROR;
		}
	}

	@SysOperLogAnnotation(value = "修改部门信息")
	public String sysDeptUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", pageNum);
		operateResult.setParms(parms);
		operateResult.setOperation("修改部门信息");
		operateResult.setUrl("sysDeptQuery.action");
		SysDepartmentExample example = new SysDepartmentExample();
		example.createCriteria().andDnameEqualTo(dname.trim());
		if (!sysDepartmentService.checkSimilarity(example, did, 0)) {
			operateResult.setResult("操作失败");
			operateResult.setReason("部门已存在或输入信息有误！");
			return SUCCESS;
		}
		sysDept = sysDepartmentService.selectByPrimaryKey(did);
		if (sysDept != null) {
			sysDept.setDname(dname.trim());
			sysDept.setEnable(enable);
			if ("".equals(memo.trim())) {
				memo = null;
			}
			sysDept.setMemo(memo);
			if (parentId != null && parentId == 0) {
				parentId = null;
			}
			sysDept.setParentId(parentId);
			if ("".equals(imgUrl.trim())) {
				imgUrl = null;
			}
			sysDept.setImgUrl(imgUrl);
			sysDepartmentService.updateByPrimaryKey(sysDept);
			operateResult.setResult("操作成功");
			return SUCCESS;
		} else {
			operateResult.setResult("操作失败");
			operateResult.setReason("该部门信息不存在");
			return SUCCESS;
		}
	}

	public String sysDeptToCreate() {
		resultList = sysDepartmentService.selectByExample(null);
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "创建部门信息")
	public String sysDeptCreate() {
		operateResult.setOperation("新建部门信息");
		operateResult.setUrl("sysDeptQuery.action");
		SysDepartmentExample example = new SysDepartmentExample();
		example.createCriteria().andDnameEqualTo(dname.trim());
		if (!sysDepartmentService.checkSimilarity(example, did, 1)) {
			operateResult.setResult("操作失败");
			operateResult.setReason("输入信息有误！");
			return SUCCESS;
		}
		sysDept = new SysDepartment();
		sysDept.setDname(dname.trim());
		sysDept.setEnable(enable);
		if ("".equals(memo.trim())) {
			memo = null;
		}
		sysDept.setMemo(memo);
		if (parentId != null && parentId == 0) {
			parentId = null;
		}
		sysDept.setParentId(parentId);
		if ("".equals(imgUrl.trim())) {
			imgUrl = null;
		}
		sysDept.setImgUrl(imgUrl);
		sysDepartmentService.insertSelective(sysDept);
		operateResult.setResult("操作成功");
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "删除部门信息")
	public String sysDeptDelete() {
		operateResult.setOperation("删除部门信息");
		operateResult.setUrl("sysDeptQuery.action");
		int errNum = 0, sucNum = 0;
		int rtn = 0;
		for (int i = 0; i < ids.length; i++) {
			rtn = sysDepartmentService.deleteByPrimaryKey(ids[i]);
			if (rtn < 1) {
				LOGGER.info("failed to delete sysDept[" + ids[i] + "]");
				errNum++;
			} else {
				LOGGER.info("sysDept[" + ids[i] + "] is deleted");
				sucNum++;
			}
		}
		operateResult.setResult("删除成功：" + sucNum + "条， 删除失败：" + errNum + "条。");
		if (errNum > 0) {
			operateResult.setReason("该部门信息正在被使用或者不存在");
		}
		return SUCCESS;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public SysDepartment getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDepartment sysDept) {
		this.sysDept = sysDept;
	}
	
}
