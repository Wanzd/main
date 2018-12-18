package com.pd.it.module.economic.detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.VO;

@Service("economicDetailService")
public class EconomicDetailService implements IDbService<VO, VO, VO, IEconomicDetailDao> {

	@Autowired
	private IEconomicDetailDao dao;

	@Override
	public IEconomicDetailDao getDao() {
		return dao;
	}

}