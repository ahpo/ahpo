<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysUserUpdatePwd-div").toPanel({
			title:"修改用户密码"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#oldpassword").formValidator({onshow:"",onfocus:""})
				 .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
			     .InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#password").formValidator({onshow:"",onfocus:""})
		 	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
		 	.RegexValidator({regexp:"^[0-9a-zA-Z]{6,}$",onerror:"密码格式不正确"})
	     	.InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#confirmpassword").formValidator({onshow:"",onfocus:""})
	    	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
	    	.CompareValidator({desID:"password",operateor:"=",onerror:"<s:text name='jsp.common.passwordConfirm.check'/>"})
	    	.RegexValidator({regexp:"^[0-9a-zA-Z]{6,}$",onerror:"密码格式不正确"})
	    	.InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
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

<div id="sysUserUpdatePwd-div">
	<s:form id="sysUserUpdatePwd" name="sysUserUpdatePwd" action="sysUserUpdatePwd" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1');">
		<input type="hidden" name="uid" value="<s:property value="uid"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.user.colUserName"/></td>
				<td class="middle-td">
					<label><s:property value="sysUser.username"/></label>
				</td>
				<td class="right-td"><div id="usernameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">旧密码</td>
				<td class="middle-td">
					<input type="password" id="oldpassword" name="oldpassword" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="oldpasswordTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.user.colPassword"/></td>
				<td class="middle-td">
					<input type="password" id="password" name="password" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="passwordTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.user.colConfirmPassword"/></td>
				<td class="middle-td">
					<input type="password" id="confirmpassword" name="confirmpassword" value=""/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="confirmpasswordTip"></div></td>
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