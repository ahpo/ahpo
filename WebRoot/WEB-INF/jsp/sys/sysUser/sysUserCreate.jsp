<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <form method="post" action="sysUserCreate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>用户名：</label>
                <input name="username" class="required" type="text" size="30" value="${sysUser.username }" alt=""/>
            </p>
            <p>
                <label>真实姓名：</label>
                <input name="truename" class="required" type="text" size="30" value="${sysUser.truename }" alt=""/>
            </p>
            <p>
                <label>用户密码：</label>
                <input id="w_validation_pwd" name="password" class="required" type="password" size="30" value="" alt=""/>
            </p>
            <p>
                <label>重复密码：</label>
                <input name="confirmpassword" equalto="#w_validation_pwd" class="required" type="password" size="30" value="" alt=""/>
            </p>
            
            <p>
                <label>用户角色：</label>
                <select class="combox" name="rid">
                 <s:iterator value="sysRoles" id="roles">
                     <option value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
                 </s:iterator>
                 </select>
            </p>
            <p>
                <label>所属部门：</label>
                <select class="combox" name="did">
                    <s:iterator value="sysDepartments" id="dept">
                        <option value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
                    </s:iterator>
                </select>
            </p>
            
            <p>
                <label>手机号码：</label>
                <input name="mobile" type="text" size="30" value="${sysUser.mobile }" alt=""/>
            </p>
            <p>
                <label>电话：</label>
                <input name="tel" type="text" size="30" value="${sysUser.tel }" alt=""/>
            </p>
            <p>
                <label>传真：</label>
                <input name="fax" type="text" size="30" value="${sysUser.fax }" alt=""/>
            </p>
            <p>
                <label>电子邮箱：</label>
                <input name="email" type="text" size="30" value="${sysUser.email }" alt=""/>
            </p>
            <p>
                <label>通讯地址：</label>
                <input name="address" type="text" size="30" value="${sysUser.address }" alt=""/>
            </p>
            <p>
                <label>启用标志：</label>
                <select id="enable" name="enable">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                </select>
            </p>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>