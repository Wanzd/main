package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IActionService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service
public class LookupItemService implements IActionService {

	@Autowired
	private ILookupItemDao dao;

	@Override
	public Object query(FO vo) {
		return dao.ra(vo);
	}

	@Override
	public Object update(VO vo) {
		return dao.u(vo);
	}

}
