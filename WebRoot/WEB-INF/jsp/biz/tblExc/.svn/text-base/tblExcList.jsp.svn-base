<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblExcMgr-div").toPanel({
			title:"<s:text name="jsp.tblExc.title" />"
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
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt=""><s:text name="jsp.tblExc.title"/>
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="tblExcMgr-div">
	<s:form id="form1" name="form1" action="tblExcQuery" namespace="/" method="post">
	<input type="hidden" id="id" name="id" />
	<input type="hidden" id="projectNameQuery" name="projectNameQuery" value="<s:property value="projectNameQuery"/>" />
	<input type="hidden" id="excTypeQuery" name="excTypeQuery" value="<s:property value="excTypeQuery"/>" />
	<input type="hidden" id="excStatusQuery" name="excStatusQuery" value="<s:property value="excStatusQuery"/>" />
	<input type="hidden" id="beginTime" name="beginTime" value="<s:property value="beginTime"/>" />
	<input type="hidden" id="endTime" name="endTime" value="<s:property value="endTime"/>" />
	<input type="hidden" name="currentPage" value="<s:property value="page.currentPage"/>"/>
	<table class="table">
		<thead>
			<tr>
				<th width="80"><s:text name="jsp.common.allCheck"/>&nbsp;<input type="checkbox" name="ids_all" onclick="checkedAll(this)" /></th>
				<th width="60"><s:text name="jsp.tblExc.colProject"/></th>
				<th width="80"><s:text name="jsp.tblExc.colMessage"/></th>
				<th width="150"><s:text name="jsp.tblExc.colType"/></th>
				<th width="120"><s:text name="jsp.tblExc.colStatus"/></th>
				<th width="120"><s:text name="jsp.tblExc.colOperate"/></th>
				<th width="120"><s:text name="jsp.tblExc.colTime"/></th>
				<s:iterator value="funcList" id="func2">
				<s:if test="#func2.memo == 'update'">
				<th width="100"><s:text name="jsp.common.operation"/></th>
				</s:if>
				</s:iterator>
			</tr>
		</thead>
		<tbody>
			<s:if test="resultList!=null">
				<s:iterator value="resultList" status="rowstatus" var="t">
					<tr>
						<td><input type="checkbox" name="ids" value="<s:property value="id"/>" onclick="checkedChild(this)"/></td>
						<td><s:property value="project"/></td>
						<td><s:property value="message"/></td>
						<td><s:property value="type"/></td>
						<td><s:property value="status"/></td>
						<td><s:property value="operate"/></td>
						<td><s:property value="time"/></td>
						<s:iterator value="funcList" id="func3">
						<s:if test="#func3.memo == 'update'">
						<td>
							<a href="#" onclick="updateObject('id', '<s:property value="id"/>', 'form1', 'tblExcToUpdate')"><s:text name="jsp.common.update"/></a>
						</td>
						</s:if></s:iterator>
					</tr>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	</s:form>
	<div class="submit-div">
		<s:form id="form3" name="form3" method="post">
		<s:if test="%{resultList.size > 0}">
			<s:iterator value="funcList" id="func">
			<s:if test="#func.memo == 'delete'">
				<input type="button" name="delete" class="button" value="<s:text name="jsp.common.delete"/>" onclick="deleteObject('form1','tblExcDelete')"/>
			</s:if>
			</s:iterator>
			</s:if>
		</s:form>
	</div>
	<div class="pagination">
		<wd:page theme="watchdata" url="tblExcQuery.action"/>
	</div>
</div>