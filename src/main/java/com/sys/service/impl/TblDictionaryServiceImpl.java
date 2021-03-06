/**   
 * @Title: TblDictionaryServiceImpl.java 
 * @Package com.easygo.service.impl.ejdb 
 * @author zgr  
 * @date 2012-9-13 下午4:17:01 
 * @version V1.0   
 */
package com.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pub.service.impl.ServiceImpl;
import com.pub.util.constant.Constants;
import com.sys.dao.TblDictionaryMapper;
import com.sys.service.TblDictionaryService;
import com.sys.vo.TblDictionary;
import com.sys.vo.TblDictionaryExample;

/**
 * @ClassName: TblDictionaryServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zgr
 * @date 2012-9-13 下午4:17:01
 * @version 1.0
 */
@Service("tblDictionaryService")
public class TblDictionaryServiceImpl extends ServiceImpl implements
		TblDictionaryService {

	@Resource
	private TblDictionaryMapper tblDictionaryMapper;

	public void setTblDictionaryMapper(TblDictionaryMapper tblDictionaryMapper) {
		this.tblDictionaryMapper = tblDictionaryMapper;
	}

	/**
	 * @param example
	 * @return
	 * @see com.sys.service.TblDictionaryService#countByExample(com.sys.vo.TblDictionaryExample)
	 */
	@Override
	public int countByExample(TblDictionaryExample example) {
		logger.info("select count from tbldictionary by example...");
		return tblDictionaryMapper.countByExample(example);
	}

	/**
	 * @param id
	 * @return
	 * @see com.sys.service.TblDictionaryService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		logger.info("delete record from tbl_dictionary by primarykey[" + id
				+ "]...");
		return tblDictionaryMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.TblDictionaryService#insertSelective(com.sys.vo.TblDictionary)
	 */
	@Override
	public int insertSelective(TblDictionary record) {
		logger.info("insert record[(lookupkey:" + record.getLookupkey()
				+ "), (lookupvalue:" + record.getLookupvalue()
				+ ")] into tbl_dictionary...");
		return tblDictionaryMapper.insertSelective(record);
	}

	/**
	 * @param example
	 * @param offset
	 * @param pageSize
	 * @return
	 * @see com.sys.service.TblDictionaryService#selectPageByExample(com.sys.vo.TblDictionaryExample,
	 *      int, int)
	 */
	@Override
	public List<TblDictionary> selectPageByExample(
			TblDictionaryExample example, int offset, int pageSize) {
		logger.info("select page info from tbl_dictionary by exmaple...");
		return tblDictionaryMapper.selectPageByExample(example, offset,
				pageSize);
	}

	/**
	 * @param id
	 * @return
	 * @see com.sys.service.TblDictionaryService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public TblDictionary selectByPrimaryKey(Integer id) {
		logger.info("select record from tbl_dictionary by primarykey[" + "]...");
		return tblDictionaryMapper.selectByPrimaryKey(id);
	}

	/**
	 * @param record
	 * @return
	 * @see com.sys.service.TblDictionaryService#updateByPrimaryKey(com.sys.vo.TblDictionary)
	 */
	@Override
	public int updateByPrimaryKey(TblDictionary record) {
		logger.info("update record[(lookupkey:" + record.getLookupkey()
				+ "),(lookupvalue:" + record.getLookupvalue()
				+ ")} to tbl_dictionary by primarykey[" + record.getId()
				+ "]...");
		return tblDictionaryMapper.updateByPrimaryKey(record);
	}

	/**
	 * @param example
	 * @param id
	 * @param flag
	 * @return
	 * @see com.sys.service.TblDictionaryService#checkSimilarity(com.sys.vo.TblDictionaryExample,
	 *      java.lang.Integer, int)
	 */
	@Override
	public boolean checkSimilarity(TblDictionaryExample example, Integer id,
			int flag) {
		List<TblDictionary> list = tblDictionaryMapper.selectByExample(example);
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
