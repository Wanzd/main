package com.pd.it.app.movie.dao;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.ITruncateDao;
import com.pd.it.dao.api.IUpdateDao;

public interface IAbbMovieDao
		extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO, MapVO>, ITruncateDao, IQueryComboDao {
}