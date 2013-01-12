package com.pub.util.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.pub.util.constant.Constants;

/**
 * 
 * @ClassName: URLInterceptor
 * @Description: 虚拟路径需匹配NameSpace+ActionName
 * @author xhh
 * @date 2012-6-7 上午11:04:31
 * @version 1.0
 */
public class URLInterceptor implements Interceptor {

	private static final long serialVersionUID = 1062372584133396873L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(URLInterceptor.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**
	 * 对URL拦截匹配
	 * 
	 * @param invocation
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获取输入的URL,格式:(/...)以工程目录为根目录
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		String contextPath = ((HttpServletRequest) request).getContextPath();
		String requestUrl = ((HttpServletRequest) request).getRequestURI();
		int postion = requestUrl.indexOf(Constants.STRUTS_ACTION);
		String realUrl = requestUrl.substring(contextPath.length(), postion
				+ Constants.STRUTS_ACTION.length());
		// 获取struts2中配置的虚拟路径
		ActionProxy proxy = invocation.getProxy();
		StringBuffer virURL = new StringBuffer();
		if ("/".equals(proxy.getNamespace())) {
			virURL.append(proxy.getNamespace()).append(proxy.getActionName())
					.append(Constants.STRUTS_ACTION);
		} else {
			virURL.append(proxy.getNamespace()).append("/")
					.append(proxy.getActionName())
					.append(Constants.STRUTS_ACTION);
		}
		LOGGER.info(virURL.toString() + " intercept by URLInterceptor");
		// 匹配则跳过
		if (virURL.toString().equals(realUrl)) {
			return invocation.invoke();
		} else {
			return "invalid";
		}
	}
}
