package com.pd.base.dao;

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
public interface IUpdate<_VO, _FO, _DTO> {
	int update(_VO vo);

	int updateList(@Param("list") List<_VO> list);

}
