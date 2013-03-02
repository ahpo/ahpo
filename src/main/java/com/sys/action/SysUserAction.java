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

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.enjoyor.util.MD5.KeyedDigestMD5;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.util.interceptor.SysOperLogAnnotation;
import com.pub.webapp.ui.pagination.PageHandle;
import com.pub.webapp.ui.tree.CheckedNode;
import com.pub.webapp.ui.tree.Node;
import com.pub.webapp.ui.tree.TreeNode;
import com.pub.webapp.ui.tree.TreeSupport;
import com.pub.webapp.ui.util.WebConstants;
import com.sys.service.SysDepartmentService;
import com.sys.service.SysFunctionService;
import com.sys.service.SysResourceService;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserRFService;
import com.sys.service.SysUserService;
import com.sys.vo.ResNode;
import com.sys.vo.SysDepartment;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysResource;
import com.sys.vo.SysRole;
import com.sys.vo.SysUser;
import com.sys.vo.SysUserExample;

@Controller
@Scope("prototype")
public class SysUserAction extends AbstractAction implements SessionAware {

	private static final long serialVersionUID = 6690782758635638373L;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysDepartmentService sysDepartmentService;
	@Resource
	private SysResourceService sysResourceService;
	@Resource
	private SysFunctionService sysFunctionService;
	@Resource
	private SysUserRFService sysUserRFService;
	
	private SysUser sysUser;
	private Integer uid;
	private Integer rid;
	private SysRole uRole;
	private Integer did;
	private SysDepartment uDepartment;
	private String username;
	private String password;
	private String oldpassword;
	private String truename;
	private String mobile;
	private String tel;
	private String fax;
	private String email;
	private String address;
	private Date lastTime;
	private String lastIp;
	private String enable;
	private String deleted;
	private Date updated;
	private Date created;
	private String creator;
	private String mender;
	private String[] menuId;
	
	private TreeNode userTreeNode;

	private SysResource sysResource;
	
