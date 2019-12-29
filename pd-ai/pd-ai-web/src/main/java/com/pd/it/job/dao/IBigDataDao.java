package com.pd.it.job.dao;

import org.springframework.stereotype.Repository;

import com.pd.it.dao.api.IQueryDao;

@Repository
public interface IBigDataDao<BigDataVO, BigDataFO, BigDataDTO> extends IQueryDao<BigDataFO, BigDataDTO> {
}