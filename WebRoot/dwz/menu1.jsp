<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
basePath+="a/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title></title>
<link href="<%=basePath %>themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath %>themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<%=basePath %>themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="<%=basePath %>uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="<%=basePath %>themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<style type="text/css">
    #header{height:85px}
    #leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>

<script src="<%=basePath %>js/speedup.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="<%=basePath %>xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="<%=basePath %>uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="<%=basePath %>uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="<%=basePath %>chart/raphael.js"></script>
<script type="text/javascript" src="<%=basePath %>chart/g.raphael.js"></script>
<script type="text/javascript" src="<%=basePath %>chart/g.bar.js"></script>
<script type="text/javascript" src="<%=basePath %>chart/g.line.js"></script>
<script type="text/javascript" src="<%=basePath %>chart/g.pie.js"></script>
<script type="text/javascript" src="<%=basePath %>chart/g.dot.js"></script>

<script src="<%=basePath %>js/dwz.core.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.util.date.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.validate.method.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.barDrag.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.drag.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.tree.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.accordion.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.ui.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.theme.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.navTab.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.tab.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.resize.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.dialog.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.cssTable.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.stable.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.taskBar.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.ajax.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.pagination.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.database.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.datepicker.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.effects.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.panel.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.checkbox.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.history.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.combox.js" type="text/javascript"></script>
<script src="<%=basePath %>js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="<%=basePath %>js/dwz.regional.zh.js" type="text/javascript"></script>
</head>

<body scroll="no">

<div id="layout">
<h2 class="contentTitle">面板</h2>


<div class="pageContent sortDrag" selector="h1" layoutH="42">

    <div class="panel" defH="150">
        <h1>不可折叠面板1</h1>
        <div>
            <table class="list" width="98%">
                <thead>
                    <tr>
                        <th width="80">序号</th>
                        <th>姓名</th>
                        <th>性别</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>张三</td>
                        <td>男</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>李四</td>
                        <td>女</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>张三</td>
                        <td>男</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>李四</td>
                        <td>女</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>张三</td>
                        <td>男</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>李四</td>
                        <td>女</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    
    <div class="panel close collapse" defH="150">
        <h1>可折叠默认关闭面板</h1>
        <div>
            <p>内容</p>
            <p>内容</p>
            <p>内容</p>
        </div>
    </div>

    <div class="panel collapse" minH="100" defH="150">
        <h1>可折叠默认打开面板</h1>
        <div>
            <p>内容</p>
            <p>内容</p>
            <p>内容</p>
        </div>
    </div>

</div>
</div>
</body>
</html>