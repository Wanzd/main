package com.pd.it.app.job.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IUpdateDao;

@Repository
public interface IAppJobDao extends IUpdateDao<MapVO, MapVO> {
}