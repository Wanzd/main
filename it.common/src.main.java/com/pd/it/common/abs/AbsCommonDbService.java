package com.pd.it.common.abs;

import java.util.List;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.BatchList;
import com.pd.it.common.vo.FO$page;

public abstract class AbsCommonDbService<_VO, _FO, _DTO, _Dao extends IDao<_VO, _FO, _DTO>>
		implements IDbService<_VO, _FO, _DTO, _Dao> {

	@Override
	public abstract _Dao getDao();

	@Override
	public _DTO r(_FO fo) {
		return getDao().r(fo);
	}

	@Override
	public List<_DTO> rs(FO$page<_FO> fo) {
		return getDao().rs(fo);
	}

	@Override
	public List<_DTO> ra(_FO fo) {
		return getDao().ra(fo);
	}

	@Override
	public int us(List<_FO> list) {
		return getDao().us(list);
	}

	@Override
	public int ds(List<_FO> list) {
		return getDao().ds(list);
	}

	@Override
	public String batch(BatchList<_FO> vo) {
		return null;
	}
}
