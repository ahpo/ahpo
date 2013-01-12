package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysUser;
import com.sys.vo.SysUserExample;

public interface SysUserService extends Service {
	int countByExample(SysUserExample example);

	int deleteByPrimaryKey(Integer uid);

	int insertSelective(SysUser record);

	List<SysUser> selectByExample(SysUserExample example);

	/**
	 * 获取分页信息
	 * 
	 * @param example
	 * @param offset
	 *            行偏移
	 * @param pageSize
	 *            分页大小
	 * @return
	 */
	List<SysUser> selectPageByExample(@Param("example") SysUserExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	SysUser selectByPrimaryKey(Integer uid);

	int updateByPrimaryKey(SysUser record);

	List<SysResFuncRelation> selectResFuncByUserId(Integer uid);

	/**
	 * 相似性记录检查
	 * 
	 * @param example
	 * @param id
	 *            sys_user的id
	 * @param flag
	 *            表示符号 0:修改; 1:插入
	 * @return true:不存在相似的记录; false:存在相似记录
	 */
	boolean checkSimilarity(SysUserExample example, Integer uid, int flag);

	/**
	 * 
	 * @Description: 根据uid和resCode获取function（判断一个用户在某菜单下拥有的按钮级操作权限）
	 * @author zgr
	 * @date 2012-5-19 下午4:16:29
	 * @param uid
	 * @param resCode
	 * @return
	 */
	List<SysFunction> selectFuncByUidAndResCode(@Param("uid") Integer uid,
			@Param("resCode") String resCode);

	/**
	 * 
	 * @Description: 读取用户权限信息（判断某用户是否拥有某权限）
	 * @author zgr
	 * @date 2012-5-19 下午4:18:28
	 * @param uid
	 * @param resCode
	 * @param funcMemo
	 * @return
	 */
	boolean checkPrivilegeByUidAndResCodeAndFunc(@Param("uid") Integer uid,
			@Param("resCode") String resCode, @Param("funcMemo") String funcMemo);
}
