package com.pub.webapp.ui.pagination;

import java.util.Map;

/**
 * 分页操作句柄
 * @author bing.peng
 *
 */
public class PageHandle {
	
	/**
	 * 获取页面对象
	 * @param url 跳转的URL
	 * @param parms 跳转时需要携带的参数，如果没有则为null
	 * @param currentPage 当前
	 * @param pagerMethod 当前执行方法
	 * @param totalRows 总记录数
	 * @return
	 */
	public Page getPage(Map<String, String> parms, 
			String currentPage, String pageMethod,int totalRows) {
		
		//定义pager对象，用于传到页�?
		Page page = new Page(totalRows);
		
		page.setParms(parms);
		
		//	如果当前页号为空，表示为首次查询该页
		//	如果不为空，则刷新pager对象，输入当前页号等信息
		if (currentPage != null) {
			page.refresh(Integer.parseInt(currentPage));
		}
		
		//	获取当前执行的方法， 按指定页号，上一页，下一页�?
		if (pageMethod != null) {
			if (pageMethod.equals("jump")) {
				page.jump();
			} else if(pageMethod.equals("first")){
				page.first();
			}else if (pageMethod.equals("previous")) {
				page.previous();
			} else if (pageMethod.equals("next")) {
				page.next();
			} else if (pageMethod.equals("last")) {
				page.last();
			}
		}
		return page;
	}
}
