package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.PageFO;

public interface ICommonDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>> {

	default _Dao getDao() {
		return Reflects.field(this, "dao");
	}

	default String queryStr(_FO fo) {
		return getDao().queryStr(fo);
	}

	default Object query(_FO fo) {
		return getDao().query(fo);
	}

	default Object queryPagedList(PageFO fo) {
		return getDao().queryPagedList(fo);
	}

	default Object queryList(_FO fo) {
		return getDao().queryList(fo);
	}

	default Object update(_VO vo) {
		return getDao().update(vo);
	}

	default Object updateList(List<_VO> list) {
		return getDao().updateList(list);
	}

	default Object deleteList(List<_VO> list) {
		return getDao().deleteList(list);
	}

	default Object batch(BatchVO<_FO> vo) {
		return 0;
	}
}
