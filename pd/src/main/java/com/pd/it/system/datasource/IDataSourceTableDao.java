package com.pd.it.system.datasource;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.vo.VO;

@Repository
public interface IDataSourceTableDao extends ISimpleDao<VO> {

}