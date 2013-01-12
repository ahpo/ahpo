<%@page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/pub/common.jsp" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#sysUserPrivilege-div").toPanel({
			title:"分配用户权限"
		});
		
		$("#menu-items").treeview({
    			unique: true,
    			collapsed: true 
    	});
		
		$("#work-list").striped();
	});
</script>
<script type="text/javascript">
	function checkDips(selectedId ){
		var totalLen = 2;
		var ids = selectedId.split("_");
		var currentLen = ids.length - 2;
		selectedId = ids[ids.length - 2];
		// contorl least node
		var isSelected = $("#Re_" + selectedId).get(0).checked;			
		var myChild = $("#li_" + selectedId + " ul li input" );
		$.each(myChild, function(i, n){
			n.checked = isSelected ? true : false;	
		});
		
		// contorl parent node
		while(currentLen > 1) {
			var parentId = ids[currentLen -1 ] ;
			var parentChild = $("#li_" + parentId + " ul li input" );
			var count = 0;
			$.each(parentChild, function(i, n){
				if(n.checked) count ++;			
			});
			$("#Re_" + parentId).get(0).checked = (count != parentChild.size()) ? false : true;
			currentLen --;
		 }
	}
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

<div id="sysUserPrivilege-div">
	<s:form id="sysUserPrivilege" name="sysUserPrivilege" action="sysUserPrivilege" method="post">
		<input type="hidden" name="uid" value="<s:property value="%{sysUser.uid}"/>"/>
		<input type="hidden" name="currentPage" value="<s:property value="currentPage"/>"/>
		<table id="work-list" width="100%" class="addTable">
			<tr>
				<td class="left-td">用户名</td>
				<td class="middle-td">
					<label><s:property value="%{sysUser.username}"/></label>
				</td>
				<td class="right-td"><div id="usernameTip"></div></td>
			</tr>
			<tr>
				<td class="left-td">资源功能</td>
				<td class="middle-td">
					<s:if test="userTreeNode!=null">
						<wd:tree value="${userTreeNode}" theme="check" />
					</s:if>
				</td>
				<td class="right-td"></td>
			</tr>
		</table>
	<div class="min-div"></div>
	
	<div class="button-div">
		<input type="submit" name="submit1"	class="button" value="<s:text name="jsp.common.submit"/>"/>
		<span></span>
		<input type="reset" name="submit2" 	class="button" value="<s:text name="jsp.common.reset"/>"/>
	</div>
	
	<div class="min-div"></div>
	</s:form>
</div>