	private List<SysRole> sysRoles;
	private List<SysDepartment> sysDepartments;
	
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String sysUserQuery() {
		
		sysRoles = sysRoleService.selectByExample(null);
		sysDepartments = sysDepartmentService.selectByExample(null);
		
		String resCode = Constants.QUERY_SYSUSER_QUERY;
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
		
		SysUserExample example= new SysUserExample();
		if(null!=did && 0!=did) {
			example.createCriteria().andDidEqualTo(did);
		}
		if(null!=rid && 0!=rid) {
			example.createCriteria().andRidEqualTo(rid);
		}
		if(StringUtils.isNotEmpty(keywords)) {
			example.createCriteria().andTruenameLike(keywords);
		}
		
		int total = sysUserService.countByExample(example);
		pageHandler = new PageHandle();
		page = pageHandler.getPage(null, pageNum, pageMethod, total);
		
		
		
		resultList = sysUserService.selectPageByExample(example,
				page.getStartRow(), page.getNumPerPage());
		if (resultList == null) {
			operateResult.setOperation(Constants.OPERATE_QUERY);
			operateResult.setResult(Constants.OPERATE_QUERY_FAIL);
			operateResult.setReason(Constants.OPERATE_QUERY_FAIL_REASON);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String sysResQuery() {
//		String resCode = Constants.QUERY_SYSRES_QUERY;
//		String resType = (String) session.get(Constants.RES_TYPE);
//		SysResourceExample example = new SysResourceExample();
//		example.createCriteria().andParentIdEqualTo(0);
		List<SysResource> result = sysResourceService.selectByExample(null);
		resultList = res2tree(result);
		
		if (resultList == null) {
			operateResult.setOperation(Constants.OPERATE_QUERY);
			operateResult.setResult(Constants.OPERATE_QUERY_FAIL);
			operateResult.setReason(Constants.OPERATE_QUERY_FAIL_REASON);
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String sysResDetail() {
		
		sysResource = sysResourceService.selectByPrimaryKey(rid);
		
		return SUCCESS;
	}
	
	public String sysResUpdate() {
		@SuppressWarnings("unused")
		int result = sysResourceService.updateByPrimaryKey(sysResource);
		return SUCCESS;
	}
	
	public String sysResDelete() {
		@SuppressWarnings("unused")
		int result = sysResourceService.deleteByPrimaryKey(rid);
		setJsonData(200, "操作成功", "sysResQuery.action");
		return SUCCESS;
	}


	private List<?> res2tree(List<SysResource> result) {
		List<ResNode> ress = new ArrayList<ResNode>();
		List<SysResource> childList = new ArrayList<SysResource>();
		for(SysResource sr:result) {
			if(sr.getParentId()==0) {
				ress.add(new ResNode(sr));
			} else {
				childList.add(sr);
			}
		}
		
		for(int i=0;i<ress.size();i++) {
			ress.set(i, recursionRes(ress.get(i), childList,true));
		}
		
		return ress;
	}

	/**
	 * 递归构建树
	 * @param resNode
	 * @param childList
	 * @param flag
	 * @return
	 */
	private ResNode recursionRes(ResNode resNode, List<SysResource> childList,
			boolean flag) {
		if(flag) {
			for(SysResource sr:childList) {
				if(resNode.getSysResource().getResid()==
						sr.getParentId()) {
					//find the sub menu
					ResNode node = new ResNode(sr);
					resNode.getChild().add(recursionRes(node, childList,true));
				}
			}
			return resNode;
		} else {
			return resNode;
		}
	}

	public String sysUserToUpdate() {
		sysUser = sysUserService.selectByPrimaryKey(uid);
		if (sysUser != null) {
			sysRoles = sysRoleService.selectByExample(null);
			sysDepartments = sysDepartmentService.selectByExample(null);
			return SUCCESS;
		} else {
			Map<String, String> parms = new HashMap<String, String>();
			parms.put("currentPage", pageNum);
			operateResult.setParms(parms);
			operateResult.setOperation("修改系统用户信息");
			operateResult.setUrl("sysUserQuery.action");
			operateResult.setResult("修改用户失败");
			operateResult.setReason("该用户不存在");
			return ERROR;
		}
	}

	@SysOperLogAnnotation(value = "修改系统用户信息")
	public String sysUserUpdate() {
		Map<String, String> parms = new HashMap<String, String>();
		parms.put("currentPage", pageNum);
		operateResult.setParms(parms);
		operateResult.setOperation("修改系统用户信息");
		operateResult.setUrl("sysUserQuery.action");
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(username.trim());
		if (!sysUserService.checkSimilarity(example, uid, 0)) {
			operateResult.setResult("修改失败");
			operateResult.setReason("输入数据有误");
			return SUCCESS;
		}
		sysUser = sysUserService.selectByPrimaryKey(uid);
		if (sysUser != null) {
			sysUser.setUsername(username);
			sysUser.setTruename(truename);
			sysUser.setMobile(mobile);
			sysUser.setTel(tel);
			sysUser.setFax(fax);
			sysUser.setEmail(email);
			sysUser.setAddress(address);
			sysUser.setEnable(enable);
			sysUser.setUpdated(new Date());
			sysUser.setRid(rid);
			sysUser.setDid(did);
			sysUserService.updateByPrimaryKey(sysUser);
			operateResult.setResult("修改成功");
		} else {
			// 设置操作结果信息
			operateResult.setResult("修改失败");
			operateResult.setReason("输入数据有误");
		}
		return SUCCESS;
	}

	public String sysUserToUpdatePwd() {
		uid = (Integer) session.get(Constants.UID);
		sysUser = sysUserService.selectByPrimaryKey(uid);
		return SUCCESS;
	}

	public String sysUserUpdatePwd() {
		operateResult.setOperation("修改用户密码");
		operateResult.setUrl("sysUserQuery.action");
		SysUser record = sysUserService.selectByPrimaryKey(uid);
		String oldpwd = KeyedDigestMD5.getKeyedDigest(oldpassword, "");
		if (oldpwd == null || !oldpwd.equals(record.getPassword())) {
			operateResult.setResult(WebConstants.OPERATE_RESULT_FAIL);
			operateResult.setReason("原密码输入错误");
			return SUCCESS;
		}
		record.setPassword(KeyedDigestMD5.getKeyedDigest(password, ""));
		record.setUpdated(new Date());
		sysUserService.updateByPrimaryKey(record);
		operateResult.setResult(WebConstants.OPERATE_RESULT_SUCCESS);
		return SUCCESS;
	}

	public String sysUserToCreate() {
		sysRoles = sysRoleService.selectByExample(null);
		sysDepartments = sysDepartmentService.selectByExample(null);
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "创建系统用户信息")
	public String sysUserCreate() {
		operateResult.setOperation("创建系统用户");
		operateResult.setUrl("sysUserQuery.action");
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsernameEqualTo(username.trim());
		if (sysUserService.checkSimilarity(example, uid, 1)) {
			SysUser sysUser = new SysUser();
			sysUser.setUsername(username.trim());
			sysUser.setTruename(truename.trim());
			sysUser.setPassword(KeyedDigestMD5.getKeyedDigest(password, ""));
			sysUser.setMobile(mobile);
			sysUser.setTel(tel);
			sysUser.setFax(fax);
			sysUser.setEmail(email);
			sysUser.setAddress(address);
			sysUser.setEnable(enable);
			sysUser.setUpdated(new Date());
			sysUser.setCreated(new Date());
			creator = (String) session.get("username");
			sysUser.setCreator(creator);
			sysUser.setRid(rid);
			sysUser.setDid(did);
			sysUserService.insertSelective(sysUser);
			operateResult.setResult("创建成功");
		} else {
			operateResult.setResult("创建失败");
			operateResult.setResult("新用户名已存在");
		}
		setJsonData(200, "操作成功", "sysUserQuery.action");
		return SUCCESS;
	}

	@SysOperLogAnnotation(value = "删除系统用户信息")
	public String sysUserDelete() {
		operateResult.setOperation("删除系统用户");
		operateResult.setUrl("sysUserQuery.action");
		int sucNum = 0, errNum = 0;
		int rtn = 0;
		String[] ids = cids.split(",");
		for (int i = 0; i < ids.length; i++) {
			rtn = sysUserService.deleteByPrimaryKey(Integer.parseInt(ids[i]));
			if (rtn < 1) {
				logger.info("failed to delete sysUser[" + ids[i] + "]");
				errNum++;
			} else {
				logger.info("sysUser[" + ids[i] + "] is deleted");
				sucNum++;
			}
		}
		operateResult.setResult("删除成功：" + sucNum + "条， 删除失败：" + errNum + "条。");
		if (errNum > 0) {
			operateResult.setReason("该用户记录正在被使用或者不存在");
		}
		setJsonData(200, "操作成功", "sysUserQuery.action");
		return SUCCESS;
	}

	public String sysUserToPrivilege() {
		List<SysResFuncRelation> relList = sysUserService
				.selectResFuncByUserId(uid);
		sysUser = sysUserService.selectByPrimaryKey(uid);
		if (sysUser != null) {
			List<SysResource> resList = sysResourceService
					.selectByExample(null);
			createTree(relList, resList);
			return SUCCESS;
		} else {
			Map<String, String> parms = new HashMap<String, String>();
			parms.put("currentPage", pageNum);
			operateResult.setParms(parms);
			operateResult.setOperation("修改系统用户权限");
			operateResult.setUrl("sysUserQuery.action");
			operateResult.setResult("操作失败");
			operateResult.setReason("该用户不存在");
			return ERROR;
		}
	}

	@SysOperLogAnnotation(value = "为系统用户分配权限")
	public String sysUserPrivilege() {
		sysUserRFService.deleteUserRFByUid(uid);
		if (menuId != null) {
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < menuId.length; i++) {
				String[] idArray = menuId[i].split("_");
				if (idArray[0].startsWith("f")) { // 根据被选择的功能菜单解析funcid和resid
					String func = idArray[0].substring(1,
							idArray[0].indexOf("s"));
					// 更新用户权限到数据库
					int rtn = sysUserRFService.insertIntoUserRF(uid,
							Integer.valueOf(idArray[1]), new Integer(func));
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
					sysUserRFService.insertIntoUserRF(uid, new Integer(it), 4);
				}
			}
		}
		operateResult.setOperation("分配用户权限");
		operateResult.setResult("操作成功");
		operateResult.setUrl("sysUserQuery.action");
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
					nodeItems.add(checkNode);
				}
			}
		}
		// 生成树
		treeSupport = new TreeSupport();
		userTreeNode = treeSupport.createCheckBoxTreeNode(nodeItems);
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

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public SysRole getuRole() {
		return uRole;
	}

	public void setuRole(SysRole uRole) {
		this.uRole = uRole;
	}

	public SysDepartment getuDepartment() {
		return uDepartment;
	}

	public void setuDepartment(SysDepartment uDepartment) {
		this.uDepartment = uDepartment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getMobile() {
		return mobile;
	}
	

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
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

	public String getMender() {
		return mender;
	}

	public void setMender(String mender) {
		this.mender = mender;
	}

	

	public TreeNode getUserTreeNode() {
		return userTreeNode;
	}
 
	public void setUserTreeNode(TreeNode userTreeNode) {
		this.userTreeNode = userTreeNode;
	}

	public String[] getMenuId() {
		return menuId;
	}

	public void setMenuId(String[] menuId) {
		this.menuId = menuId;
	}


	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public SysResource getSysResource() {
		return sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

	public List<SysDepartment> getSysDepartments() {
		return sysDepartments;
	}

	public void setSysDepartments(List<SysDepartment> sysDepartments) {
		this.sysDepartments = sysDepartments;
	}

	public List<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	
}
