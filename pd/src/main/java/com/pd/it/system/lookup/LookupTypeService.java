package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IActionService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service
public class LookupTypeService implements IActionService {

	@Autowired
	private ILookupTypeDao dao;

	@Override
	public Object query(FO fo) {
		return dao.ra(fo);
	}

	@Override
	public Object update(VO vo) {
		return "LookupItem_update:test";
	}

}
