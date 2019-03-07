package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IQueryService {

	default Object query(VO fo) {
		Object validRs = validQuery(fo);
		return validRs != null ? validRs : executeQuery(fo);
	};

	default Object validQuery(VO vo) {
		return null;
	};

	default Object executeQuery(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
