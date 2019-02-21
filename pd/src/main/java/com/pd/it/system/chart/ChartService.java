package com.pd.it.system.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IQueryDimensionService;

@Service
public class ChartService implements IQueryDimensionService {

	@Autowired
	private IChartDao dao;

	@Override
	public Object validQuery(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeQuery(VO vo) {
		return dao.r(new FO(vo));
	}

}
