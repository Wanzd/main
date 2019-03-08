package com.pd.it.web.itf;

import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.VO;

public interface IQueryService {

	default Object ra(VO fo) {
		Object validRs = validRa(fo);
		return validRs != null ? validRs : executeRa(fo);
	};

	default Object validRa(VO vo) {
		return null;
	};

	default Object executeRa(VO vo) {
		return new VO().p("MSG", "Not impl yet");
	};

	default Object r(VO fo) {
		Object validRs = validR(fo);
		return validRs != null ? validRs : executeR(fo);
	};

	default Object validR(VO vo) {
		return null;
	};

	default Object executeR(VO vo) {
		return new VO().p("MSG", "Not impl yet");
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
