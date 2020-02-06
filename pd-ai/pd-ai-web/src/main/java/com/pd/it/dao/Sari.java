package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.ITruncateDao;
import com.pd.it.dao.api.IUpdateDao;

public class Sari {
	@Repository("Sari$ICityDao")
	public static interface ICityDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO>, ITruncateDao {
	}

	@Repository("Sari$IProvinceDao")
	public static interface IProvinceDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO>, ITruncateDao {
	}

	@Repository("Sari$IBaseDao")
	public static interface IBaseDao extends IQueryDao<MapVO, MapVO> {
	}

	@Repository("Sari$IViewDao")
	public static interface IViewDao extends IQueryDao<MapVO, MapVO>{
	}
}