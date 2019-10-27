package com.pd.base.dao;

import java.sql.SQLException;
import java.util.List;

import com.pd.base.model.PageFO;
import com.pd.base.model.PageVO;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IQuery<_VO, _FO, _DTO> {

	/**
	 * 查询单个对象
	 * 
	 * @param fo
	 * @return
	 */
	_DTO query(_FO fo);

	/**
	 * 查询单个字符串
	 * 
	 * @param fo
	 * @return
	 */
	String queryStr(_FO fo);

	List<String> queryStrList(_FO fo);

	List<_DTO> queryList(_FO vo) throws SQLException;

	List<_DTO> queryPagedList(PageFO fo);

	List<_DTO> queryPagedList(_FO fo, PageVO page);

}