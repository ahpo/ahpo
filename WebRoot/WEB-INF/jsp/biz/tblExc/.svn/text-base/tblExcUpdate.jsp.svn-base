<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblExcUpdate-div").toPanel({
			title:"<s:text name="jsp.tblExc.update" />"
		});
		
		$("#work-list").striped();
		
		$.formValidator.initConfig({onError:function(){return false;}});
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

<div id="tblExcUpdate-div">
	<s:form id="tblExcUpdate" name="tblExcUpdate" action="tblExcUpdate" namespace="/" method="post" onsubmit="return jQuery.formValidator.PageIsValid('1')">
		<input type="hidden" name="id" value="<s:property value="id"/>"/>
		<input type="hidden" id="projectNameQuery" name="projectNameQuery" value="<s:property value="projectNameQuery"/>" />
		<input type="hidden" id="excTypeQuery" name="excTypeQuery" value="<s:property value="excTypeQuery"/>" />
		<input type="hidden" id="excStatusQuery" name="excStatusQuery" value="<s:property value="excStatusQuery"/>" />
		<input type="hidden" id="beginTime" name="beginTime" value="<s:property value="beginTime"/>" />
		<input type="hidden" id="endTime" name="endTime" value="<s:property value="endTime"/>" />
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colId"/></td>
				<td class="middle-td"><label><s:property value="id"/></label></td>
				<td class="right-td"><div id="idTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colProject"/></td>
				<td class="middle-td">
					<input type="text" id="project" name="project" readonly value="<s:property value="project"/>"/>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="projectTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colMessage"/></td>
				<td class="middle-td">
					<textarea id="message" name="message" readonly><s:property value="message"/></textarea>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="messageTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colType"/></td>
				<td class="middle-td">
					<select id="type" name="type">
						<s:iterator value="typeList" id="type">
							<s:if test="#type.lookupValue == tblExc.type">
								<option value="<s:property value="#type.lookupValue"/>" selected><s:property value="#type.lookupKey"/></option>
							</s:if>
							<s:else>
								<option value="<s:property value="#type.lookupValue"/>"><s:property value="#type.lookupKey"/></option>
							</s:else>
						</s:iterator>
					</select>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="typeTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colStatus"/></td>
				<td class="middle-td">
					<select id="status" name="status">
						<s:iterator value="resultList" id="status">
							<s:if test="#status.lookupValue == tblExc.status">
								<option value="<s:property value="#status.lookupValue"/>" selected><s:property value="#status.lookupKey"/></option>
							</s:if>
							<s:else>
								<option value="<s:property value="#status.lookupValue"/>"><s:property value="#status.lookupKey"/></option>
							</s:else>
						</s:iterator>
					</select>
					<font color="#FF0000">*</font>
				</td>
				<td class="right-td"><div id="statusTip"></div></td>
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