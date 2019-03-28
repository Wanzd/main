package com.pd.it.web.itf.service;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.VO;

public interface IQueryService {

	default Object ra(VO fo) {
		Object validRa = validRa(fo);
		return validRa != null ? validRa : executeRa(fo);
	};

	default Object rs(VO fo) {
		Object validRs = validRs(fo);
		return validRs != null ? validRs : executeRs(fo);
	};

	default Object validRa(VO vo) {
		return null;
	};

	default Object validRs(VO vo) {
		return null;
	};

	default Object executeRa(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.ra(vo);
	};

	default Object executeRs(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.ra(vo);
	};

	default Object r(VO fo) {
		Object validRs = validR(fo);
		return validRs != null ? validRs : executeR(fo);
	};

	default Object validR(VO vo) {
		return null;
	};

	default Object executeR(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.r(vo);
	};

	default Object page(PageFO fo) {
		Object validRs = validPage(fo);
		return validRs != null ? validRs : executePage(fo);
	};

	default Object validPage(PageFO vo) {
		return null;
	};

	default Object executePage(PageFO vo) {
		return new VO().p("MSG", "Not impl yet");
	};
}