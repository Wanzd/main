package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IUpdateDimensionService {

	default Object update(VO fo) {
		Object validRs = validUpdate(fo);
		return validRs != null ? validRs : executeUpdate(fo);
	};

	default Object validUpdate(VO vo) {
		return null;
	};

	Object executeUpdate(VO vo);

}
