package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.PageVO;

/**
 * 通用数据接入对象接口
 * 
 * @author Administrator
 *
 * @param <_VO>
 * @param <_FO>
 * @param <_DTO>
 */
public interface IDao<_VO, _FO, _DTO> {
	int c(_VO vo);

	int cs(List<_VO> vo);

	_DTO r(_FO fo);

	String str(_FO fo);

	List<String> strs(_FO fo);

	int u(_VO vo);

	int us(List<_FO> vo);

	int ds(List<_FO> vo);

	List<_DTO> ra(_FO vo);

	List<_DTO> rs(PageFO fo);

	List<_DTO> rs(_FO fo, PageVO page);

}
