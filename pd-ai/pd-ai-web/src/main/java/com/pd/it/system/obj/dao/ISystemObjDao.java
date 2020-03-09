package com.pd.it.system.obj.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryDao;

@Repository("ISystemObjDao")
public interface ISystemObjDao extends IQueryDao<MapVO, String> {
}