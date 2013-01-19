package com.sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.enjoyor.util.MD5.KeyedDigestMD5;
import com.pub.action.AbstractAction;
import com.pub.util.constant.Constants;
import com.pub.util.session.LoginSessionBindingListener;
import com.sys.service.SysLogService;
import com.sys.service.SysResourceService;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserService;
import com.sys.vo.MenuNode;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysResource;
import com.sys.vo.SysUser;
import com.sys.vo.SysUserExample;

@Controller
@Scope("prototype")
public class LoginAction extends AbstractAction implements SessionAware {

	private static final long serialVersionUID = -1006252987556326592L;

	@Resource
	private SysUserService userService;
	@Resource
	private SysRoleService roleService;
	@Resource
	private SysResourceService resourceService;
	@Resource
	private SysLogService sysLogService;
	private String username;
	private String password;
	private String newPassword;
	private String checkCode;
	private String randCode;
	private String errMsg;

	public String ajaxRandCodeRequest() {
		randCode = (String) session.get(Constants.RAND_CODE);
		//addActionMessage("");
		return SUCCESS;
	}

	public String logout() {
		logger.info("logout");
		session.clear();
		return "logout";
	}
	
	public String changePassword() {

		username = (String) session.get(Constants.USER_NAME);

		SysUserExample example = new SysUserExample();
		String md5Password = KeyedDigestMD5.getKeyedDigest(password, "");
		example.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(md5Password);
		List<SysUser> list = userService.selectByExample(example);
		if (list.size() == 1) {
			SysUser sysUser = list.get(0);
			sysUser.setPassword(KeyedDigestMD5.getKeyedDigest(newPassword, ""));
			userService.updateByPrimaryKey(sysUser);
			//这里在request对象中放了一个data，所以struts的result配置中不能有type="redirect"   
	        setJsonData(200, "修改成功！"); 
		} else {
			// addActionMessage(Constants.LOGIN_ERROR_4);
			setJsonData(300, "旧密码不正确！");
		}
		return SUCCESS;
	}

	/**
	 * @Description: 用户登陆
	 * @author xhh
	 * @date 2012-6-5 下午2:15:47
	 * @return
	 */
	public String login() {
		logger.info("后台开启登录验证/login()");
		// 校验用户名或者密码是否为空
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			//addActionMessage(Constants.LOGIN_ERROR_1);
			errMsg = Constants.LOGIN_ERROR_1;
			return LOGIN;
		}
		// 校验证码的正确性
		String randCode = (String) session.get(Constants.RAND_CODE);
		if (randCode == null) {
			//addActionMessage(Constants.LOGIN_ERROR_2);
			errMsg = Constants.LOGIN_ERROR_2;
			return LOGIN;
		}
		if (!checkCode.equals(randCode)) {
			//addActionMessage(Constants.LOGIN_ERROR_3);
			errMsg = Constants.LOGIN_ERROR_3;
			return LOGIN;
		}
		// 校验用户名及密码的正确性
		SysUserExample example = new SysUserExample();
		String md5Password = KeyedDigestMD5.getKeyedDigest(password, "");
		example.createCriteria().andUsernameEqualTo(username)
				.andPasswordEqualTo(md5Password);
		try {
			List<SysUser> list = userService.selectByExample(example);
			if (list.size() == 1) {
				SysUser sysUser = list.get(0);
				session.put(Constants.USER_NAME, username);
				session.put(Constants.UID, sysUser.getUid());
				session.put(Constants.RID, sysUser.getRid());
				session.put(Constants.LOGIN_IP, Constants.getUserIp());
				// 设置session绑定监听，用于session过期和退出登录记录操作日志
				LoginSessionBindingListener sessionListener = new LoginSessionBindingListener(
						sysLogService, sysUser.getUid(), Constants.getUserIp());
				session.put(sessionListener.toString(), sessionListener);

				// 获取用户权限菜单
				List<SysResFuncRelation> unionRelation = putPrivilege(
						sysUser.getUid(), sysUser.getRid());
				// 将资源对象转化为json形式，便于js处理，用于生成左侧资源菜单
				String json = toJSON(unionRelation);
				resultList = parseMenu(unionRelation);
				session.put(Constants.USER_MENU, resultList);
//				String defaultMenu=parseMenu(unionRelation);
				session.put(Constants.LET_MENU_RESOURCES, json);
				
				return SUCCESS;
			} else {
				//addActionMessage(Constants.LOGIN_ERROR_4);
				errMsg = Constants.LOGIN_ERROR_4;
				return LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//addActionMessage(Constants.LOGIN_ERROR_5);
			errMsg = Constants.LOGIN_ERROR_5;
			return LOGIN;
		}
	}

	private List<SysResFuncRelation> putPrivilege(Integer uid, Integer rid) {
		List<SysResFuncRelation> unionRelation = null;
		// 用户权限
		unionRelation = userService.selectResFuncByUserId(uid);
		String resTypeValue = Constants.RES_TYPE_USER;
		if (unionRelation.isEmpty()) { // 如果用户权限为null，则取角色权限
			unionRelation = roleService.selectResFuncByRoleId(rid);
			resTypeValue = Constants.RES_TYPE_ROLE;
		}
		session.put(Constants.RES_TYPE, resTypeValue);
		session.put(Constants.PRIVILEGE, unionRelation);
		return unionRelation;
	}

