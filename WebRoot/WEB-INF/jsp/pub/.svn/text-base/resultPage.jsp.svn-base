<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#result-div").toPanel({
			title:"<s:text name="jsp.common.result" />"
		});
		
		$("#work-list").striped();
	});
</script>

<div id="toolbar" class="toolbar"></div>

<div class="min-div"></div>

<div id="result-div">
	<form id="form1" name="form1" action="<s:property value="operateResult.url" />" method="post">
		<s:if test="operateResult.parms!=null">
			<s:iterator value="operateResult.parms" id="t">
				<input type="hidden" name="<s:property value="#t.key"/>" value="<s:property value="#t.value"/>"/>
			</s:iterator>
		</s:if>
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td"><s:text name="jsp.common.result.operation" /></td>
				<td class="middle-td"><s:property value="%{getText(operateResult.operation)}"/></td>
				<td class="right-td"></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.common.result.result" /></td>
				<td class="middle-td"><s:property value="%{getText(operateResult.result)}"/></td>
				<td class="right-td"></td>
			</tr>
			<tr>
				<td class="left-td"><s:text name="jsp.common.result.reason" /></td>
				<td class="middle-td">
					<div><s:property value="%{getText(operateResult.reason)}"/></div>
					<s:if test="operateResult.deleteResult!=null">
						<s:iterator value="operateResult.deleteResult" id="t" status="rowstatus">	
							<div><p><s:property value="#t.value"/></p></div>
						</s:iterator>
					</s:if>
				</td>
				<td class="right-td"></td>	
			</tr>
		</table>
		
		<div class="min-div"></div>
	
		<div class="button-div">
			<input type="submit" name="back" class="button" value="<s:text name="jsp.common.back"/>"/>
		</div>
	
		<div class="min-div"></div>
	</form>
</div>

<div class="min-div"></div>


