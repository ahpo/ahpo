<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pub.util.config.Config"%>
<%@page import="com.pub.util.constant.Constants"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/css/index.css" />
    <script type="text/javascript" src="<%=basePath %>/js/jquery-1.6.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>/js/jquery-ui-1.8.16.custom.min.js"></script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><img src="<%=Config.params.getString("sys.logo", "images/vnie.png") %>"/></div>
		<div id="title"><%=Config.params.getString("sys.system", "后台管理系统") %></div>
		 
		<div id="menu">
			<div id="menu_container">
				<ul id="menu_items">
					<li class="menu_item on" style="border-radius:8px 0 0 8px" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='8px 0 0 8px'"><a>系统管理</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>用户管理</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>新闻管理</a></li>
					<!-- <li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>网盘管理</a></li>
					<li class="menu_item" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'"><a>相册管理</a></li> -->
					<li class="menu_item" style="border-radius:8px 0 0 8px;border:0px;" onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'" onmouseover="this.style.backgroundColor='#77D1F6';this.style.borderRadius='0 8px 8px 0';this.style.fontWeight='bold'"><a>邮件管理</a></li>
				
				</ul>
			</div>
		</div>
		
		<div id="user_info">
			<div id="welcome">欢迎 <%=(String)session.getAttribute(Constants.USER_NAME) %> 使用本系统</div>
			<div id="logout" onclick="javascript:window.location.href='logout.action';" onmouseout="this.style.color='#000';this.style.fontSize='14px'" onmouseover="this.style.color='#f00';this.style.fontSize='15px';this.style.cursor='pointer'">安全退出</div>
			<div id="updatepwd" onclick="javascript:window.frames.MainFrame.document.location.href='sysUserToUpdatePwd.action';" onmouseout="this.style.color='#000';this.style.fontSize='14px'" onmouseover="this.style.color='#f00';this.style.fontSize='15px';this.style.cursor='pointer'">修改密码</div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="<%=basePath %>admin/tree.jsp"></iframe>
        </div>
	<div id="main">
		<iframe id="MainFrame" name="MainFrame" src="<%=basePath %>admin/main.html"></iframe>
	</div>
	<div id="footer">Copyright © 2012-2012 All Rights Reserved Powered By <%=Config.params.getString("sys.company", "Ahpo") %></div>
</div>
<div id="overlay">
</div>
<div id="slide">
    <span id="slider"></span>
    <span id="text">滑动解除锁定</span>
</div>

</body>
<script type="text/javascript">
function screenAdapter(){
	document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
		document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
		document.getElementById('main').style.width=window.screen.width-230+"px";
}

window.onscroll=function(){screenAdapter()};
window.onresize=function(){screenAdapter()};
window.onload=function(){screenAdapter()};
$(function() {
    var slideWidth=$("#slide").width();
    $("#slider").draggable({
        axis: 'x',
        containment: 'parent',
        drag: function(event, ui) {
            if (ui.position.left > slideWidth*0.7) {
                $("#slide").fadeOut();
                $("#overlay").fadeOut();
            } else {
                // Apparently Safari isn't allowing partial opacity on text with background clip? Not sure.
                //$("#text").css("opacity", 100 - (ui.position.left / 5));
            }
        },
        stop: function(event, ui) {
            if (ui.position.left < slideWidth*0.7) {
                $(this).animate({left: 0});
            }
        }
    });     
});
</script>
</html>