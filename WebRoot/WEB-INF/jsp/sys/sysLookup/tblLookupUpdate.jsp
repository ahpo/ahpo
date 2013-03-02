<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <form method="post" action="tblDictionaryUpdate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>编号：</label>
                <input name="id" type="text" size="30" value="<s:property value="tblDictionary.id"/>" readonly="readonly"/>
            </p>
            <p>
                <label><s:text name="jsp.tblDictionary.colLookupKey"/>：</label>
                <input name="lookupkey" class="required" type="text" size="30" value="<s:property value="tblDictionary.lookupkey"/>" alt=""/>
            </p>
            <p>
                <label><s:text name="jsp.tblDictionary.colLookupValue"/>：</label>
                <input name="lookupvalue" class="required" type="text" size="30" value="<s:property value="tblDictionary.lookupvalue"/>" alt=""/>
            </p>
            <p>
                <label><s:text name="jsp.tblDictionary.colDescribeInfo"/>：</label>
                <input name="describeinfo" type="text" size="30" value="<s:property value="tblDictionary.describeinfo"/>" alt=""/>
            </p>
            <p>
                <label><s:text name="jsp.tblDictionary.colBackup"/>：</label>
                <input name="backup" type="text" size="30" value="<s:property value="tblDictionary.backup"/>" alt=""/>
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
