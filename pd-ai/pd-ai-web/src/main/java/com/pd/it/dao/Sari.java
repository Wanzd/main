package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IDropDao;
import com.pd.it.dao.api.IInitDao;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.ITruncateDao;
import com.pd.it.dao.api.IUpdateDao;

public class Sari {
	@Repository("Sari$ICityDao")
	public static interface ICityDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO>, ITruncateDao, IQueryComboDao {
	}

	@Repository("Sari$ICityResultDao")
	public static interface ICityResultDao extends IInitDao, IDropDao {
	}

	@Repository("Sari$IProvinceDao")
	public static interface IProvinceDao
			extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO>, ITruncateDao, IQueryComboDao {
	}

	@Repository("Sari$IQtyTypeDao")
	public static interface IQtyTypeDao extends IQueryComboDao {
	}

	@Repository("Sari$IBaseDao")
	public static interface IBaseDao extends IQueryDao<MapVO, MapVO> {
	}

	@Repository("Sari$IViewDao")
	public static interface IViewDao extends IQueryDao<MapVO, MapVO>, IQueryComboDao {
	}
}