/**   
 * @Title: TblLookupServiceImpl.java 
 * @Package com.easygo.service.impl.ejdb 
 * @author zgr  
 * @date 2012-9-11 上午10:17:49 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.pub.util.constant.Constants;
import com.sys.dao.TblLookupMapper;
import com.sys.service.TblLookupService;
import com.sys.vo.TblLookup;
import com.sys.vo.TblLookupExample;

/**
 * @ClassName: TblLookupServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-11 上午10:17:49
 * @version 1.0
 */
@Service("tblLookupService")
public class TblLookupServiceImpl extends ServiceImpl implements
		TblLookupService {
	@Resource
	private TblLookupMapper tblLookupMapper;

	public void setTblLookupMapper(TblLookupMapper tblLookupMapper) {
		this.tblLookupMapper = tblLookupMapper;
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.TblLookupService#selectByExample(com.sys.vo.TblLookupExample)
	 */
	@Override
	public List<TblLookup> selectByExample(TblLookupExample example) {
		logger.info("select from tbl_lookup by example...");
		return tblLookupMapper.selectByExample(example);
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.TblLookupService#countByExample(com.sys.vo.TblLookupExample)
	 */
	@Override
	public int countByExample(TblLookupExample example) {
		logger.info("select count from tbl_lookup by example...");
		return tblLookupMapper.countByExample(example);
	}

	/**
	 * @param id
	 * @return
	 * @see com.sys.service.TblLookupService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		logger.info("delete record from tbl_lookup by primarykey[" + id
				+ "]...");
		return tblLookupMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.TblLookupService#insertSelective(com.sys.vo.TblLookup)
	 */
	@Override
	public int insertSelective(TblLookup record) {
		logger.info("insert record into tbl_lookup...");
		return tblLookupMapper.insertSelective(record);
	}

	/**
	 * @param example
	 * @param offset
	 * @param pageSize
	 * @return
	 * @see com.sys.service.TblLookupService#selectPageByExample(com.sys.vo.TblLookupExample,
	 *      int, int)
	 */
	@Override
	public List<TblLookup> selectPageByExample(TblLookupExample example,
			int offset, int pageSize) {
		logger.info("select page info from tbl_lookup by example...");
		return tblLookupMapper.selectPageByExample(example, offset, pageSize);
	}

	/**
	 * @param id
	 * @return
	 * @see com.sys.service.TblLookupService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TblLookup selectByPrimaryKey(Integer id) {
		logger.info("select record from tbl_lookup by primarykey[" + id
				+ "]...");
		return tblLookupMapper.selectByPrimaryKey(id);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.TblLookupService#updateByPrimaryKey(com.sys.vo.TblLookup)
	 */
	@Override
	public int updateByPrimaryKey(TblLookup record) {
		logger.info("update record into tbl_lookup by primarykey["
				+ record.getId() + "]...");
		return tblLookupMapper.updateByPrimaryKey(record);
	}

	/**
	 * @param example
	 * @param id
	 * @param flag
	 * @return
	 * @see com.sys.service.TblLookupService#checkSimilarity(com.sys.vo.TblLookupExample,
	 *      java.lang.Integer, int)
	 */
	@Override
	public boolean checkSimilarity(TblLookupExample example, Integer id,
			int flag) {
		List<TblLookup> list = tblLookupMapper.selectByExample(example);
		if (list == null || list.size() < 1) {
			return true;
		}

		if (flag == Constants.CHECKSIMILARITY_MODE_UPDATE) { // update
			if (list.size() == 1 && list.get(0).getId().equals(id)) {
				return true;
			}
		}

		// other return false
		return false;
	}

}
