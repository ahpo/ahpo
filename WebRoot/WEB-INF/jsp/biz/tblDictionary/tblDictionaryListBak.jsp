<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblDictionaryMgr-div").toPanel({
			title:"<s:text name="jsp.tblDictionary.title" />"
		});
		
		$('.table').flexigrid({
			height:310
		});		
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">信息管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt=""><s:text name="jsp.tblDictionary.title" />
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="tblDictionaryMgr-div">
	<s:form id="form1" name="form1" action="tblDictionaryQuery" namespace="/" method="post">
	<input type="hidden" id="id" name="id" />
	<input type="hidden" name="currentPage" value="<s:property value="page.currentPage"/>"/>
	<table class="table">
		<thead>
			<tr>
				<th width="40"><s:text name="jsp.common.allCheck"/>&nbsp;<input type="checkbox" name="ids_all" onclick="checkedAll(this)" /></th>
				<th width="160"><s:text name="jsp.tblDictionary.colLookupKey"/></th>
				<th width="160"><s:text name="jsp.tblDictionary.colLookupValue"/></th>
				<th width="180"><s:text name="jsp.tblDictionary.colDescribeInfo"/></th>
				<th width="120"><s:text name="jsp.tblDictionary.colUpdateTime"/></th>
				<th width="120"><s:text name="jsp.tblDictionary.colBackup"/></th>
				<s:iterator value="funcList" id="func">
				<s:if test="#func.memo == 'update'">
				<th width="30"><s:text name="jsp.common.operation"/></th>
				</s:if></s:iterator>
			</tr>
		</thead>
		<tbody>
			<s:if test="resultList!=null">
				<s:iterator value="resultList" status="rowstatus" var="t">
					<tr>
						<td><input type="checkbox" name="ids" value="<s:property value="id"/>" onclick="checkedChild(this)"/></td>
						<td><s:property value="lookupkey"/></td>
						<td><s:property value="lookupvalue"/></td>
						<td><s:property value="describeinfo"/></td>
						<td><s:date name="updatetime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:property value="backup"/></td>
						<s:iterator value="funcList" id="func1">
						<s:if test="#func1.memo == 'update'">
						<td>
							<a href="#" onclick="updateObject('id', '<s:property value="id"/>', 'form1', 'tblDictionaryToUpdate')"><s:text name="jsp.common.update"/></a>
						</td>
						</s:if></s:iterator>
					</tr>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	</s:form>
	<div class="submit-div">
		<s:form id="form3" name="form3" method="post" action="tblDictionaryToCreate" namespace="/">
			<s:iterator value="funcList" id="func2">
			<s:if test="#func2.memo == 'delete'">
				<input type="button" name="delete" class="button" value="<s:text name="jsp.common.delete"/>" onclick="deleteObject('form1','tblDictionaryDelete')"/>
			</s:if></s:iterator>
			<s:iterator value="funcList" id="func3">
			<s:if test="#func3.memo == 'create'">
				<s:submit name="create" value="%{getText('jsp.common.create')}" cssClass="button"/>
			</s:if></s:iterator>
		</s:form>
	</div>
	<div class="pagination">
		<wd:page theme="watchdata" url="tblDictionaryQuery.action"/>
	</div>
	
</div>