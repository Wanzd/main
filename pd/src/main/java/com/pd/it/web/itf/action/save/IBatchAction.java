package com.pd.it.web.itf.action.save;

import com.pd.it.common.vo.VO;

public interface IBatchAction {

	default Object batch(VO fo) {
		Object validRs = validBatch(fo);
		return validRs != null ? validRs : executeBatch(fo);
	};

	default Object validBatch(VO vo) {
		return null;
	};

	default Object executeBatch(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
