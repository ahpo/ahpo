<%@page import="com.pub.util.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>后台管理系统</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.6.4.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/css/login.css" />
    <script type="text/javascript">
	    if(top.location != self.location){
			top.location = self.location;
		}
	    
	    function changeValidateCode(obj) {
	        var currentTime= new Date().getTime();
	        obj.src = "rand.action?d=" + currentTime;
	    }
</script>
<script type="text/javascript">
function checkRandCode() {
	var errMsg = document.getElementById("errMsg");
	errMsg.innerText = '';
	var json;
	$.ajax({
		type : 'post',
		async : false,
		url : "randCodeRequest.action",
		data: '',
		success : function(result) {
			json = $.parseJSON(result).randCode;
			//alert(json);
		},
		dataType : "text"
	});
	var checkcode = document.getElementById("checkCode").value;
	var imgRand = document.getElementById("imgRand");
	if( checkcode == json) {
		return true;
	}
	else {
		var currentTime= new Date().getTime();
	    imgRand.src = "rand.action?d=" + currentTime;
		errMsg.innerText = '验证码不正确';
		return false;
	}
}
</script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"></div>
		<div id="heading">
			<div id="title"><%=Config.params.getString("sys.system", "后台管理系统") %></div>
			<div id="subTitle"><%=Config.params.getString("sys.version", "1.0.0") %></div>
		</div>
	</div>
	<s:form action="login" method="post" onsubmit="return checkRandCode();" namespace="/">
	<div id="main">
		<div id="mainBg">
			<div id="mainPanel">
				<div id="left">
					<div id="image"></div>
				</div>
				<div id="right">
					<div id="welcome">
						<span id="welcome-text">管&nbsp;理&nbsp;登&nbsp;录</span>
					</div>
					<div id="user-name">
						<span class="item">用户名:</span>
						<span><input type="text" name="username" class="form-input" value="<s:property value="username"/>"></span>
					</div>
					<div id="user-password">
						<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
						<span class="input"><input type="password" name="password" class="form-input" value="<s:property value="password"/>"></span>
					</div>
					<div id="user-checkcode">
						<span class="item">验证码:</span>
						<span class="input"><input id="checkCode" type="text" name="checkCode" class="form-input-checkcode"></span>
						<span id="checkcode-span"><img id="imgRand" class="checkcode-img" src="rand.action" onclick="changeValidateCode(this)" /></span>
					</div>
					<div id="error-tip">
						<span id="tip-text"><label id="errMsg"><s:property value="errMsg"/></label><s:actionmessage/></span>
					</div>
					<div id="button-group">
						<input type="submit" class="btn" value="提交"/>
						<input type="reset" class="btn" value="重置"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	</s:form>
	<div id="footer">
		<div id="text">Copyright © 2011-2012 All Rights Reserved Powered By <%=Config.params.getString("sys.company", "Ahpo") %></div>
	</div>
</div>
</body>
</html>