package com.pub.util.interceptor;

import java.util.Map;

import javax.annotation.Resource;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.pub.util.config.Config;
import com.pub.util.constant.Constants;
import com.sys.service.SysRoleService;
import com.sys.service.SysUserService;

/**
 * 
 * @ClassName: AuthenticationInterceptor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-5-9 下午5:53:52
 * @version 1.0
 */
public class AuthenticationInterceptor implements Interceptor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AuthenticationInterceptor.class);
	private static final long serialVersionUID = -6064086234947413237L;

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

	public void destroy() {
	}

	public void init() {
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
	 *      .xwork2.ActionInvocation)
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		LOGGER.info("intercept by AuthenticationInterceptor");
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();
		// 用户是否登陆
		if (session.get(Constants.USER_NAME) == null) {
			return Action.LOGIN;
		} else {
			// 拦截非法权限
			String nameSpace = actionInvocation.getProxy().getNamespace();
			String actionName = actionInvocation.getProxy().getActionName();
			// 存在nameSpace分别为('/','/test'),action name相同的情况
			String findKey = Constants.POWER_REQUEST;
			if (!"/".equals(nameSpace)) {
				// 不是根目录时,可以目录名做为Key键
			}
			// 从config.privilege.xml中获取action对应的访问权限信息
			String visitPower = Config.params.getString(findKey + actionName);
			// 访问的action在配置信息中不存在则返回Action.LOGIN
			if (visitPower == null || "".equals(visitPower)) {
				LOGGER.info("config.privilege.xml 中不存在 " + actionName + " 配置");
				return Action.LOGIN;
			}
			String[] parm = visitPower.split(Constants.POWER_SPLIT);
			boolean isPrive = true;
			if (Constants.RES_TYPE_USER.equals(session
					.get(Constants.RES_TYPE))) {
				// 登录后保存了用户的方向权限改从缓存中获取
				isPrive = sysUserService.checkPrivilegeByUidAndResCodeAndFunc(
						(Integer) session.get(Constants.UID), parm[0], parm[1]);
			} else {
				isPrive = sysRoleService.checkPrivilegeByRidAndResCodeAndFunc(
						(Integer) session.get(Constants.RID), parm[0], parm[1]);
			}
			if (isPrive) {
				return actionInvocation.invoke();
			} else {
				LOGGER.info("action: " + actionName
						+ " 存在,但无权访问,跳转到Action.LOGIN");
				return Action.LOGIN;
			}

		}
	}

}
