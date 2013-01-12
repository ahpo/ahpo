<%@page import="com.pub.util.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title><%=Config.params.getString("sys.company", "Ahpo") %>管理平台</title>

<link href="dwz/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="dwz/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="dwz/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="dwz/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<script src="dwz/js/speedup.js" type="text/javascript"></script>
<script src="dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="dwz/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="dwz/xheditor/xheditor-1.1.14-zh-cn.min.js" type="text/javascript"></script>
<script src="dwz/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="dwz/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="dwz/chart/raphael.js"></script>
<script type="text/javascript" src="dwz/chart/g.raphael.js"></script>
<script type="text/javascript" src="dwz/chart/g.bar.js"></script>
<script type="text/javascript" src="dwz/chart/g.line.js"></script>
<script type="text/javascript" src="dwz/chart/g.pie.js"></script>
<script type="text/javascript" src="dwz/chart/g.dot.js"></script>

<script src="dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="dwz/js/dwz.util.date.js" type="text/javascript"></script>
<script src="dwz/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="dwz/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.drag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tree.js" type="text/javascript"></script>
<script src="dwz/js/dwz.accordion.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ui.js" type="text/javascript"></script>
<script src="dwz/js/dwz.theme.js" type="text/javascript"></script>
<script src="dwz/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="dwz/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="dwz/js/dwz.navTab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.tab.js" type="text/javascript"></script>
<script src="dwz/js/dwz.resize.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialog.js" type="text/javascript"></script>
<script src="dwz/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="dwz/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.stable.js" type="text/javascript"></script>
<script src="dwz/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="dwz/js/dwz.ajax.js" type="text/javascript"></script>
<script src="dwz/js/dwz.pagination.js" type="text/javascript"></script>
<script src="dwz/js/dwz.database.js" type="text/javascript"></script>
<script src="dwz/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="dwz/js/dwz.effects.js" type="text/javascript"></script>
<script src="dwz/js/dwz.panel.js" type="text/javascript"></script>
<script src="dwz/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="dwz/js/dwz.history.js" type="text/javascript"></script>
<script src="dwz/js/dwz.combox.js" type="text/javascript"></script>
<script src="dwz/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
    DWZ.init("dwz/dwz.frag.xml", {
        loginUrl:"login_dialog.html", loginTitle:"登录",  // 弹出登录对话框
//      loginUrl:"login.html",  // 跳到登录页面
        statusCode:{ok:200, error:300, timeout:301}, //【可选】
        pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
        debug:false,    // 调试模式 【true|false】
        callback:function(){
            initEnv();
            $("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
        }
    });
});

</script>
</head>

