package com.sys.dao;

import com.sys.vo.SysDepartment;
import com.sys.vo.SysDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysDepartmentMapper {
	int countByExample(SysDepartmentExample example);

	int deleteByExample(SysDepartmentExample example);

	int deleteByPrimaryKey(Integer did);

	int insert(SysDepartment record);

	int insertSelective(SysDepartment record);

	List<SysDepartment> selectByExample(SysDepartmentExample example);

	/**
	 * 获取分页数据信息
	 * @Description: 获取分页信息
	 * @author zgr  
	 * @date 2012-5-5 上午10:50:26
	 * @param example
	 * @param offset 行偏移
	 * @param pageSize 分页大小
	 * @return
	 */
	List<SysDepartment> selectPageByExample(
			@Param("example") SysDepartmentExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	SysDepartment selectByPrimaryKey(Integer did);

	int updateByExampleSelective(@Param("record") SysDepartment record,
			@Param("example") SysDepartmentExample example);

	int updateByExample(@Param("record") SysDepartment record,
			@Param("example") SysDepartmentExample example);

	int updateByPrimaryKeySelective(SysDepartment record);

	int updateByPrimaryKey(SysDepartment record);
}