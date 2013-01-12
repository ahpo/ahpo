package com.pub.webapp.ui.pagination;

import java.util.HashMap;
import java.util.Map;

/**
 * ҳ�����
 * @author bing.peng
 *
 */
public class CopyOfPage {
	private int totalRows; //������
	private int pageSize = 10; //ÿҳ��ʾ������
	private int currentPage; //��ǰҳ��
	private int totalPages; //��ҳ��
	private int startRow; //��ǰҳ����ݿ��е���ʼ��
	private String url;	// Ҫ��ת��url
	private Map<String, String> parms = new HashMap<String,String>();	// ����

	public CopyOfPage() {
	}
	
	public CopyOfPage(int _totalRows) {
		totalRows = _totalRows;
		totalPages = (totalRows + pageSize -1)/pageSize;		
		currentPage = 1;
		startRow = 0;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
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
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void jump() {
		startRow = (currentPage - 1) * pageSize;
	}
	public void first(){
		currentPage = 1;
		startRow = 0;
	}
	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}
	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}
	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		jump();
		if (currentPage > totalPages && totalPages > 0) {
			last();
		} else if(currentPage > totalPages && totalPages == 0) { //处理没有数据时currentPage>0的情况
			currentPage = totalPages;
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
}
