package com.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sys.vo.SysFunction;
import com.sys.vo.SysResFuncRelation;
import com.sys.vo.SysUser;
import com.sys.vo.SysUserExample;

@Repository
public interface SysUserMapper {
	int countByExample(SysUserExample example);

	int deleteByExample(SysUserExample example);

	int deleteByPrimaryKey(Integer uid);

	int insert(SysUser record);

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

	int updateByExampleSelective(@Param("record") SysUser record,
			@Param("example") SysUserExample example);

	int updateByExample(@Param("record") SysUser record,
			@Param("example") SysUserExample example);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);

	List<SysResFuncRelation> selectResFuncByUserId(Integer uid);

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
	List<Integer> selectURFIDByUidAndResCodeAndFunc(@Param("uid") Integer uid,
			@Param("resCode") String resCode, @Param("funcMemo") String funcMemo);
}