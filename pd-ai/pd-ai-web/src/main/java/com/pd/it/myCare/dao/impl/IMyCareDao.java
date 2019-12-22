package com.pd.it.myCare.dao.impl;

import org.springframework.stereotype.Repository;

import com.pd.it.dao.api.IDao;

@Repository
public interface IMyCareDao<MapVO> extends IDao<MapVO, MapVO, MapVO> {
}