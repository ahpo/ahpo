<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<style type="text/css">
    ul.rightTools {float:right; display:block;}
    ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div class="pageContent" style="padding:5px">
    <div class="tabs">
        <div class="tabsHeader">
            <div class="tabsHeaderContent">
                <ul>
                    <li><a href="javascript:;"><span>资源列表</span></a></li>
                    <li><a href="javascript:;"><span>资源详情</span></a></li>
                </ul>
            </div>
        </div>
        <div class="tabsContent">
            <div>
    
                <div layoutH="146" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
                    <ul class="tree treeFolder">
                    
	                    <s:if test="resultList!=null">
	                        <s:iterator value="resultList" status="rowstatus" var="t">
	                           <li><a href="javascript"><s:property value="sysResource.resName" /></a>
	                            <ul>
	                               <s:iterator value="child" status="rowstatus" var="tt">
	                               <li><a href="sysResDetail.action?rid=<s:property value="sysResource.resid" />" target="ajax" rel="jbsxBox"><s:property value="sysResource.resName" /></a></li>
	                                </s:iterator>
	                            </ul>
	                            </li>
	                        </s:iterator>
	                        
	                    </s:if>
                        
                        <!-- 
                        <li><a href="javascript">实验室检测</a>
                            <ul>
                                <li><a href="demo/pagination/list1.html" target="ajax" rel="jbsxBox">尿检</a></li>
                                <li><a href="demo/pagination/list1.html" target="ajax" rel="jbsxBox">HIV检测</a></li>
                                <li><a href="demo/pagination/list1.html" target="ajax" rel="jbsxBox">HCV检测</a></li>
                                <li><a href="demo/pagination/list1.html" target="ajax" rel="jbsxBox">TB检测</a></li>
                            </ul>
                        </li>
                         -->
                        
                     </ul>
                </div>
                
                <div id="jbsxBox" class="unitBox" style="margin-left:246px;">
                    <!--#include virtual="list1.html" -->
                </div>
    
            </div>
            
            <div>
                这里是资源详情
            </div>
        </div>
        <div class="tabsFooter">
            <div class="tabsFooterContent"></div>
        </div>
    </div>
    
</div>