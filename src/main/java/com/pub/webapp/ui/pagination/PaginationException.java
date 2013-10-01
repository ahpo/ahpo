package com.pub.webapp.ui.pagination;

/**
 * 分页异常
 * 因参数错误，不能正常完成分页时抛出异常
 * @author bing.peng
 *
 */
public class PaginationException extends RuntimeException {

	private static final long serialVersionUID = -7908794739431802712L;

	public PaginationException(String msg){
		super(msg);
	}
}
