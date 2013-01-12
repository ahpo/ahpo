<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblLookupUpdate-div").toPanel({
			title:"<s:text name="jsp.tblLookup.update" />"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#lookupName").formValidator({onshow:"",onfocus:""})
				.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
		        .InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#lookupKey").formValidator({onshow:"",onfocus:""})
		        .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
		        .InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#lookupValue").formValidator({onshow:"",onfocus:""})
				.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
				.InputValidator({max:200,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="200"/></s:text>"});
		$("#describeinfo").formValidator({onshow:"",onfocus:""})
				.InputValidator({max:200,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="200"/></s:text>"});
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt=""><s:text name="jsp.tblLookup.title" />
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="tblLookupUpdate-div">
	<s:form id="tblLookupUpdate" name="tblLookupUpdate" action="tblLookupUpdate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1')">
		<input type="hidden" name="id" value="<s:property value="tblLookup.id"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.tblLookup.colLookupName"/></td>
				<td class="middle-td">
					<input type="text" id="lookupName" name="lookupName" value="<s:property value="tblLookup.lookupName"/>"/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="lookupNameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblLookup.colLookupKey"/></td>
				<td class="middle-td">
					<input type="text" id="lookupKey" name="lookupKey" value="<s:property value="tblLookup.lookupKey"/>"/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="lookupKeyTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblLookup.colLookupValue"/></td>
				<td class="middle-td">
					<input type="text" id="lookupValue" name="lookupValue" value="<s:property value="tblLookup.lookupValue"/>"/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="lookupValueTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblLookup.colDescribeInfo"/></td>
				<td class="middle-td">
					<input type="text" id="describeinfo" name="describeinfo" value="<s:property value="tblLookup.describeinfo"/>"/>
				</td>
				<td class="right-td"><div id="describeinfoTip"></div></td>
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