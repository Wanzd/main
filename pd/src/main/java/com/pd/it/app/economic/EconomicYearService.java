package com.pd.it.app.economic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IQueryService;

@Service
public class EconomicYearService implements IQueryService {

	@Autowired
	private IEconomicYearDao dao;

	@Override
	public Object validQuery(VO vo) {
		return null;
	}

	@Override
	public Object executeQuery(VO vo) {
		return dao.ra(new FO(vo));
	}

}
