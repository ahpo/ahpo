package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysRole;
import com.sys.vo.SysRoleExample;

@Repository
public interface SysRoleMapper {
	int countByExample(SysRoleExample example);

	int deleteByExample(SysRoleExample example);

	int deleteByPrimaryKey(Integer rid);

	int insert(SysRole record);

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

	int updateByExampleSelective(@Param("record") SysRole record,
			@Param("example") SysRoleExample example);

	int updateByExample(@Param("record") SysRole record,
			@Param("example") SysRoleExample example);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);

	List<SysResFuncRelation> selectResFuncByRoleId(Integer rid);

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
	 * @Description: 读取角色权限信息（判断某角色是否拥有某权限）
	 * @author zgr
	 * @date 2012-5-19 下午4:18:28
	 * @param rid
	 * @param resCode
	 * @param funcMemo
	 * @return
	 */
	List<Integer> selectRRFIDByRidAndResCodeAndFunc(@Param("rid") Integer rid,
			@Param("resCode") String resCode, @Param("funcMemo") String funcMemo);
}