package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.IUpdateDao;

@Repository
public interface IAppSarsCityWeekDeathDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO, MapVO> {
}