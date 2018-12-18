package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.BatchList;
import com.pd.it.common.vo.FO$page;

public interface IDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>> {

	_Dao getDao();

	default _Dao getDao(String dimension) {
		return getDao();
	}

	default String str(_FO fo) {
		return getDao().str(fo);
	}

	default Object r(_FO fo) {
		return getDao().r(fo);
	}

	default List<_DTO> rs(FO$page fo) {
		return getDao().rs(fo);
	}

	default List<_DTO> ra(_FO fo) {
		return getDao().ra(fo);
	}

	default int u(_VO vo) {
		return getDao().u(vo);
	}

	default int us(List<_FO> list) {
		return getDao().us(list);
	}

	default int ds(List<_FO> list) {
		return getDao().ds(list);
	}

	default int batch(BatchList<_FO> vo) {
		return 0;
	}
}
