<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/date/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#operLogQuery-div").toPanel({
			title:"查询操作日志"
		});
		
		$("#work-list").striped();
	});
</script>

<div id="toolbar" class="toolbar">
	<ul>
		<li>
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">用户管理
			<img src="<%=request.getContextPath()%>/images/arror.gif" width="7" height="11" border="0" alt="">日志管理
		</li>
	</ul>
</div>

<div class="min-div"></div>

<div id="operLogQuery-div">
	<s:form id="sysLogQuery" name="sysLogQuery" action="sysLogQuery" method="post">
		<table id="work-list" class="addTable">
			<tr>
				<td class="left-td">用户名</td>
				<td class="middle-td">
					<s:if test="resultList!=null">
						<select id="uid" name="uid">
							<option selected value="-1">全部</option>
							<s:iterator value="resultList" id="user">
								<option value="<s:property value="#user.uid"/>"><s:property value="#user.username"/></option>
							</s:iterator>
						</select>
					</s:if>
				</td>
				<td class="right-td"><div id="uidTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">起始时间</td>
				<td class="middle-td">
					<input name="beginTime" id="beginTime" class="Wdate" value="<s:property value="beginTime"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'true',maxDate:'#F{$dp.$D(\'endTime\')}'})" maxlength="19" style="width:200px"/>
				</td>
				<td class="right-td"><div id="beginTimeTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">终止时间</td>
				<td class="middle-td">
					<input name="endTime" id="endTime" class="Wdate" value="<s:property value="endTime"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:'true',minDate:'#F{$dp.$D(\'beginTime\')}'})" maxlength="19" style="width:200px"/>
				</td>
				<td class="right-td"><div id="endTimeTip"></div></td>
			</tr>
		</table>
	<div class="min-div"></div>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="查询"/>
	</div>
	
	<div class="min-div"></div>
	</s:form>
</div>