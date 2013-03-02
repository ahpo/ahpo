<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="pageContent">
    <form method="post" action="sysUserUpdate.action" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>ID</label>
                <input name="uid" type="text" size="30" value="${sysUser.uid }" readonly="readonly"/>
            </p>
            <p>
                <label>用户名：</label>
                <input name="username" class="required" type="text" size="30" value="${sysUser.username }" alt=""/>
            </p>
            <p>
                <label>真实姓名：</label>
                <input name="truename" class="required" type="text" size="30" value="${sysUser.truename }" alt=""/>
            </p>
            <p>
                <label>用户角色：</label>
                <select id="rid" name="rid">
                 <s:iterator value="sysRoles" id="roles">
                     <s:if test="#roles.rid==sysUser.sysRole.rid">
                     <option selected value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
                     </s:if>
                     <s:else>
                     <option value="<s:property value="#roles.rid"/>"><s:property value="#roles.rname"/></option>
                     </s:else>
                 </s:iterator>
                 </select>
            </p>
            <p>
                <label>所属部门：</label>
                <select id="did" name="did">
                    <s:iterator value="sysDepartments" id="dept">
                        <s:if test="#dept.did == sysUser.sysDepartment.did">
                        <option selected value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
                        </s:if>
                        <s:else>
                        <option value="<s:property value="#dept.did"/>"><s:property value="#dept.dname"/></option>
                        </s:else>
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
            <p>
                <label>上次登录时间</label>
                <s:date name="sysUser.lastTime" format="yyyy-MM-dd HH:mm:ss" />
            </p>
            <p>
                <label>上次登录IP</label>
                ${sysUser.lastIp }
            </p>      
            <p>
                <label>更新时间</label>
                <s:date name="sysUser.updated" format="yyyy-MM-dd HH:mm:ss" />
            </p>      
            <p>
                <label>创建时间</label>
                <s:date name="sysUser.created" format="yyyy-MM-dd HH:mm:ss" />
            </p> 
            <p>
                <label>创建人</label>
                ${sysUser.creator }
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