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
                <label>我的客户：</label>
                <input type="text" name="keywords" value=""/>
            </li>
            <li>
            <select class="combox" name="uid">
                <s:if test="sysUsers!=null">
                    <option selected value="-1">全部</option>
                    <s:iterator value="sysUsers" id="sysUser">
                    <option value="<s:property value="#sysUser.uid"/>"><s:property value="#sysUser.username"/></option>
                    </s:iterator>
                </s:if>
            </select>
            </li>
        </ul>
        <div class="subBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
            </ul>
        </div>
    </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="1075" layoutH="138">
        <thead>
            <tr>
                <th><s:text name="jsp.sysUser.colUserName"/></th>
                <th><s:text name="jsp.sysLog.colUserIp"/></th>
                <th><s:text name="jsp.sysLog.colMemo"/></th>
                <th><s:text name="jsp.sysLog.colLogDate"/></th>
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="#rowstatus.index+1"/>">
                   <td><s:property value="username"/></td>
                   <td><s:property value="userIp"/></td>
                   <td><s:property value="memo"/></td>
                   <td><s:date name="logDate" format="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>