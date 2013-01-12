<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#tblExcQuery-div").toPanel({
			title:"<s:text name="jsp.tblExc.query" />"
		});
		
		$("#work-list").striped();
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

<div id="tblExcQuery-div">
	<s:form id="form1" name="form1" action="tblExcQuery" method="post">
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colProject"/></td>
				<td class="middle-td"><input type="text" id="projectNameQuery" name="projectNameQuery"/></td>
				<td class="right-td"><div id="projectNameQueryTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colType"/></td>
				<td class="middle-td"><select id="excTypeQuery" name="excTypeQuery">
						<option value=""><s:text name="jsp.common.choose"/></option>
						<s:iterator value="typeList" id="type">
							<option value="<s:property value="#type.lookupValue"/>"><s:property value="#type.lookupKey"/></option>
						</s:iterator>
					</select>
				</td>
				<td class="right-td"><div id="excTypeQueryTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.tblExc.colStatus"/></td>
				<td class="middle-td"><select id="excStatusQuery" name="excStatusQuery">
						<option value=""><s:text name="jsp.common.choose"/></option>
						<s:iterator value="resultList" id="status">
							<option value="<s:property value="#status.lookupValue"/>"><s:property value="#status.lookupKey"/></option>
						</s:iterator>
					</select>
				</td>
				<td class="right-td"><div id="excStatusQueryTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.common.beginTime"/></td>
				<td class="middle-td">
					<input name="beginTime" id="beginTime" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'true',maxDate:'#F{$dp.$D(\'endTime\')}'})" maxlength="19" style="width:200px"/>
				</td>
				<td class="right-td"><div id="beginTimeTip"></div></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.common.endTime"/></td>
				<td class="middle-td">
					<input name="endTime" id="endTime" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'true',minDate:'#F{$dp.$D(\'beginTime\')}'})" maxlength="19" style="width:200px"/>
				</td>
				<td class="right-td"><div id="endTimeTip"></div></td>
			</tr>
		</table>
	<div class="min-div"></div>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.query"/>"/>
	</div>
	
	<div class="min-div"></div>
	</s:form>
</div>