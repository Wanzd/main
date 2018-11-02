package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.VO;
import com.pd.it.common.vo.FO$page;

public interface IDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>>
		extends IService<VO>, IBatchService<_VO, _FO, _DTO> {
	_Dao getDao();

	_DTO r(_FO fo);

	List<_DTO> rs(FO$page<_FO> fo);

	List<_DTO> ra(_FO fo);

	int us(List<_FO> list);

	int ds(List<_FO> list);
}
