package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysRole;
import com.sys.vo.SysRoleExample;

public interface SysRoleService extends Service {

	int countByExample(SysRoleExample example);

	int deleteByPrimaryKey(Integer rid);

	int insertSelective(SysRole record);

	List<SysRole> selectByExample(SysRoleExample example);

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
	List<SysRole> selectPageByExample(@Param("example") SysRoleExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	SysRole selectByPrimaryKey(Integer rid);

	int updateByPrimaryKey(SysRole record);

	List<SysResFuncRelation> selectResFuncByRoleId(Integer rid);

	/**
	 * 相似性记录检查
	 * 
	 * @param example
	 * @param rid
	 *            sys_role的id
	 * @param flag
	 *            表示符号 0:修改; 1:插入
	 * @return true:不存在相似的记录; false:存在相似记录
	 */
	public boolean checkSimilarity(SysRoleExample example, Integer rid, int flag);

	/**
	 * 
	 * @Description: 根据rid和resCode获取function（判断一个角色在某菜单下拥有的按钮级操作权限）
	 * @author zgr
	 * @date 2012-5-19 下午4:16:29
	 * @param rid
	 * @param resCode
	 * @return
	 */
	List<SysFunction> selectFuncByRidAndResCode(@Param("rid") Integer rid,
			@Param("resCode") String resCode);

	/**
	 * 
	 * @Description: 判断某角色是否拥有某权限
	 * @author zgr
	 * @date 2012-5-19 下午4:18:28
	 * @param rid
	 * @param resCode
	 * @param funcMemo
	 * @return
	 */
	boolean checkPrivilegeByRidAndResCodeAndFunc(@Param("rid") Integer rid,
			@Param("resCode") String resCode, @Param("funcMemo") String funcMemo);
}
