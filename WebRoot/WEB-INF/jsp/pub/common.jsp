<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wd" uri="http://enjoyor.com/mepay"%>
<%@ page language="java" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<title><s:text name="jsp.common.webapp.name"/></title>
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="Pragma" content="no-cache" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.6.4.min.js"></script>
	<link href="<%=request.getContextPath()%>/css/default.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath()%>/scripts/upge-ui/styles/upge-ui.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/upge-ui/upge-ui.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/upge-ui/formValidatorRegex.js"></script>
	
	<script type="text/javascript">
		/*********列表全选checkbox***********/
		function checkedAll(obj)
		{
			var childName = obj.name.substring(0, obj.name.length-4);
			if(obj.checked == true){
				$("input[name="+childName+"]").each(function(){
					$(this).attr("checked",true);
				});
			}
			else{
				$("input[name="+childName+"]").each(function(){
					$(this).attr("checked",false);
				});
			}
		}
		
		function checkedChild(obj)
		{
			var parentName = obj.name + "_all";
			if(obj.checked == true){
				var isCheckAll = true;
				$("input[name="+obj.name+"]").each(function(){
					if($(this).attr("checked") == false){
						isCheckAll=false;
					}
				});
				if(isCheckAll){
					$("input[name=" + parentName + "]").attr("checked",true);
				}
			}
			else{
				$("input[name=" + parentName + "]").attr("checked",false);
			}
		}
	
		/********删除记录调用方法*************/
		function deleteObject(formId, formAction){
			var count = $("input[name='ids']:checked").length;
			if(count <= 0){
				$.modal({
					title:"<s:text name="jsp.common.delete.titleInfo"/>",
					type:'info',
					msg:"<s:text name="jsp.common.delete.msgBox"/>",
					onYes:function(){
						$.modal.close();
					}
				});
			}else{
				$.modal({
					title:"<s:text name="jsp.common.delete.titleInfo"/>",
					type:'info',
					msg:"<s:text name="jsp.common.delete.msgBox1"/>" + count + "<s:text name="jsp.common.delete.msgBox2"/>",
					onYes:function(){
						$("#" + formId).attr("action", formAction + ".action");
						$("#" + formId).submit();
					},
					onNo:function(){
						$.modal.close();
					}	
				});
			}
		}
		
		/**********更新记录调用方法***********/
		function updateObject(id, value, formId, formAction){
			$("#" + id).attr("value", value);
			$("#" + formId).attr("action", formAction + ".action");
			$("#" + formId).submit();
		}

	</script>
</head>
<body style="text-align:center;">
