package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IQueryDimensionService {

	default Object query(VO fo) {
		Object validRs = validQuery(fo);
		return validRs != null ? validRs : executeQuery(fo);
	};

	default Object validQuery(VO vo) {
		return null;
	};

	Object executeQuery(VO vo);

}
