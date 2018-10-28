package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.BatchList;

public interface IBatchService<_VO, _FO, _DTO> {

	String batch(BatchList<_FO> vo);

	int us(List<_FO> list);

	int ds(List<_FO> list);
}
