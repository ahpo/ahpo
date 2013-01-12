/**   
 * @Title: SysDepartmentService.java 
 * @Package com.sys.service 
 * @author zgr  
 * @date 2012-5-5 上午10:55:07 
 * @version V1.0   
 */
package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.SysDepartment;
import com.sys.vo.SysDepartmentExample;

/** 
 * @ClassName: SysDepartmentService 
 * @Description: 部门信息服务类 
 * @author zgr 
 * @date 2012-5-5 上午10:55:07 
 * @version 1.0 
 */
public interface SysDepartmentService extends Service {

	int countByExample(SysDepartmentExample example);

	int deleteByPrimaryKey(Integer did);

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

	int updateByPrimaryKey(SysDepartment record);
	
	/**
	 * 相似性记录检查
	 * 
	 * @param example
	 * @param did
	 *            sys_dept的id
	 * @param flag
	 *            表示符号 0:修改; 1:插入
	 * @return true:不存在相似的记录; false:存在相似记录
	 */
	public boolean checkSimilarity(SysDepartmentExample example, Integer did, int flag);
}
