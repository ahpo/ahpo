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
                <s:if test="resultList!=null">
                    <option selected value="-1">全部</option>
                    <s:iterator value="resultList" id="user">
                    <option value="<s:property value="#user.uid"/>"><s:property value="#user.username"/></option>
                    </s:iterator>
                </s:if>
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
            <li><a class="add" href="demo_page4.html" target="navTab"><span>添加</span></a></li>
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除默认方式</span></a></li>
            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a></li>
            <li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
            <li class="line">line</li>
            <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
        </ul>
    </div>
    <table class="table" width="1075" layoutH="138">
        <thead>
            <tr>
                <th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
                <th><s:text name="jsp.sysDept.colDName"/></th>
                <th><s:text name="jsp.sysDept.colEnable"/></th>
                <th><s:text name="jsp.sysDept.colMemo"/></th>
                <th><s:text name="jsp.sysDept.colParentId"/></th>
                <th><s:text name="jsp.sysDept.colImageUrl"/></th>  
                <th>操作</th>              
            </tr>
        </thead>
        <tbody>
            <s:if test="resultList!=null">
                <s:iterator value="resultList" status="rowstatus" var="t">
                <tr target="sid_user" rel="<s:property value="#rowstatus.index+1"/>">
                   <td><input name="ids" value="xxx" type="checkbox"></td>
                   <td><s:property value="dname"/></td>
                   <td><s:property value="enable"/></td>
                   <td><s:property value="memo"/></td>
                   <td><s:property value="parentId"/></td>
                   <td><s:property value="imgUrl"/></td>
                   <td>
                   	<s:iterator value="funcList" id="func1">
                   		<s:if test="#func1.memo == 'update'">
                   			<a title="编辑" target="navTab" href="javascript:updateObject('id', '<s:property value="id"/>', 'form1', 'tblLookupToUpdate')" class="btnEdit"><s:text name="jsp.common.update"/></a>
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