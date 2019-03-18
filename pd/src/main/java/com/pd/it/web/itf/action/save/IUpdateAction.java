package com.pd.it.web.itf.action.save;

import com.pd.it.common.vo.VO;

public interface IUpdateAction {

	default Object update(VO fo) {
		Object validRs = validUpdate(fo);
		return validRs != null ? validRs : executeUpdate(fo);
	};

	default Object validUpdate(VO vo) {
		return null;
	};

	default Object executeUpdate(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
