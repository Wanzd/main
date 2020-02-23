package com.pd.it.system.chart.dao;

import org.springframework.stereotype.Repository;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;

@Repository("ISystemChartDao")
public interface ISystemChartDao extends IQueryDao<MapVO, MapVO>,IQueryComboDao {
}