package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IDimensionService;

@Service
public class LookupTypeService implements IDimensionService {

	@Autowired
	private ILookupTypeDao dao;


	@Override
	public Object validQuery(VO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object executeQuery(VO vo) {
		return dao.ra(new FO(vo));
	}

	@Override
	public Object validUpdate(VO vo) {
		return null;
	}

	@Override
	public Object executeUpdate(VO vo) {
		return "LookupItem_update:test";
	}

}
