<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysUserUpdate-div").toPanel({
			title:"修改系统用户"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#username").formValidator({onshow:"",onfocus:""})
				 .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"});
		$("#enable").val(<s:property value="%{sysUser.enable}"/>);
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">系统用户
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="sysUserUpdate-div">
	<s:form id="sysUserUpdate" name="sysUserUpdate" action="sysUserUpdate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1');">
		<input type="hidden" name="uid" value="<s:property value="%{sysUser.uid}"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td">用户ID</td>
				<td class="middle-td"><label><s:property value="%{sysUser.uid}"/></label></td>
				<td class="right-td"><div id="uidTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">用户名</td>
				<td class="middle-td">
					<input type="text" id="username" name="username" value="<s:property value="%{sysUser.username}"/>"/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="usernameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">真实姓名</td>
				<td class="middle-td">
					<input type="text" id="truename" name="truename" value="<s:property value="%{sysUser.truename}"/>"/>
				</td>
				<td class="right-td"><div id="truenameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">用户角色</td>
				<td class="middle-td">
					<select id="rid" name="rid">
					<s:iterator value="resultList" id="roles">
						<s:if test="#roles.rid==sysUser.sysRole.rid">
						<option selected value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
						</s:if>
						<s:else>
						<option value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
						</s:else>
					</s:iterator>
					</select>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="ridTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">所属部门</td>
				<td class="middle-td">
					<select id="did" name="did">
					<s:iterator value="deptList" id="dept">
						<s:if test="#dept.did == sysUser.sysDepartment.did">
						<option selected value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
						</s:if>
						<s:else>
						<option value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
						</s:else>
					</s:iterator>
					</select>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="didTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">手机号码</td>
				<td class="middle-td">
					<input type="text" id="mobile" name="mobile" value="<s:property value="%{sysUser.mobile}"/>"/>
				</td>
				<td class="right-td"><div id="mobileTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">电话</td>
				<td class="middle-td">
					<input type="text" id="tel" name="tel" value="<s:property value="%{sysUser.tel}"/>"/>
				</td>
				<td class="right-td"><div id="telTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">传真</td>
				<td class="middle-td">
					<input type="text" id="fax" name="fax" value="<s:property value="%{sysUser.fax}"/>"/>
				</td>
				<td class="right-td"><div id="faxTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">电子邮箱</td>
				<td class="middle-td">
					<input type="email" id="email" name="email" value="<s:property value="%{sysUser.email}"/>"/>
				</td>
				<td class="right-td"><div id="emailTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">通讯地址</td>
				<td class="middle-td">
					<input type="text" id="address" name="address" value="<s:property value="%{sysUser.address}"/>"/>
				</td>
				<td class="right-td"><div id="addressTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">启用标志</td>
				<td class="middle-td">
					<select id="enable" name="enable">
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="enableTip"></div></td>
			</tr>
		</table>
	
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.update"/>"/>
		<span></span>
		<input type="reset" name="submit2" 	class="button" value="<s:text name="jsp.common.reset"/>"/>
	</div>
	

	</s:form>
</div>