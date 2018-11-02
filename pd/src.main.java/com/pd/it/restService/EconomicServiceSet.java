package com.pd.it.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.abs.AbsCommonDbService;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.module.economic.IEconomicConfigDao;
import com.pd.it.dao.module.economic.IEconomicDetailDao;
import com.pd.it.dao.module.economic.IEconomicMonthlyDao;

public class EconomicServiceSet {
	@Service("economicDetailService")
	public static class EconomicDetailService extends AbsCommonDbService<VO, VO, VO, IEconomicDetailDao> {

		@Autowired
		private IEconomicDetailDao dao;

		@Override
		public IEconomicDetailDao getDao() {
			return dao;
		}

	}

	@Service("economicConfigService")
	public static class EconomicConfigService extends AbsCommonDbService<VO, VO, VO, IEconomicConfigDao> {

		@Autowired
		private IEconomicConfigDao dao;

		@Override
		public IEconomicConfigDao getDao() {
			// TODO Auto-generated method stub
			return dao;
		}

	}

	@Service("economicMonthlyService")
	public static class EconomicMonthlyService extends AbsCommonDbService<VO, VO, VO, IEconomicMonthlyDao> {

		@Autowired
		private IEconomicMonthlyDao dao;

		@Override
		public IEconomicMonthlyDao getDao() {
			return dao;
		}

	}
}
