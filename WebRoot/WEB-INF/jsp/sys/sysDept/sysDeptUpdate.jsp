<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <form method="post" action="sysDeptUpdate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>部门ID：</label>
                <input name="sysDept.did" type="text" size="30" value="${sysDept.did }" readonly="readonly"/>
            </p>
            <p>
                <label>部门名称：</label>
                <input name="sysDept.dname" class="required" type="text" size="30" value="${sysDept.dname }" alt=""/>
            </p>
            <p>
                <label>是否启用：</label>
                <input name="sysDept.enable" class="required" type="text" size="30" value="${enable }" alt=""/>
            </p>
            <p>
                <label>信息描述：</label>
                <input name="sysDept.memo" type="text" size="30" value="${sysDept.memo }" alt=""/>
            </p>
            <p>
                <label>上级部门：</label>
                <input name="sysDept.parentId" type="text" size="30" value="${sysDept.parentId }" alt=""/>
            </p>
            <p>
                <label>图像URL：</label>
                <input name="sysDept.imgUrl" type="text" size="30" value="${sysDept.imgUrl }" alt=""/>
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