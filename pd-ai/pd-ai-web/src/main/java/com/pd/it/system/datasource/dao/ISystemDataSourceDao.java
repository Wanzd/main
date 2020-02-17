package com.pd.it.system.datasource.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;

@Repository("ISystemDataSourceDao")
public interface ISystemDataSourceDao extends IQueryComboDao, IQueryDao<MapVO, MapVO> {
}