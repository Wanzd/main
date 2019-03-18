package com.pd.it.web.itf.action.save;

import com.pd.it.common.vo.VO;

public interface ICreateAction {

	default Object create(VO fo) {
		Object validRs = validCreate(fo);
		return validRs != null ? validRs : executeCreate(fo);
	};

	default Object validCreate(VO vo) {
		return null;
	};

	default Object executeCreate(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
