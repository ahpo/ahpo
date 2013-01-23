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
            <li><a class="add" href="sysDeptToCreate.action" target="navTab"><span>添加</span></a></li>
            <li><a class="edit" href="sysDeptToUpdate.action?did={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
            <tr>
                <th><s:text name="jsp.sysDept.colDName"/></th>
                <th><s:text name="jsp.sysDept.colEnable"/></th>
                <th><s:text name="jsp.sysDept.colMemo"/></th>
                <th><s:text name="jsp.sysDept.colParentId"/></th>
                <th><s:text name="jsp.sysDept.colImageUrl"/></th>  
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="#rowstatus.index+1"/>">
                   <td><s:property value="dname"/></td>
                   <td><s:property value="enable"/></td>
                   <td><s:property value="memo"/></td>
                   <td><s:property value="parentId"/></td>
                   <td><s:property value="imgUrl"/></td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>