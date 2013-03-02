<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${page.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="sysLogQuery.action" method="post">
    <div class="searchBar">
        <ul class="searchContent">
            <li>
                <label>字典名称：</label>
                <input type="text" name="keywords" value=""/>
            </li>
        </ul>
        <div class="subBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit"> 检 索 </button></div></div></li>
            </ul>
        </div>
    </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="demo_page4.html" target="navTab"><span>添加</span></a></li>
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>删除</span></a></li>
            <li><a class="edit" href="tblLookupToUpdate.action?id={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出</span></a></li>
        </ul>
    </div>
    <table class="table" width="1075" layoutH="138">
        <thead>
            <tr>
                <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
                <th><s:text name="jsp.tblLookup.colLookupName"/></th>
                <th><s:text name="jsp.tblLookup.colLookupKey"/></th>
                <th><s:text name="jsp.tblLookup.colLookupValue"/></th>
                <th><s:text name="jsp.tblLookup.colDescribeInfo"/></th>
                <th><s:text name="jsp.tblLookup.colUpdateTime"/></th>  
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="id"/>">
                   <td><input name="ids" value="xxx" type="checkbox"></td>
                   <td><s:property value="lookupName"/></td>
                   <td><s:property value="lookupKey"/></td>
                   <td><s:property value="lookupValue"/></td>
                   <td><s:property value="describeinfo"/></td>
                   <td><s:date name="updatetime" format="yyyy-MM-dd HH:mm:ss"/></td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>