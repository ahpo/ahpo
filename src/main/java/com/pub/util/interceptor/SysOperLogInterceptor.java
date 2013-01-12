package com.pub.util.interceptor;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.sys.service.SysLogService;
import com.sys.vo.SysLog;

/**
 * <p>
 * <code>SystemLoggingInterceptor</code> 记录操作日志拦截器
 * </p>
 * 
 * @author <a href="mailto:qiang.pu@watchdata.com">JieTang</a>
 * @version
 * 
 */
@Component
@Scope("prototype")
public class SysOperLogInterceptor extends MethodFilterInterceptor {
	private final transient Log log = LogFactory.getLog(getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = 5044272316829986571L;

	@Resource
	private SysLogService sysLogService;

	public SysLogService getSysLogService() {
		return sysLogService;
	}

	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
	 */
	public void init() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
	 * .xwork2.ActionInvocation)
	 */
	@Override
	public String doIntercept(ActionInvocation actionInvocation)
			throws Exception {
		Object action = actionInvocation.getAction();

		log.debug(getClass() + " doIntercept for " + action.getClass());

		Integer userID = (Integer) actionInvocation.getInvocationContext()
				.getSession().get("uid");
		String loginIp = (String) actionInvocation.getInvocationContext()
				.getSession().get("loginIp");

		SysOperLogAnnotation annotation = getSysOperLogAnnotation(actionInvocation);
		if (annotation != null) {
			String value = annotation.value();
			if (value != null) {
				SysLog record = new SysLog();
				record.setUid(userID);
				record.setMemo(value);
				record.setLogDate(new Date());
				record.setUserIp(loginIp);
				sysLogService.insertSelective(record);
			}

			log.debug("userID=" + userID + ",value=" + value);
		}

		return actionInvocation.invoke();
	}

	/**
	 * 返回method的OperLoggingAnnotation，如果为null，则返回class的OperLoggingAnnotation
	 * 如果method和class都没有OperLoggingAnnotation，返回null
	 * 
	 * @param actionInvocation
	 * @return
	 */
	private SysOperLogAnnotation getSysOperLogAnnotation(
			ActionInvocation actionInvocation) {
		Class<?> clazz = actionInvocation.getAction().getClass();

		SysOperLogAnnotation classAnnotation = clazz
				.getAnnotation(SysOperLogAnnotation.class);

		String methodName = actionInvocation.getProxy().getMethod();
		/**
		 * Struts2 API说可能返回null，表明调用execute方法
		 * 源代码表明不会返回null，在没有指定方法名的时候返回"execute"
		 * 谨慎起见，遵循Struts2 API
		 */
		if(methodName == null)
			methodName="execute";
		SysOperLogAnnotation methodAnnotation = null;
		try {
			Method method = clazz.getMethod(methodName);
			methodAnnotation = method
					.getAnnotation(SysOperLogAnnotation.class);
		} catch (SecurityException unexpected) {
			log.warn(unexpected);
		} catch (NoSuchMethodException unexpected) {
			log.warn(unexpected);
		}

		if (methodAnnotation != null){
			log.debug("return methodAnnotation");
			return methodAnnotation;
		}
		else{
			log.debug("return classAnnotation");
			return classAnnotation;
		}
	}

}