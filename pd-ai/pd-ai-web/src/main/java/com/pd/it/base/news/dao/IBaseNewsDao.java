package com.pd.it.base.news.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.IUpdateDao;

@Repository
public interface IBaseNewsDao extends IQueryDao<MapVO, MapVO>, IUpdateDao<MapVO> {
}