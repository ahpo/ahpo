<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>导航树</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<style type="text/css">@import url('<%=basePath %>components/dtree/dtree.css');</style>
	<script type="text/javascript">var dtreeIconBasePath = "<%=basePath %>components/dtree";</script>
	<script type="text/javascript" src="<%=basePath %>components/dtree/dtree.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.6.4.min.js"></script>
</head>
<body>
<input type="hidden" id="resources" name="resources" value="<%=(String)session.getAttribute("resources")%>"/>
<script type="text/javascript">
var treeMenu1 = [
	{ level:1, name:"用户管理"},
	{ level:2, name:"用户列表", ico:"../images/icon_default.gif",link:"userQuery.action"},
	{ level:2, name:"角色管理"},
	{ level:3, name:"角色列表", ico:"../images/icon_default.gif",link:"role_list.html"},
	{ level:3, name:"用户角色", ico:"../images/icon_default.gif",link:"ur_list.html"},
	{ level:1, name:"信息管理"},
	{ level:2, name:"路口配置管理", ico:"../images/icon_default.gif",link:"roadInfoQuery.action"},
	{ level:2, name:"视频信息管理", ico:"../images/icon_default.gif",link:"roadListQuery.action"},
	{ level:2, name:"图像信息管理", ico:"../images/icon_default.gif",link:"roadInfoListQuery.action"},
	{ level:2, name:"路况信息管理", ico:"../images/icon_default.gif",link:"roadReportQuery.action"},
	{ level:2, name:"违章信息管理", ico:"../images/icon_default.gif",link:"carIllegalInfoQuery.action"},
	{ level:2, name:"城市信息管理", ico:"../images/icon_default.gif",link:"cityQuery.action"},
	{ level:2, name:"经纬度管理", ico:"../images/icon_default.gif",link:"roadPositionQuery.action"},
	{ level:2, name:"软件更新管理", ico:"../images/icon_default.gif",link:"softVersionQuery.action"},
	{ level:2, name:"新闻管理", ico:"../images/icon_default.gif",link:"news_list.html"},
	{ level:2, name:"公告管理", ico:"../images/icon_default.gif",link:"bulletin_list.html"},
	{ level:1, name:"系统邮件", ico:"../images/icon_default.gif"},
	{ level:1, name:"网络文件", ico:"../images/icon_default.gif",link:"complaint_list.html"}
];
var treeMenu = eval('('+$("#resources").val()+')');
</script>
<style>
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#menuControll{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0 10px;
	font-size:14px;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
</style>
<div id="menuControll">
菜单控制:【<a href="#" onclick="tree.openAll();this.blur();return false;" style="color:#333333;text-decoration:none">展开</a>】
【<a href="#" onclick="tree.closeAll();this.blur();return false;" style="color:#333333;text-decoration:none">折叠</a>】
</div>
<div class="dtree" style="margin:10px;">
<script type="text/javascript"> 
//建立新树
tree = new dTree('tree');
tree.config.target = "MainFrame";
tree.config.useCookies = false;
var selNum = -1;
var link = "";
//根目录
tree.add(0,-1,'管理中心', null, null, null, '', '');
var count = 0;
var pLevelIdArray = new Array();
pLevelIdArray[1] = 0;
var currLevel = 1;
for (var i=0; i<treeMenu.length; i++) {
	var item = treeMenu[i];
	var itemLevel = item.level;
	pLevelIdArray[itemLevel+1] = ++count;
	if (item.link!=null && item.link!="") {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name, item.link);
		}
	} else {
		if (item.ico!=null) {
			tree.add(count, pLevelIdArray[itemLevel], item.name, null, null, null, item.ico, item.ico);
		} else {
			tree.add(count, pLevelIdArray[itemLevel], item.name);
		}
	}
	if (item.select) {
		selNum = count;
		link = item.link;
	}
}

//document.write(elements[0].username);

document.write(tree);
tree.openAll();
if (selNum != -1) {
	tree.openTo(selNum,true);
	top.document.frames["MainFrame"].location.href=link;
}
</script>
</div>
</body>
</html>