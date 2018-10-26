package com.pd.it.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pd.it.common.vo.VO;
import com.pd.it.dao.module.economic.IEconomicConfigDao;
import com.pd.it.dao.module.economic.IEconomicDetailDao;
import com.pd.it.dao.module.economic.IEconomicMonthlyDao;

public class EconomicServiceSet {
	@Repository
	public static class EconomicDetailService {

		@Autowired
		private IEconomicDetailDao dao;

		public List<VO> rs() {
			return dao.rs(null);
		}

		public int us(List<VO> list) {
			return dao.us(list);
		}

		public int ds(List<VO> list) {
			return dao.ds(list);
		}
	}

	@Repository
	public static class EconomicConfigService {

		@Autowired
		private IEconomicConfigDao dao;

		public List<VO> rs() {
			return dao.rs(null);
		}

		public int us(List<VO> list) {
			return dao.us(list);
		}

		public int ds(List<VO> list) {
			return dao.ds(list);
		}
	}

	@Repository
	public static class EconomicMonthlyService {

		@Autowired
		private IEconomicMonthlyDao dao;

		public List<VO> rs() {
			return dao.rs(null);
		}

		public int us(List<VO> list) {
			return dao.us(list);
		}

		public int ds(List<VO> list) {
			return dao.ds(list);
		}
	}
}
