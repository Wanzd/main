package com.pd.it.system.lookup.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service("lookupTypeService")
public class LookupTypeService implements IDbService<VO, FO, VO, ILookupTypeDao> {

	@Autowired
	private ILookupTypeDao dao;

	@Override
	public ILookupTypeDao getDao() {
		return dao;
	}

}
