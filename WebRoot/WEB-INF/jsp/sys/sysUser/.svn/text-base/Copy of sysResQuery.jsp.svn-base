<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysUserMgr-div").toPanel({
			title:"<s:text name="jsp.sysUser.title"/>"
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
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">系统用户管理
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="sysUserMgr-div">
	<s:form id="form1" name="form1" action="sysUserQuery" namespace="/" method="post">
	<input type="hidden" id="uid" name="uid" />
	<input type="hidden" name="currentPage" value="<s:property value="page.currentPage"/>"/>
	<table class="table">
		<thead>
			<tr>
				<th width="40"><s:text name="jsp.common.allCheck"/>&nbsp;<input type="checkbox" name="ids_all" onclick="checkedAll(this)" /></th>
				<th width="60"><s:text name="jsp.sysUser.colUserName"/></th>
				<th width="60"><s:text name="jsp.sysUser.colTrueName"/></th>
				<th width="80"><s:text name="jsp.sysRole.colRName"/></th>
				<th width="80"><s:text name="jsp.sysDept.colDName"/></th>
				<th width="80"><s:text name="jsp.sysUser.colMobile"/></th>
				<th width="80"><s:text name="jsp.sysUser.colTel"/></th>
				<th width="80"><s:text name="jsp.sysUser.colFax"/></th>
				<th width="80"><s:text name="jsp.sysUser.colEMail"/></th>
				<th width="120"><s:text name="jsp.sysUser.colAddress"/></th>
				<th width="120"><s:text name="jsp.sysUser.colLastTime"/></th>
				<th width="80"><s:text name="jsp.sysUser.colLastIp"/></th>
				<th width="60"><s:text name="jsp.sysUser.colEnable"/></th>
				<th width="120"><s:text name="jsp.sysUser.colUpdated"/></th>
				<th width="120"><s:text name="jsp.sysUser.colCreated"/></th>
				<th width="80"><s:text name="jsp.sysUser.colCreator"/></th>
				<s:iterator value="funcList" id="func">
				<s:if test="#func.memo == 'update'">
				<th width="80"><s:text name="jsp.common.operation"/></th>
				</s:if></s:iterator>
			</tr>
		</thead>
		<tbody>
			<s:if test="resultList!=null">
				<s:iterator value="resultList" status="rowstatus" var="t">
					<tr>
						<td><input type="checkbox" name="ids" value="<s:property value="uid"/>" onclick="checkedChild(this)"/></td>
						<td><s:property value="username"/></td>
						<td><s:property value="truename"/></td>
						<td><s:property value="%{sysRole.rname}"/></td>
						<td><s:property value="%{sysDepartment.dname}"/></td>
						<td><s:property value="mobile"/></td>
						<td><s:property value="tel"/></td>
						<td><s:property value="fax"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="address"/></td>
						<td><s:date name="lastTime" format="yyyy-MM-dd HH:mm:ss" /></td>
						<td><s:property value="lastIp"/></td>
						<td><s:property value="enable"/></td>
						<td><s:date name="updated" format="yyyy-MM-dd HH:mm:ss" /></td>
						<td><s:date name="created" format="yyyy-MM-dd HH:mm:ss" /></td>
						<td><s:property value="creator"/></td>
						<s:url id="urlPrivilege" action="sysUserToPrivilege.action">
							<s:param name="uid" value="{uid}"></s:param>
							<s:param name="currentPage" value="{page.currentPage}"></s:param>
						</s:url>
						<s:iterator value="funcList" id="func1">
						<s:if test="#func1.memo == 'update'">
						<td>
							<a href="#" onclick="updateObject('uid', '<s:property value="uid"/>', 'form1', 'sysUserToUpdate')"><s:text name="jsp.common.update"/></a>
							&nbsp;&nbsp;
							<s:a href="%{urlPrivilege}"><s:text name="jsp.common.authority"/></s:a>
						</td>
						</s:if></s:iterator>
					</tr>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	</s:form>
	<div class="submit-div">
		<s:form id="form3" name="form3" method="post" action="sysUserToCreate" namespace="/">
			<s:iterator value="funcList" id="func2">
			<s:if test="#func2.memo == 'delete'">
			<input type="button" name="delete" class="button" value="<s:text name="jsp.common.delete"/>" onclick="deleteObject('form1','sysUserDelete')"/>
			</s:if></s:iterator>
			<s:iterator value="funcList" id="func3">
			<s:if test="#func3.memo == 'create'">
				<s:submit name="create" value="%{getText('jsp.common.create')}" cssClass="button"/>
			</s:if></s:iterator>
		</s:form>
	</div>
	<div class="pagination">
		<wd:page theme="watchdata" url="sysUserQuery.action"/>
	</div>
</div>