	/**
	 * 将资源对象转化为json格式，便于客户端js处理，用于生成左侧资源菜单
	 */
	private String toJSON(List<SysResFuncRelation> list) {
		List<SysResource> resList = resourceService.selectByExample(null);
		boolean isRemove;
		for (int i = 0; i < resList.size(); i++) {
			if ("Y".equals(resList.get(i).getIsParent())) {
				continue;
			}
			isRemove = true;
			for (SysResFuncRelation rel : list) {
				if (rel.getSysResource().getResid() == resList.get(i)
						.getResid()) {
					isRemove = false;
					break;
				}
			}
			if (isRemove) {
				int count = removeResource(resList, i);
				i = i - count; // 根据移除节点的数目重置指针索引
			}
		}
		List<SysResource> dst = new ArrayList<SysResource>();
		// 将节点（资源）列表排序 第一级节点的父节点为0
		sortResList(dst, resList, 0);
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		for (SysResource record : dst) {
			if ("Y".equals(record.getIsParent())) {
				buf.append("{level:").append(record.getResLevel())
						.append(", name:'").append(record.getResName())
						.append("'},");
			} else {
				buf.append("{").append("level:").append(record.getResLevel())
						.append(", name:'").append(record.getResName())
						.append("', ico:'").append(record.getImgUrl())
						.append("', link:'").append(record.getUrl())
						.append("'},");
			}
		}
		buf.deleteCharAt(buf.length() - 1);
		buf.append("]");
		logger.info(buf.toString());
		return buf.toString();
	}
	
	/**
	 * 解析菜单
	 * @param list
	 * @return
	 */
	private List<MenuNode> parseMenu(List<SysResFuncRelation> list) {
		//find the parent from level=1 and get the max level
		List<SysResFuncRelation> childList= new ArrayList<SysResFuncRelation>();
		Map<Integer, Integer> resKeyMap = new HashMap<Integer, Integer>();
		List<MenuNode> menus = new ArrayList<MenuNode>();
		
		for(SysResFuncRelation srfr:list) {
			if(1==srfr.getSysResource().getResLevel()&&notExistMenu(srfr,menus)) {
				menus.add(new MenuNode(srfr));
			} else {
				if(!resKeyMap.containsKey(srfr.getSysResource().getResid())) {
					resKeyMap.put(srfr.getSysResource().getResid(), srfr.getSysResource().getResid());
					childList.add(srfr);	
				}
				
			}
		}
		
		for(int i=0;i<menus.size();i++) {
			menus.set(i, composeMenu(menus.get(i), childList,true));
		}
		
		return menus;
	}

	/**
	 * 构建树菜单
	 * @param menu
	 * @param childList
	 * @return
	 */
	private MenuNode composeMenu(MenuNode menu, List<SysResFuncRelation> childList,boolean flag) {
		if(flag) {
			for(SysResFuncRelation srfr:childList) {
				if(menu.getSysResFuncRelation().getSysResource().getResid()==
						srfr.getSysResource().getParentId()) {
					//find the sub menu
					MenuNode node = new MenuNode();
					node.setSysResFuncRelation(srfr);
					menu.getChild().add(composeMenu(node, childList,true));
				}
			}
			return menu;
		} else {
			return menu;
		}
	}

	/**
	 * 判断菜单是否还未添加
	 * @param srfr
	 * @param menus
	 * @return
	 */
	private boolean notExistMenu(SysResFuncRelation srfr, List<MenuNode> menus) {
		for (MenuNode menu : menus) {
			if (srfr.getSysResource().getResid() == menu
					.getSysResFuncRelation().getSysResource().getResid()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 将src中，父节点id为pid的节点移动dst列表中
	 */
	private void sortResList(List<SysResource> dst, List<SysResource> src,
			Integer pid) {
		List<SysResource> levRes = new ArrayList<SysResource>();
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i).getParentId() == pid) {
				addResourceInOrder(levRes, src.remove(i));
				i--; // src在移除指定位置对象后，后面的对象将前移，i-1后可指向第一个新的对象
			}
		}
		// 同级的节点列表levRes插入到目标列表
		for (SysResource res : levRes) {
			dst.add(res);
			// 如果该节点是父节点，则遍历该父节点的子节点
			if ("Y".equals(res.getIsParent())) {
				sortResList(dst, src, res.getResid());
			}
		}
	}

	/**
	 * 根据资源的优先级，将record插入到list的特定位置
	 */
	private void addResourceInOrder(List<SysResource> list, SysResource record) {
		if (list.isEmpty()) {
			list.add(record);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (record.getPrio() < list.get(i).getPrio()) {
				list.add(i, record);
				break;
			}
			if (i == list.size() - 1) {
				list.add(record);
				break;
			}
		}
	}

	/**
	 * 移除资源节点，并考虑父节点的去留。结果返回移除节点的数目
	 */
	private int removeResource(List<SysResource> list, int i) {
		SysResource record = list.remove(i);
		int count = 1; // 记录移除对象的个数
		if (record.getParentId() == null) {
			return count;
		}
		boolean canRm = true;
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getParentId() == record.getParentId()) {
				canRm = false;
				break;
			}
		}
		if (canRm) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).getResid() == record.getParentId()) {
					count += removeResource(list, j);
				}
			}
		}
		return count;
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

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/** 
	 * @return newPassword 
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
