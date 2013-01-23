<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${page.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" href="tblDictionaryToUpdate.action?id={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
            <tr>
                <th><s:text name="jsp.sysTask.col.id"/></th>
                <th><s:text name="jsp.sysTask.col.name"/></th>
                <th><s:text name="jsp.sysTask.col.class"/></th>
                <th><s:text name="jsp.sysTask.col.method"/></th>
                <th><s:text name="jsp.sysTask.col.cron"/></th>
                <th><s:text name="jsp.sysTask.col.desc"/></th>
                <th><s:text name="jsp.sysTask.col.updated"/></th>
                <th>OP</th>              
            </tr>
        </thead>
        <tbody>
            <s:if test="sysTasks!=null">
                <s:iterator value="sysTasks" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="id"/>">
                   <td><s:property value="taskId"/></td>
                   <td><s:property value="taskName"/></td>
                   <td><s:property value="taskClass"/></td>
                   <td><s:property value="taskMethod"/></td>
                   <td><s:property value="taskCron"/></td>
                   <td><s:property value="taskDesc"/></td>
                   <td><s:date name="updated" format="yyyy-MM-dd HH:mm:ss"/></td>
                   <td>
                   	<s:iterator value="funcList" id="func1">
                   		<s:if test="#func1.memo == 'update'">
                   		    <!-- <a title="编辑" target="navTab" href="demo_page4.html?id=xxx" class="btnEdit">编辑</a> -->
                   		    <a title="编辑" target="navTab" rel="#" href="tblDictionaryToUpdate.action?id=<s:property value="id"/>" class="btnEdit">编辑</a>
                   		</s:if>
                   	</s:iterator>
                   </td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
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
</div>