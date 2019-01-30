package com.pd.it.app.economic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IActionService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service
public class EconomicYearService implements IActionService {

	@Autowired
	private IEconomicYearDao dao;

	@Override
	public Object query(FO fo) {
		return dao.ra(fo);
	}

	@Override
	public Object update(VO vo) {
		return null;
	}

}
