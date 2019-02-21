package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.BatchList;
import com.pd.it.common.vo.PageFO;

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

	default Object rs(PageFO fo) {
		return getDao().rs(fo);
	}

	default Object ra(_FO fo) {
		return getDao().ra(fo);
	}

	default Object u(_VO vo) {
		return getDao().u(vo);
	}

	default Object us(List<_VO> list) {
		return getDao().us(list);
	}

	default Object ds(List<_VO> list) {
		return getDao().ds(list);
	}

	default Object batch(BatchList<_FO> vo) {
		return 0;
	}
}