<body scroll="no">
    <div id="layout">
        <div id="header">
            <div class="headerNav">
                <a class="logo" href="dwz/index.html" target="_blank">标志</a>
                <ul class="nav">
                    <li id="switchEnvBox"><a href="javascript:">（<span>杭州</span>）切换城市</a>
                        <ul>
                            <li><a href="sidebar_1.html">北京</a></li>
                            <li><a href="sidebar_2.html">上海</a></li>
                            <li><a href="sidebar_2.html">南京</a></li>
                            <li><a href="sidebar_2.html">深圳</a></li>
                            <li><a href="sidebar_2.html">广州</a></li>
                            <li><a href="sidebar_2.html">天津</a></li>
                            <li><a href="sidebar_2.html">杭州</a></li>
                        </ul>
                    </li>
                    <li><a href="admin/about.html" target="dialog" width="600">关于</a></li>
                    <li><a href="admin/changepwd.html" target="dialog" width="600">设置</a></li>
                    <li><a href="logout.action">退出</a></li>
                </ul>
                <ul class="themeList" id="themeList">
                	<li><marquee>fsdfsdfffffffffffffffddffffffffffffffffffffffffffffffffffffffffffffff</marquee></li>
                	<li></li>
                    <li theme="default"><div class="selected">蓝色</div></li>
                    <li theme="green"><div>绿色</div></li>
                    <!--<li theme="red"><div>红色</div></li>-->
                    <li theme="purple"><div>紫色</div></li>
                    <li theme="silver"><div>银色</div></li>
                    <li theme="azure"><div>天蓝</div></li>
                </ul>
            </div>

            <!-- navMenu -->
            
        </div>

        <div id="leftside">
            <div id="sidebar_s">
                <div class="collapse">
                    <div class="toggleCollapse"><div></div></div>
                </div>
            </div>
            <div id="sidebar">
                <div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

                <div class="accordion" fillSpace="sidebar">
                    <s:if test="#session.USER_MENU!=null">
                        <s:iterator value="#session.USER_MENU" status="rowstatus" var="t">
                            <div class="accordionHeader">
                                <h2><span>Folder</span><s:property value="sysResFuncRelation.sysResource.resName" /></h2>
                            </div>
                            <ul class="tree treeFolder">
                                <s:iterator value="child" status="rowstatus" var="tt">
                                    <li><a href="${sysResFuncRelation.sysResource.url }" target="navTab" rel="page${sysResFuncRelation.sysResource.resName }">${sysResFuncRelation.sysResource.resName }</a></li>
                                </s:iterator>
                            </ul>
                        </s:iterator>
                        
                    </s:if>
                
                    <div class="accordionHeader">
                        <h2><span>Folder</span>界面组件</h2>
                    </div>
                    <div class="accordionContent">
                        <ul class="tree treeFolder">
                            <li><a href="tabsPage.html" target="navTab">主框架面板</a>
                                <ul>
                                    <li><a href="main.html" target="navTab" rel="main">我的主页</a></li>
                                    <li><a href="http://www.baidu.com" target="navTab" rel="page1">页面一(外部页面)</a></li>
                                    <li><a href="demo_page2.html" target="navTab" rel="external" external="true">iframe navTab页面</a></li>
                                    <li><a href="demo_page1.html" target="navTab" rel="page1" fresh="false">替换页面一</a></li>
                                    <li><a href="demo_page2.html" target="navTab" rel="page2">页面二</a></li>
                                    <li><a href="demo_page4.html" target="navTab" rel="page3" title="页面三（自定义标签名）">页面三</a></li>
                                    <li><a href="demo_page4.html" target="navTab" rel="page4" fresh="false">测试页面（fresh="false"）</a></li>
                                    <li><a href="w_editor.html" target="navTab">表单提交会话超时</a></li>
                                    <li><a href="demo/common/ajaxTimeout.html" target="navTab">navTab会话超时</a></li>
                                    <li><a href="demo/common/ajaxTimeout.html" target="dialog">dialog会话超时</a></li>
                                    <li><a href="index_menu.html" target="_blank">横向导航条</a></li>
                                </ul>
                            </li>
                            
                            <li><a>常用组件</a>
                                <ul>
                                    <li><a href="w_panel.html" target="navTab" rel="w_panel">面板</a></li>
                                    <li><a href="w_tabs.html" target="navTab" rel="w_tabs">选项卡面板</a></li>
                                    <li><a href="w_dialog.html" target="navTab" rel="w_dialog">弹出窗口</a></li>
                                    <li><a href="w_alert.html" target="navTab" rel="w_alert">提示窗口</a></li>
                                    <li><a href="w_list.html" target="navTab" rel="w_list">CSS表格容器</a></li>
                                    <li><a href="demo_page1.html" target="navTab" rel="w_table">表格容器</a></li>
                                    <li><a href="w_removeSelected.html" target="navTab" rel="w_table">表格数据库排序+批量删除</a></li>
                                    <li><a href="w_tree.html" target="navTab" rel="w_tree">树形菜单</a></li>
                                    <li><a href="w_accordion.html" target="navTab" rel="w_accordion">滑动菜单</a></li>
                                    <li><a href="w_editor.html" target="navTab" rel="w_editor">编辑器</a></li>
                                    <li><a href="w_datepicker.html" target="navTab" rel="w_datepicker">日期控件</a></li>
                                    <li><a href="demo/database/db_widget.html" target="navTab" rel="db">suggest+lookup+主从结构</a></li>
                                    <li><a href="demo/database/treeBringBack.html" target="navTab" rel="db">tree查找带回</a></li>
                                    <li><a href="demo/sortDrag/1.html" target="navTab" rel="sortDrag">单个sortDrag示例</a></li>
                                    <li><a href="demo/sortDrag/2.html" target="navTab" rel="sortDrag">多个sortDrag示例</a></li>
                                </ul>
                            </li>
                                    
                            <li><a>表单组件</a>
                                <ul>
                                    <li><a href="w_validation.html" target="navTab" rel="w_validation">表单验证</a></li>
                                    <li><a href="w_button.html" target="navTab" rel="w_button">按钮</a></li>
                                    <li><a href="w_textInput.html" target="navTab" rel="w_textInput">文本框/文本域</a></li>
                                    <li><a href="w_combox.html" target="navTab" rel="w_combox">下拉菜单</a></li>
                                    <li><a href="w_checkbox.html" target="navTab" rel="w_checkbox">多选框/单选框</a></li>
                                    <li><a href="demo_upload.html" target="navTab" rel="demo_upload">iframeCallback表单提交</a></li>
                                    <li><a href="w_uploadify.html" target="navTab" rel="w_uploadify">uploadify多文件上传</a></li>
                                </ul>
                            </li>
                            <li><a>组合应用</a>
                                <ul>
                                    <li><a href="demo/pagination/layout1.html" target="navTab" rel="pagination1">局部刷新分页1</a></li>
                                    <li><a href="demo/pagination/layout2.html" target="navTab" rel="pagination2">局部刷新分页2</a></li>
                                </ul>
                            </li>
                            <li><a>图表</a>
                                <ul>
                                    <li><a href="chart/test/barchart.html" target="navTab" rel="chart">柱状图(垂直)</a></li>
                                    <li><a href="chart/test/hbarchart.html" target="navTab" rel="chart">柱状图(水平)</a></li>
                                    <li><a href="chart/test/linechart.html" target="navTab" rel="chart">折线图</a></li>
                                    <li><a href="chart/test/piechart.html" target="navTab" rel="chart">饼图</a></li>
                                </ul>
                            </li>
                            <li><a href="dwz.frag.xml" target="navTab" external="true">dwz.frag.xml</a></li>
                        </ul>
                    </div>
                    
                </div>
            </div>
        </div>
        <div id="container">
            <div id="navTab" class="tabsPage">
                <div class="tabsPageHeader">
                    <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                        <ul class="navTab-tab">
                            <li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
                        </ul>
                    </div>
                    <div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                    <div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                    <div class="tabsMore">more</div>
                </div>
                <ul class="tabsMoreList">
                    <li><a href="javascript:;">我的主页</a></li>
                </ul>
                <div class="navTab-panel tabsPageContent layoutBox">
                    <div class="page unitBox">
                        <div class="accountInfo">
                            <div class="alertInfo">
                                <h2><a href="#">使用手册(PDF)</a></h2>
                                <a href="#">演示视频(SWF)</a>
                            </div>
                            <p><span><%=Config.params.getString("sys.company", "Ahpo") %>管理平台</span></p>
                            <p>Done is better than perfect.</p>
                        </div>
                        <div class="pageFormContent" layoutH="80" style="margin-right:230px">
                            
                            <p style="color:red">Over thinking ruins you.</p>
                            <p style="color:red">Stay hungry, stay foolish.</p>

