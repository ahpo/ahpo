<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysDeptUpdate-div").toPanel({
			title:"修改部门信息"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#dname").formValidator({onshow:"",onfocus:""})
			.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
		 	.InputValidator({max:100,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="100"/></s:text>"});
		$("#enable").val(<s:property value="%{sysDept.enable}"/>);
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">部门管理
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="sysDeptUpdate-div">
	<s:form id="sysDeptUpdate" name="sysDeptUpdate" action="sysDeptUpdate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1');">
		<input type="hidden" name="did" value="<s:property value="%{sysDept.did}"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td">部门ID</td>
				<td class="middle-td"><label><s:property value="%{sysDept.did}"/></label></td>
				<td class="right-td"><div id="didTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">部门名称</td>
				<td class="middle-td">
					<input type="text" id="dname" name="dname" value="<s:property value="%{sysDept.dname}"/>"/><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="dnameTip"></div></td>
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
				<td class="left-td">信息描述</td>
				<td class="middle-td">
					<input type="text" id="memo" name="memo" value="<s:property value="%{sysDept.memo}"/>"/>
				</td>
				<td class="right-td"><div id="memoTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">上级部门</td>
				<td class="middle-td">
					<select id="parentId" name="parentId">
						<option value="0">空</option>
					<s:iterator value="resultList" id="depts">
						<s:if test="#depts.did == sysDept.parentId">
						<option selected value="<s:property value="#depts.did"/>"><s:property value="#depts.dname"/></option>
						</s:if>
						<s:else>
						<option value="<s:property value="#depts.did"/>"><s:property value="#depts.dname"/></option>
						</s:else>
					</s:iterator>
					</select><font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="parentIdTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">图像URL</td>
				<td class="middle-td">
					<input type="text" id="imgUrl" name="imgUrl" value="<s:property value="%{sysDept.imgUrl}"/>" />
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