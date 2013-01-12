/**   
 * @Title: ContextListener.java 
 * @Package com.pub.listener 
 * @author xhh  
 * @date 2012-5-25 上午8:39:17 
 * @version V1.0   
 */
package com.pub.util.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pub.util.constant.CityConstants;
import com.pub.util.constant.Constants;

/**
 * @ClassName: ContextListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xhh
 * @date 2012-5-25 上午8:39:17
 * @version 1.0
 */
public class ContextListener implements ServletContextListener {

	/**
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * @param arg0
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		Constants.sc = sc;
		Constants.applicationContext = applicationContext;
		//加载city.xml信息
		CityConstants.initialCities();
	}

}
