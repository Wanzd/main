package com.pd.it.dao;

import org.springframework.stereotype.Repository;

import com.pd.it.dao.api.IDropDao;
import com.pd.it.dao.api.IInitDao;

@Repository
public interface IAppSarsCityQtyDao extends IInitDao, IDropDao {
}