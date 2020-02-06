package com.pd.ai.dao;

import org.springframework.stereotype.Repository;

import com.pd.ai.model.SystemMenuDTO;
import com.pd.ai.model.SystemMenuFO;
import com.pd.it.dao.api.IInitDao;
import com.pd.it.dao.api.IQueryDao;

@Repository
public interface ISystemMenuDao extends IQueryDao<SystemMenuFO, SystemMenuDTO>, IInitDao {
}