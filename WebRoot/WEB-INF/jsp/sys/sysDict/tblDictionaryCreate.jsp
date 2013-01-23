<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblDictionaryCreate-div").toPanel({
			title:"<s:text name="jsp.tblDictionary.create" />"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
		$("#lookupkey").formValidator({onshow:"",onfocus:""})
		        .InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
		        .InputValidator({max:50,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="50"/></s:text>"});
		$("#lookupvalue").formValidator({onshow:"",onfocus:""})
	        	.InputValidator({min:1,onerror:"<s:text name='jsp.common.validate.null'/>"})
	        	.InputValidator({max:200,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="200"/></s:text>"});
		$("#describeinfo").formValidator({onshow:"",onfocus:""})
        		.InputValidator({max:200,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="200"/></s:text>"});
		$("#backup").formValidator({onshow:"",onfocus:""})
    			.InputValidator({max:200,onerror:"<s:text name='jsp.common.validate.char.length'><s:param value="200"/></s:text>"});
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt=""><s:text name="jsp.tblDictionary.title" />
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="tblDictionaryCreate-div">
	<s:form id="tblDictionaryCreate" name="tblDictionaryCreate" action="tblDictionaryCreate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1')">
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.tblDictionary.colLookupKey"/></td>
				<td class="middle-td">
					<input type="text" id="lookupkey" name="lookupkey"/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="lookupkeyTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblDictionary.colLookupValue"/></td>
				<td class="middle-td">
					<input type="text" id="lookupvalue" name="lookupvalue" value=""/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="lookupvalueTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblDictionary.colDescribeInfo"/></td>
				<td class="middle-td">
					<textarea id="describeinfo" name="describeinfo"></textarea>
				</td>
				<td class="right-td"><div id="describeinfoTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblDictionary.colBackup"/></td>
				<td class="middle-td">
					<input type="text" id="backup" name="backup" value=""/>
				</td>
				<td class="right-td"><div id="backupTip"></div></td>
			</tr>
		</table>
	<div class="min-div"></div>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.create"/>"/>
		<span></span>
		<input type="reset" name="submit2" 	class="button" value="<s:text name="jsp.common.reset"/>"/>
	</div>
	
	<div class="min-div"></div>
	</s:form>
</div>