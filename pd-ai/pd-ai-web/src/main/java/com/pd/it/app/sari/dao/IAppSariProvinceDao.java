package com.pd.it.app.sari.dao;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.ITruncateDao;
import com.pd.it.dao.api.IUpdateDao;

public interface IAppSariProvinceDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO>, ITruncateDao, IQueryComboDao {
}