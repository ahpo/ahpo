<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#operLogShow-div").toPanel({
			title:"<s:text name="jsp.sysLog.title"/>"
		});
		
		$('.table').flexigrid({
			height:310
		});		
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">日志管理
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="operLogShow-div">
	<s:form id="form1" name="form1" method="post">
	<table class="table">
		<thead>
			<tr>
				<th width="150"><s:text name="jsp.sysUser.colUserName"/></th>
				<th width="150"><s:text name="jsp.sysLog.colUserIp"/></th>
				<th width="610"><s:text name="jsp.sysLog.colMemo"/></th>
				<th width="150"><s:text name="jsp.sysLog.colLogDate"/></th>
			</tr>
		</thead>
		<tbody>
			<s:if test="resultList!=null">
				<s:iterator value="resultList">
					<tr>
						<td><s:property value="sysUser.username"/></td>
						<td><s:property value="userIp"/></td>
						<td><s:property value="memo"/></td>
						<td><s:date name="logDate" format="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	</s:form>
	<div class="submit-div">
		<s:form id="form3" name="form3" action="sysLogToQuery" method="post">
			<input type="submit" name="back" class="button" value="<s:text name="jsp.common.back"/>"/>
		</s:form>
	</div>
	<div class="pagination">
		<wd:page theme="watchdata" url="sysLogQuery.action" />
	</div>
</div>