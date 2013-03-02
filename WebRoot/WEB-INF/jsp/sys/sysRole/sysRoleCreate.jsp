<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <form method="post" action="sysRoleCreate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>角色名：</label>
                <input type="hidden" name="rid" value="<s:property value="%{sysRole.rid}"/>"/>
                <input name="rname" class="required" type="text" size="30" value="${sysRole.rname }" alt=""/>
            </p>
            <p>
                <label>是否启用：</label>
                <select class="combox" name="enable">
                    <option selected value="1">启用</option>
                    <option value="0">禁用</option>
                </select><font color="#FF0000">*</font>
            </p>
            <p>
                <label>图像URL：</label>
                <input name="imgUrl" type="text" size="30" value="${sysRole.imgUrl }" alt=""/>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>