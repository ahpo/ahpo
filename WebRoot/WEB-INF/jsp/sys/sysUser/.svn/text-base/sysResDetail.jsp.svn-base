<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
<!--
function del() {
    document.getElementById("frm").action='test';
    alert($("frm").action);
}
//-->
</script>

<div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
	<form id="frm" method="post" action="res_sysResUpdate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>资源编号：</label>
				<input name="sysResource.resid" type="text" size="30" value="${sysResource.resid }" readonly="readonly"/>
			</p>
			<p>
				<label>资源名称：</label>
				<input name="sysResource.resName" class="required" type="text" size="30" value="${sysResource.resName }"/>
			</p>
			<p>
				<label>资源地址：</label>
				<input name="sysResource.url" class="required" type="text" size="30" value="${sysResource.url }"/>	
			</p>
			<p>
				<label>优先级：</label>
				<input name="sysResource.prio" class="digits" type="text" size="30" value="${sysResource.prio }"/>
			</p>
			<p>
				<label>资源类型：</label>
				<input name="sysResource.rtype" class="digits" type="text" size="30" value="${sysResource.rtype }"/>
			</p>
			<p>
				<label>是否父节点：</label>
				<input name="sysResource.isParent" type="text" size="30" value="${sysResource.isParent }"/>
			</p>
			<p>
				<label>父节点编号：</label>
				<input name="sysResource.parentId" class="digits" type="text" size="30" value="${sysResource.parentId }"/>
			</p>
			<p>
				<label>资源层次：</label>
				<input name="sysResource.resLevel" class="digits" type="text" size="30" value="${sysResource.resLevel}"/>
			</p>
			<p>
				<label>资源编码：</label>
				<input name="sysResource.resCode" class="required" type="text" size="30" value="${sysResource.resCode }"/>
			</p>
			<p>
				<label>图片地址：</label>
				<input name="sysResource.imgUrl" type="text" size="30" value="${sysResource.imgUrl }"/>
			</p>
			<div class="unit">
				<label>备注：</label>
				<textarea name="sysResource.memo" class="editor" rows="10" cols="78" tools="mini">${sysResource.memo }</textarea>
			</div>
			
			<div class="divider"></div>
			
			 <div>
	            <ul class="rightTools">
	                <li>
	                   <div class="buttonActive"><div class="buttonContent"><button type="submit">更新</button></div></div>
	                </li>
	                <li>
	                   <a class="button" href="res_sysResDelete.action?rid=${sysResource.resid }" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a>
	                </li>
	            </ul>
	        </div>
		</div>
	</form>
</div>
