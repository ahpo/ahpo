<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form id="pagerForm" method="post" action="#rel#">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="numPerPage" value="${page.numPerPage}" />
    <input type="hidden" name="orderField" value="${param.orderField}" />
    <input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
    <form rel="pagerForm" onsubmit="return navTabSearch(this);" action="sysUserQuery.action" method="post">
    <div class="searchBar">
        <ul class="searchContent">
            <li>
                <label>关键字：</label>
                <input type="text" name="keywords" value=""/>
            </li>
           
            <li>
                <select class="combox" name="did">
                     <option value="0">所有部门</option>
                     <s:iterator value="sysDepartments" id="opt">
                     <option value="<s:property value="#opt.did"/>"><s:property value="#opt.dname"/></option>
                     </s:iterator>
                </select>
            </li>
            <li>
	            <select class="combox" name="rid">
	                 <option value="0">所有用户</option>
	                 <s:iterator value="sysRoles" id="opt">
	                 <option value="<s:property value="#opt.rid"/>"><s:property value="#opt.rname"/></option>
	                 </s:iterator>
	            </select>
            </li>
        </ul>
        <div class="subBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
                <li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
            </ul>
        </div>
    </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="add" href="sysUserToCreate.action" target="navTab"><span>添加</span></a></li>
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="cids" postType="string" href="sysUserDelete.action" class="delete"><span>删除</span></a></li>
            <li><a class="edit" href="sysUserToUpdate.action?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
            <tr>
                
                <th width="22"><input type="checkbox" group="cids" class="checkboxCtrl"></th>
                <th><s:text name="jsp.sysUser.colUserName"/></th>
                <th><s:text name="jsp.sysUser.colTrueName"/></th>
                <th><s:text name="jsp.sysRole.colRName"/></th>
                <th><s:text name="jsp.sysDept.colDName"/></th>
                <th><s:text name="jsp.sysUser.colMobile"/></th>
                <!-- 
                <th><s:text name="jsp.sysUser.colTel"/></th>
                <th><s:text name="jsp.sysUser.colFax"/></th>
                
                <th><s:text name="jsp.sysUser.colEMail"/></th>
                <th><s:text name="jsp.sysUser.colAddress"/></th>
                 -->
                <th><s:text name="jsp.sysUser.colLastTime"/></th>
                <th><s:text name="jsp.sysUser.colLastIp"/></th>
                <th><s:text name="jsp.sysUser.colEnable"/></th>
                <th><s:text name="jsp.sysUser.colUpdated"/></th>
                <!-- 
                <th><s:text name="jsp.sysUser.colCreated"/></th>
                <th><s:text name="jsp.sysUser.colCreator"/></th>
                 -->
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="uid"/>">
                   <td><input name="cids" value="<s:property value="uid"/>" type="checkbox"></td>
                   <td><s:property value="username"/></td>
                   <td><s:property value="truename"/></td>
                   <td><s:property value="%{sysRole.rname}"/></td>
                   <td><s:property value="%{sysDepartment.dname}"/></td>
                   <td><s:property value="mobile"/></td>
                    <!-- 
                   <td><s:property value="tel"/></td>
                   <td><s:property value="fax"/></td>
                   <td><s:property value="email"/></td>
                   <td><s:property value="address"/></td>
                   -->
                   <td><s:date name="lastTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                   <td><s:property value="lastIp"/></td>
                   <td><s:property value="enable"/></td>
                   <td><s:date name="updated" format="yyyy-MM-dd HH:mm:ss" /></td>
                   <!-- 
                   <td><s:date name="created" format="yyyy-MM-dd HH:mm:ss" /></td>
                   <td><s:property value="creator"/></td>
                    -->
	            </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>