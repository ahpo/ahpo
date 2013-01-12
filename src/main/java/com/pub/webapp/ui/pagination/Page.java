package com.pub.webapp.ui.pagination;

import java.util.HashMap;
import java.util.Map;

/**
 * page
 * @author bing.peng
 *
 */
public class Page {
	private int totalRows; 
	private int numPerPage = 10; 
	private int pageNum; 
	private int totalPages; 
	private int startRow; 
	private String url;	
	//compatible with the previous version to use pageSize;
	@SuppressWarnings("unused")
	private int pageSize=numPerPage;
	private Map<String, String> parms = new HashMap<String,String>();	

	public Page() {
	}
	
	public Page(int _totalRows) {
		totalRows = _totalRows;
		totalPages = (totalRows + numPerPage -1)/numPerPage;		
		pageNum = 1;
		startRow = 0;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalRows() {
		return totalRows;
	}
	public void jump() {
		startRow = (pageNum - 1) * numPerPage;
	}
	public void first(){
		pageNum = 1;
		startRow = 0;
	}
	public void previous() {
		if (pageNum == 1) {
			return;
		}
		pageNum--;
		startRow = (pageNum - 1) * numPerPage;
	}
	public void next() {
		if (pageNum < totalPages) {
			pageNum++;
		}
		startRow = (pageNum - 1) * numPerPage;
	}
	public void last() {
		pageNum = totalPages;
		startRow = (pageNum - 1) * numPerPage;
	}
	public void refresh(int _currentPage) {
		pageNum = _currentPage;
		jump();
		if (pageNum > totalPages && totalPages > 0) {
			last();
		} else if(pageNum > totalPages && totalPages == 0) { //处理没有数据时currentPage>0的情况
			pageNum = totalPages;
			startRow = 0;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Map<String, String> getParms() {
		return parms;
	}

	public void setParms(Map<String, String> parms) {
		this.parms = parms;
	}

	/** 
	 * @return pageSize 
	 */
	public int getPageSize() {
		return numPerPage;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.numPerPage = pageSize;
	}
	
	
}
