package com.pub.util.interceptor;

import java.util.Map;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.pub.util.constant.Constants;

/**
 * 
 * @ClassName: LoginOutInterceptor
 * @Description: 登录登出拦截器
 * @author xhh
 * @date 2012-6-7 上午11:17:46
 * @version 1.0
 */
public class LoginOutInterceptor implements Interceptor {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginOutInterceptor.class);
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -6590068351296991402L;

	/**
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**
	 * @param invocation
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		String userName = (String) session.get(Constants.USER_NAME);
		// 获取struts2中配置的虚拟路径
		ActionProxy proxy = invocation.getProxy();
		StringBuffer virURL = new StringBuffer();
		if ("/".equals(proxy.getNamespace())) {
			virURL.append(proxy.getNamespace()).append(proxy.getActionName());
		} else {
			virURL.append(proxy.getNamespace()).append("/")
					.append(proxy.getActionName());
		}
		LOGGER.info(virURL.toString() + " intercept by LoginOutInterceptor");
		if ("/login".equals(virURL.toString())) {
			if (userName == null) {
				// 首次登陆,跳过
				return invocation.invoke();
			}
			// 已经登录状态,通过输入URL进入拦截器,直接返回登录后的首页
			return Action.SUCCESS;
		} else if ("/logout".equals(virURL)) {
			if (userName == null) {
				// 首次登陆
				return "logout";
			}
			return invocation.invoke();
		} else {
			return invocation.invoke();
		}
	}

}
