 <%@ page language="java" pageEncoding="UTF-8"%>
 	
 	<div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${page.totalRows}条，${page.totalPages}页</span>
        </div>
        
        <div class="pagination" targetType="navTab" totalCount="${page.totalRows}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.pageNum }"></div>

    </div>