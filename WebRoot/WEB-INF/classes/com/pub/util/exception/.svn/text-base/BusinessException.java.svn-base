package com.pub.util.exception;

/**
 * 
 * @ClassName: BusinessException
 * @Description: 业务异常基类，必须显示捕捉
 * @author ho274541
 * @date 2012-2-28 下午3:28:45
 * @version 1.0
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -7617925338905953846L;

	private String code;
	private Object[] errParams;
	public String getCode() {
		return code;
	}

	public Object[] getErrParams() {
		return errParams;
	}

	public BusinessException(String code) {
		super();
		this.code = code;
	}

	public BusinessException(String code, Object[] errParams) {
		super();
		this.code = code;
		this.errParams = errParams;
	}

	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(String code, Object[] errParams, String message) {
		super(message);
		this.code = code;
		this.errParams = errParams;
	}

	public BusinessException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public BusinessException(String code, Object[] errParams, String message,
			Throwable cause) {
		super(message, cause);
		this.code = code;
		this.errParams = errParams;
	}

	public BusinessException(String code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public BusinessException(String code, Object[] errParams, Throwable cause) {
		super(cause);
		this.code = code;
		this.errParams = errParams;
	}

}
