package com.pd.it.system.chart.dao;

import com.pd.base.model.MapVO;
import com.pd.it.dao.api.IQueryComboDao;
import com.pd.it.dao.api.IQueryDao;
import com.pd.it.dao.api.IUpdateDao;

public interface ISystemChartDao extends IQueryDao<MapVO, MapVO>, IQueryComboDao,IUpdateDao<MapVO, MapVO> {
}