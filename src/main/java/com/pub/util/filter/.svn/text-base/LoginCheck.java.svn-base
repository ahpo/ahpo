/**   
 * @Title: LoginCheck.java 
 * @Package com.pub.filter 
 * @author xhh  
 * @date 2012-6-5 上午10:49:45 
 * @version V1.0   
 */
package com.pub.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enjoyor.util.logger.Logger;
import com.enjoyor.util.logger.LoggerFactory;
import com.pub.util.constant.Constants;

/**
 * @ClassName: LoginCheck
 * @Description: JPS拦截器
 * @author xhh
 * @date 2012-6-5 上午10:49:45
 * @version 1.0
 */
public class LoginCheck extends HttpServlet implements Filter {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginCheck.class);
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 8519661867479424868L;

	/**
	 * 拦截*.JSP
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			String contextPath = ((HttpServletRequest) request)
					.getContextPath();
			String requestURL = ((HttpServletRequest) request).getRequestURI();
			String realURL = requestURL.substring(contextPath.length(),
					requestURL.length());
			LOGGER.info(requestURL + " filter by LoginCheck");
			HttpSession session = ((HttpServletRequest) request).getSession();
			// 对指定的JSP进行拦截
			if (isFilterURL(realURL)) {
				if (session.getAttribute(Constants.USER_NAME) == null) {
					// 会话中无保存记录则跳转到登录页面
					if (isForwardToLoginJSP(realURL)) {
						((HttpServletResponse) response)
								.sendRedirect(contextPath + "/");
						return;
					}
				} else {
					if ("/".equals(realURL) || "/login.jsp".equals(realURL)) {
						// 返回登录页面,注销session
						session.invalidate();
					}
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * 是否跳转到/
	 * 
	 * @param realURL
	 * @return
	 */
	private boolean isForwardToLoginJSP(String realURL) {
		return !"/".equals(realURL);
	}

	/**
	 * 对能直接用URL访问的JSP进行拦截
	 * 
	 * @param realURL
	 * @return
	 */
	private boolean isFilterURL(String realURL) {
		boolean result = "/".equals(realURL) || "/login.jsp".equals(realURL)
				|| "/admin/index.jsp".equals(realURL)
				|| "/admin/tree.jsp".equals(realURL);
		return result;
	}

	/**
	 * @param arg0
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
