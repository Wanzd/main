package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.FO$page;

public interface IDao<_VO, _FO, _DTO> {
	int c(_VO vo);

	int cs(List<_VO> vo);

	_DTO r(_FO fo);

	String str(_FO fo);

	List<String> strs(_FO fo);

	int us(List<_FO> vo);

	int ds(List<_FO> vo);

	List<_DTO> ra(_FO vo);

	List<_DTO> rs(FO$page fo);

}