<div class="divider"></div>
<h2>在细节上展现魅力，不仅仅是在正常情况下，也要在不正常情况下……</h2>
<div class="divider"></div>
<p>1.每天读书</p><p>2.学习新的语言</p>
<p>3.打造你的灵感空间</p><p>4.战胜你的恐惧</p>
<p>5.升级技能</p><p>6.给未来的自己写一封信</p>
<p>7.承认自己的缺点</p><p>8.立即行动</p>
<p>9.向你佩服的人学习</p><p>10.减少在QQ上的时间</p>
<p>11.培养一个新的习惯</p><p>12.让过去的过去</p>
<p>13.帮助他人</p><p>14.好好休息。</p>

<div class="divider"></div>
                        </div>
                        
                        <div style="width:230px;position: absolute;top:60px;right:0" layoutH="80">
                        	<!-- 
                            <iframe width="100%" height="430" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?width=0&height=430&fansRow=2&ptype=1&skin=1&isTitle=0&noborder=1&isWeibo=1&isFans=0&uid=1739071261&verifier=c683dfe7"></iframe>
                            -->
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

    </div>

    <div id="footer"> Copyright &copy; 2012 <%=Config.params.getString("sys.company", "Ahpo") %> Inc. All Rights Reserved.</div>

</body>
</html>