package com.pd.it.common.itf;

import java.util.List;

import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.PageFO;

public interface IDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>> {

	_Dao getDao();

	default _Dao getDao(String dimension) {
		return getDao();
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
