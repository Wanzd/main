package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IDimensionService extends IQueryDimensionService, IUpdateDimensionService {

	default Object query(VO fo) {
		Object validRs = validQuery(fo);
		return validRs != null ? validRs : executeQuery(fo);
	};

	default Object validQuery(VO vo) {
		return null;
	};


	default Object update(VO vo) {
		Object updateRs = validUpdate(vo);
		return updateRs != null ? updateRs : executeUpdate(vo);
	};

	Object validUpdate(VO vo);

	Object executeUpdate(VO vo);
}
