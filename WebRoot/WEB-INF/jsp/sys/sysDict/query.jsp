<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" href="sysDict_update.action?id={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
            <li class="line">line</li>
        </ul>
    </div>
    <table class="table" width="100%" layoutH="138">
        <thead>
            <tr>
                <th><s:text name="jsp.tblDictionary.colLookupKey"/></th>
                <th><s:text name="jsp.tblDictionary.colLookupValue"/></th>
                <th><s:text name="jsp.tblDictionary.colDescribeInfo"/></th>
                <th><s:text name="jsp.tblDictionary.colUpdateTime"/></th>
                <th><s:text name="jsp.tblDictionary.colBackup"/></th>  
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="id"/>">
                   <td><s:property value="lookupkey"/></td>
                   <td><s:property value="lookupvalue"/></td>
                   <td><s:property value="describeinfo"/></td>
                   <td><s:date name="updatetime" format="yyyy-MM-dd HH:mm:ss"/></td>
                   <td><s:property value="backup"/></td>
                </tr>
                </s:iterator>
            </s:if>
        </tbody>
    </table>
    <jsp:include page="/WEB-INF/jsp/pub/pages.jsp"></jsp:include>
</div>