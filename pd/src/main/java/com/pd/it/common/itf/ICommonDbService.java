package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.PageFO;

public interface ICommonDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>> {

	default _Dao getDao() {
		return Reflects.field(this, "dao");
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

	default Object batch(BatchVO<_FO> vo) {
		return 0;
	}
}
