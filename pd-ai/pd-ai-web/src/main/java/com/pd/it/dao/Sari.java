package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.ITruncateDao;
import com.pd.it.dao.api.IUpdateDao;

public class Sari {
	@Repository("Sari$ICityDao")
	public static interface ICityDao
			extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO, MapVO>, ITruncateDao, IQueryComboDao {
	}

	@Repository("Sari$IProvinceDao")
	public static interface IProvinceDao
			extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO, MapVO>, ITruncateDao, IQueryComboDao {
	}

	@Repository("Sari$IQtyTypeDao")
	public static interface IQtyTypeDao extends IQueryComboDao {
	}

}