package com.pub.util.exception;

/**
 * 系统异常继承此类，不需显示捕捉，由框架统一处理
 *
 */
public class SystemException extends RuntimeException{
	
	private static final long serialVersionUID = -7617925338905953846L;
	
	/**   
	 * errCode:错误码
	 * @since Ver 1.1   
	 */   
	protected String code;
	
	/**   
	 * errParams:错误参数   
	 * @since Ver 1.1   
	 */   
	protected Object[] errParams;	
	
	
	/**   
	  
	 * getCode(取错误码)   
	 * @param   name   
	 * @param  @return    设定文件   
	 * @return String    错误码   
	 * @Exception 异常对象   
	 * @since  CodingExample　Ver(编码范例查看) 1.1   
	  
	*/
	public String getCode() {
		return code;
	}
	
	/**   
	  
	 * getErrParams(取错误参数)   
	 * @param   name   
	 * @param  @return    设定文件   
	 * @return Object[]    错误参数数组   
	 * @Exception 异常对象   
	 * @since  CodingExample　Ver(编码范例查看) 1.1   
	 * 	  
	*/
	public Object[] getErrParams() {
		return errParams;
	}

	public SystemException(String code) {
		super();
		this.code = code;
	}

	public SystemException(String code, Object[] errParams) {
		super();
		this.code = code;
		this.errParams = errParams;
	}

	public SystemException(String code, String message) {
		super(message);
		this.code = code;
	}

	public SystemException(String code, Object[] errParams, String message) {
		super(message);
		this.code = code;
		this.errParams = errParams;
	}
	
	public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public SystemException(String code, Object[] errParams, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.errParams = errParams;
	}
	
	public SystemException(String code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public SystemException(String code, Object[] errParams, Throwable cause) {
		super(cause);
		this.code = code;
		this.errParams = errParams;
	}
	
}
