package com.pd.it.app.ai.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;

@Repository("IViewDao")
public interface IViewDao extends IQueryDao<MapVO, MapVO>, IQueryComboDao {
}