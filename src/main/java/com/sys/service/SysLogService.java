/**   
 * @Title: SysLogService.java 
 * @Package com.sys.service 
 * @author zgr  
 * @date 2012-5-9 下午3:40:19 
 * @version V1.0   
 */
package com.sys.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pub.service.Service;
import com.sys.vo.SysLog;
import com.sys.vo.SysLogExample;

/** 
 * @ClassName: SysLogService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author zgr 
 * @date 2012-5-9 下午3:40:19 
 * @version 1.0 
 */
public interface SysLogService extends Service {

	int countByExample(SysLogExample example);

    int deleteByPrimaryKey(Integer logid);

    int insertSelective(SysLog record);

    List<SysLog> selectByExample(SysLogExample example);

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
	List<SysLog> selectPageByExample(@Param("example") SysLogExample example,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

    SysLog selectByPrimaryKey(Integer logid);

    int updateByPrimaryKey(SysLog record);
}
