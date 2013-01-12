<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysUserCreate-div").toPanel({
			title:"创建系统用户"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#username").formValidator({onshow:"",onfocus:""})
				 .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"});
		$("#password").formValidator({onshow:"",onfocus:""})
		 	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
	     	.InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#confirmpassword").formValidator({onshow:"",onfocus:""})
	    	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
	    	.InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"})
	    	.CompareValidator({desID:"password",operateor:"=",onerror:"<s:text name='jsp.common.passwordConfirm.check'/>"});
		$("#rid").formValidator({onshow:"",onfocus:""})
		 	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"});
		$("#did").formValidator({onshow:"",onfocus:""})
		 	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"});
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

<div id="sysUserCreate-div">
	<s:form id="sysUserCreate" name="sysUserCreate" action="sysUserCreate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1');">
		<input type="hidden" name="uid" value="<s:property value="uid"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td">用户名</td>
				<td class="middle-td">
					<input type="text" id="username" name="username" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="usernameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">真实姓名</td>
				<td class="middle-td">
					<input type="text" id="truename" name="truename" value=""/>
				</td>
				<td class="right-td"><div id="truenameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">密码</td>
				<td class="middle-td">
					<input type="password" id="password" name="password" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="passwordTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">确认密码</td>
				<td class="middle-td">
					<input type="password" id="confirmpassword" name="confirmpassword" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="confirmpasswordTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">用户角色</td>
				<td class="middle-td">
					<select id="rid" name="rid">
					<option value="">请选择</option>
					<s:iterator value="resultList" id="roles">
						<option value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
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
					<option value="">请选择</option>
					<s:iterator value="deptList" id="dept">
						<option value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
					</s:iterator>
					</select>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="didTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">手机号码</td>
				<td class="middle-td">
					<input type="text" id="mobile" name="mobile" value=""/>
				</td>
				<td class="right-td"><div id="mobileTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">电话</td>
				<td class="middle-td">
					<input type="text" id="tel" name="tel" value=""/>
				</td>
				<td class="right-td"><div id="telTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">传真</td>
				<td class="middle-td">
					<input type="text" id="fax" name="fax" value=""/>
				</td>
				<td class="right-td"><div id="faxTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">电子邮箱</td>
				<td class="middle-td">
					<input type="email" id="email" name="email" value=""/>
				</td>
				<td class="right-td"><div id="emailTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">通讯地址</td>
				<td class="middle-td">
					<input type="text" id="address" name="address" value=""/>
				</td>
				<td class="right-td"><div id="addressTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">启用标志</td>
				<td class="middle-td">
					<select id="enable" name="enable">
						<option selected value="1">启用</option>
						<option value="0">禁用</option>
					</select><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="enableTip"></div></td>
			</tr>
		</table>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.create"/>"/>
		<span></span>
		<input type="reset" name="submit2" 	class="button" value="<s:text name="jsp.common.reset"/>"/>
	</div>
	
	</s:form>
</div>