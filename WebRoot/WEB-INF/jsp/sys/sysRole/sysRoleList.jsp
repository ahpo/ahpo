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
            <li><a class="add" href="sysRoleToCreate.action" target="navTab"><span>添加</span></a></li>
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="cids" postType="string" href="sysRoleDelete.action" class="delete"><span>删除</span></a></li>
            <li><a class="edit" href="sysRoleToUpdate.action?rid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
        </ul>
    </div>
    <table class="table" width="1075" layoutH="138">
        <thead>
            <tr>
                <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
                <th><s:text name="jsp.sysRole.colRName"/></th>
                <th><s:text name="jsp.sysRole.colEnable"/></th>
                <th><s:text name="jsp.sysRole.colParentId"/></th>
                <th><s:text name="jsp.sysRole.colImageUrl"/></th>
                <th><s:text name="jsp.sysRole.colCreated"/></th>  
                <th><s:text name="jsp.sysRole.colCreator"/></th>
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="rid"/>">
                   <td><input name="cids" value="<s:property value="rid"/>" type="checkbox"></td>
                   <td><s:property value="rname"/></td>
                   <td><s:property value="enable"/></td>
                   <td><s:property value="parentId"/></td>
                   <td><s:property value="imgUrl"/></td>
                   <td><s:date name="created" format="yyyy-MM-dd HH:mm:ss"/></td>
                   <td><s:property value="creator"/></td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>