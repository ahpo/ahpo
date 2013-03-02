/**   
 * @Title: SysRoleAction.java 
 * @Package com.sys.action 
 * @author zgr  
 * @date 2012-5-8 上午11:19:51 
 * @version V1.0   
 */
package com.sys.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.util.interceptor.SysOperLogAnnotation;
import com.pub.webapp.ui.pagination.PageHandle;
import com.pub.webapp.ui.tree.CheckedNode;
import com.pub.webapp.ui.tree.Node;
import com.pub.webapp.ui.tree.TreeNode;
import com.pub.webapp.ui.tree.TreeSupport;
import com.sys.service.SysFunctionService;
import com.sys.service.SysResourceService;
import com.sys.service.SysRoleRFService;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserService;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysResource;
import com.sys.vo.SysRole;
import com.sys.vo.SysRoleExample;

/**
 * @ClassName: SysRoleAction
 * @Description: 角色管理
 * @author zgr
 * @date 2012-5-8 上午11:19:51
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class SysRoleAction extends AbstractAction implements SessionAware {


	private static final long serialVersionUID = -2076862416045602917L;
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysResourceService sysResourceService;
	@Resource
	private SysFunctionService sysFunctionService;
	@Resource
	private SysRoleRFService sysRoleRFService;
	@Resource
	private SysUserService sysUserService;
	
	private SysRole sysRole;
	private Integer rid;

	private String rname;

	private String enable;

	private Integer parentId;

	private String imgUrl;

	private Date created;

	private String creator;
	
	private String[] menuId;

	private TreeNode roleTreeNode;

	public String sysRoleQuery() {
		String resCode = Constants.QUERY_SYSROLE_QUERY;
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
		int total = sysRoleService.countByExample(null);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(null, pageNum, pageMethod, total);
		resultList = sysRoleService.selectPageByExample(null,
				page.getStartRow(), page.getNumPerPage());
		return SUCCESS;
	}

	public String sysRoleToUpdate() {
		sysRole = sysRoleService.selectByPrimaryKey(rid);
		if (sysRole == null) {
			Map<String, String> parms = new HashMap<String, String>();
			parms.put("currentPage", pageNum);
			operateResult.setParms(parms);
			operateResult.setOperation("修改系统角色");
			operateResult.setUrl("sysRoleQuery.action");
			operateResult.setResult("操作失败");
			operateResult.setReason("该角色不存在");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	@SysOperLogAnnotation(value = "修改系统角色信息")
	public String sysRoleUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", pageNum);
		operateResult.setParms(parms);
		operateResult.setOperation("修改系统角色");
		operateResult.setUrl("sysRoleQuery.action");
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRnameEqualTo(rname);
		if (!sysRoleService.checkSimilarity(example, rid, 0)) {
			operateResult.setResult("操作失败");
			operateResult.setReason("输入数据有误");
			return SUCCESS;
		}
		sysRole = sysRoleService.selectByPrimaryKey(rid);
		if (sysRole != null) {
			sysRole.setRname(rname);
			sysRole.setEnable(enable);
			sysRole.setParentId(parentId);
			sysRole.setImgUrl(imgUrl);
			sysRoleService.updateByPrimaryKey(sysRole);
			operateResult.setResult("操作成功");
		} else {
			operateResult.setResult("操作失败");
			operateResult.setReason("该角色不存在");
		}
		return SUCCESS;
	}

	public String sysRoleToCreate() {
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "创建系统角色信息")
	public String sysRoleCreate() {
		operateResult.setOperation("创建系统角色");
		operateResult.setUrl("sysRoleQuery.action");
		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andRnameEqualTo(rname.trim());
		if (sysRoleService.checkSimilarity(example, rid, 1)) {
			sysRole = new SysRole();
			sysRole.setRname(rname.trim());
			sysRole.setEnable(enable);
			sysRole.setParentId(parentId);
			sysRole.setImgUrl(imgUrl);
			sysRole.setCreated(new Date());
			creator = (String) session.get("username");
			sysRole.setCreator(creator);
			sysRoleService.insertSelective(sysRole);
			operateResult.setResult("创建成功");
		} else {
			operateResult.setResult("创建失败");
			operateResult.setReason("输入信息有误，请核对后重试！");
		}
		setJsonData(200, "删除成功", "sysRoleQuery.action");
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "删除系统角色信息")
	public String sysRoleDelete() {
		operateResult.setOperation("删除系统角色");
		operateResult.setUrl("sysRoleQuery.action");
		int errNum = 0, sucNum = 0;
		int rtn = 0;
		String[] ids = cids.split(",");
		
		for (int i = 0; i < ids.length; i++) {
			rtn = sysRoleService.deleteByPrimaryKey(Integer.parseInt(ids[i]));
			if (rtn < 1) {
				logger.info("failed to delete sysRole[" + ids[i] + "]");
				errNum++;
			} else {
				logger.info("sysRole[" + ids[i] + "] is deleted");
				sucNum++;
			}
		}
		operateResult.setResult("删除成功：" + sucNum + "条， 删除失败：" + errNum + "条。");
		if (errNum > 0) {
			operateResult.setReason("该角色正在被使用或者不存在");
		}
		setJsonData(200, "操作成功", "sysRoleQuery.action");
		return SUCCESS;
	}

	public String sysRoleToPrivilege() {
		List<SysResFuncRelation> relList = sysRoleService
				.selectResFuncByRoleId(rid);
		sysRole = sysRoleService.selectByPrimaryKey(rid);
		if (sysRole != null) {
			List<SysResource> resList = sysResourceService
					.selectByExample(null);
			createTree(relList, resList);
			return SUCCESS;
		} else {
			Map<String, String> parms = new HashMap<String, String>();
			parms.put("currentPage", pageNum);
			operateResult.setParms(parms);
			operateResult.setOperation("修改角色权限");
			operateResult.setUrl("sysRoleQuery.action");
			operateResult.setResult("操作失败");
			operateResult.setReason("该角色不存在");
			return ERROR;
		}
	}

	@SysOperLogAnnotation(value = "为系统角色分配权限")
	public String sysRolePrivilege() {
		sysRoleRFService.deleteRoleRFByRid(rid);
		if (menuId != null) {
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < menuId.length; i++) {
				String[] idArray = menuId[i].split("_");
				if (idArray[0].startsWith("f")) { // 根据被选择的功能菜单解析funcid和resid
					String func = idArray[0].substring(1,
							idArray[0].indexOf("s"));
					// 更新用户权限到数据库
					int rtn = sysRoleRFService.insertIntoRoleRF(rid,
							new Integer(idArray[1]), new Integer(func));
					if (rtn == 1) {
						set.add(idArray[1]);
					}
				}
			}
			Iterator<String> idIt = set.iterator();
			while (idIt.hasNext()) { // 无论浏览功能有没有被选，如果某资源被分配权限，则一定分配浏览权限
				String it = idIt.next();
				boolean update_flag = true;
				for (int i = 0; i < menuId.length; i++) {
					String[] idArray = menuId[i].split("_");
					if (idArray[0].startsWith("f")) {
						String func = idArray[0].substring(1,
								idArray[0].indexOf("s"));
						if (equalsTo(it, idArray[1]) && "4".equals(func)) {
							update_flag = false;
							break;
						}
					}
				}
				if (update_flag) {
					sysRoleRFService.insertIntoRoleRF(rid, new Integer(it), 4);
				}
			}
		}
		operateResult.setOperation("分配角色权限");
		operateResult.setResult("操作成功");
		operateResult.setUrl("sysRoleQuery.action");
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", pageNum);
		operateResult.setParms(parms);
		return SUCCESS;
	}

	private void createTree(List<SysResFuncRelation> relList,
			List<SysResource> resList) {
		List<SysFunction> funcList = sysFunctionService.selectByExample(null);
		Iterator<SysResource> resIt = resList.iterator();
		Iterator<SysFunction> funcIt = null;
		TreeSupport treeSupport = null;
		// 生成树节点
		List<Node> nodeItems = new ArrayList<Node>();
		CheckedNode checkNode = null;
		SysResource res = null;
		SysFunction func = null;

		while (resIt.hasNext()) {
			res = resIt.next();
			checkNode = new CheckedNode();
			checkNode.setId(res.getResid().toString());
			checkNode.setName(getText(res.getResName()));
			checkNode.setParentId(res.getParentId().toString());
			checkNode.setChecked(false);
			logger.info("checkNode:" + res.getResName());
			nodeItems.add(checkNode);
			if ("N".equals(res.getIsParent())) {
				funcIt = funcList.iterator();
				while (funcIt.hasNext()) {
					boolean checked = false;
					func = funcIt.next();
					for (SysResFuncRelation rel : relList) {
						if (equalsTo(res.getResName(), rel.getSysResource()
								.getResName())
								&& equalsTo(func.getFuncid(), rel
										.getSysFunction().getFuncid())) {
							checked = true;
							break;
						}
					}
					checkNode = new CheckedNode();
					checkNode.setId("f" + func.getFuncid().toString() + "s"
							+ res.getResid().toString());
					checkNode.setName(getText(func.getFuncName()));
					checkNode.setParentId(res.getResid().toString());
					checkNode.setChecked(checked);
					checkNode.setType("f");
					logger.info("checkNode:" + func.getFuncName() + "pid"
							+ checkNode.getParentId());
					nodeItems.add(checkNode);
				}
			}
		}
		// 生成树
		treeSupport = new TreeSupport();
		roleTreeNode = treeSupport.createCheckBoxTreeNode(nodeItems);
	}

	private boolean equalsTo(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		return str1.equals(str2);
	}

	private boolean equalsTo(Integer str1, Integer str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		return str1.equals(str2);
	}

	public Integer getRid() {
		return rid;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	
	public TreeNode getRoleTreeNode() {
		return roleTreeNode;
	}

	public void setRoleTreeNode(TreeNode userTreeNode) {
		this.roleTreeNode = userTreeNode;
	}

	public String[] getMenuId() {
		return menuId;
	}

	public void setMenuId(String[] menuId) {
		this.menuId = menuId;
	}

}
