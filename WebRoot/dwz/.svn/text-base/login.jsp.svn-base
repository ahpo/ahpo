<%@page import="com.pub.util.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
basePath+="a/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><%=Config.params.getString("sys.company", "Ahpo") %>管理平台</title>
<link href="<%=basePath %>/themes/css/login.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
        if(top.location != self.location){
            top.location = self.location;
        }
        
        function changeValidateCode(obj) {
            var currentTime= new Date().getTime();
            obj.src = "rand.action?d=" + currentTime;
        }
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
    <div id="login">
        <div id="login_header">
            <h1 class="login_logo">
                <a href="http://www.vnie.net"><img src="<%=basePath %>themes/default/images/login_logo.gif" /></a>
            </h1>
            <div class="login_headerContent">
                <div class="navList">
                    <ul>
                        <li><a href="#">设为首页</a></li>
                        <li><a href="http://bbs.dwzjs.com">反馈</a></li>
                        <li><a href="doc/dwz-user-guide.pdf" target="_blank">帮助</a></li>
                    </ul>
                </div>
                <h2 class="login_title"><img src="<%=basePath %>themes/default/images/login_title.png" /></h2>
            </div>
        </div>
        <div id="login_content">
            <div class="loginForm">
                <s:form id="loginFrm" action="login" method="post" onsubmit="return checkRandCode();" namespace="/">
                    <p>
                        <label>用户名：</label>
                        <input type="text" name="username" size="20" class="login_input" value="zgr"/>
                        <!-- <s:property value="username"/> -->
                    </p>
                    <p>
                        <label>密码：</label>
                        <input type="password" name="password" size="20" class="login_input" value="111111"/>
                        <!-- <s:property value="password"/> -->
                    </p>
                    <p>
                        <label>验证码：</label>
                        <input name="checkCode" class="code" type="text" size="5" />
                        <span><img src="rand.action" alt="" width="75" height="24" onclick="changeValidateCode(this)"/></span>
                    </p>
                    <div class="login_bar">
                        <input class="sub" type="submit" value=" " />
                    </div>
                    <p>
                        <label style="color:red"><s:property value="errMsg"/><s:actionmessage/></label>
                    </p>
                </s:form>
            </div>
            <div class="login_banner"><img src="<%=basePath %>themes/default/images/login_banner.jpg" /></div>
            <div class="login_main">
                <ul class="helpList">
                    <li><a href="#">下载驱动程序</a></li>
                    <li><a href="#">如何安装密钥驱动程序？</a></li>
                    <li><a href="#">忘记密码怎么办？</a></li>
                    <li><a href="#">为什么登录失败？</a></li>
                </ul>
                <div class="login_inner">
                    <p>您可以使用 网易网盘 ，随时存，随地取</p>
                    <p>您还可以使用 闪电邮 在桌面随时提醒邮件到达，快速收发邮件。</p>
                    <p>在 百宝箱 里您可以查星座，订机票，看小说，学做菜…</p>
                </div>
            </div>
        </div>
        <div id="login_footer">
            Copyright &copy; 2012 <%=Config.params.getString("sys.company", "Ahpo") %> Inc. All Rights Reserved.
        </div>
    </div>
</body>
</html>