package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IDimensionService {

	default Object query(VO fo) {
		Object validRs = validQuery(fo);
		return validRs != null ? validRs : executeQuery(fo);
	};

	Object validQuery(VO vo);

	Object executeQuery(VO vo);

	default Object update(VO vo) {
		Object updateRs = validUpdate(vo);
		return updateRs != null ? updateRs : executeUpdate(vo);
	};

	Object validUpdate(VO vo);

	Object executeUpdate(VO vo);
}
