package com.pd.it.web.itf.action.save;

import com.pd.it.common.vo.VO;

public interface IDeleteAction{

	default Object delete(VO fo) {
		Object validRs = validDelete(fo);
		return validRs != null ? validRs : executeDelete(fo);
	};

	default Object validDelete(VO vo) {
		return null;
	};

	default Object executeDelete(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
