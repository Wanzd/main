package com.pd.it.common.itf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IUpdateDao<_VO, _FO, _DTO> {
	int insert(_VO vo);

	int update(_VO vo);

	int insertList(@Param("list") List<_VO> list);

	int updateList(@Param("list") List<_VO> list);

	int deleteList(@Param("list") List<_VO> list);

	int truncate();

}
