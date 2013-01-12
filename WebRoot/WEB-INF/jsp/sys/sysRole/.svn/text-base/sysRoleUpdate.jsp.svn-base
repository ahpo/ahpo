<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysRoleUpdate-div").toPanel({
			title:"修改系统角色"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#rname").formValidator({onshow:"",onfocus:""})
				 .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"});
		$("#enable").val(<s:property value="%{sysRole.enable}"/>);
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">角色管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">系统角色
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="sysRoleUpdate-div">
	<s:form id="sysRoleUpdate" name="sysRoleUpdate" action="sysRoleUpdate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1');">
		<input type="hidden" name="rid" value="<s:property value="%{sysRole.rid}"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td">角色ID</td>
				<td class="middle-td"><label><s:property value="%{sysRole.rid}"/></label></td>
				<td class="right-td"><div id="ridTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">角色名</td>
				<td class="middle-td">
					<input type="text" id="rname" name="rname" value="<s:property value="%{sysRole.rname}"/>"/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="rnameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">是否启用</td>
				<td class="middle-td">
					<select id="enable" name="enable">
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="enableTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">图像URL</td>
				<td class="middle-td">
					<input type="text" id="imgUrl" name="imgUrl" value="<s:property value="%{sysRole.imgUrl}"/>"/>
				</td>
				<td class="right-td"><div id="imgUrlTip"></div></td>
			</tr>
		</table>
	<div class="min-div"></div>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.update"/>"/>
		<span></span>
		<input type="reset" name="submit2" 	class="button" value="<s:text name="jsp.common.reset"/>"/>
	</div>
	
	<div class="min-div"></div>
	</s:form>
</div>