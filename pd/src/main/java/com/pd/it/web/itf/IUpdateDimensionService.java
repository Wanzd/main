package com.pd.it.web.itf;


import com.pd.it.common.vo.VO;

public interface IUpdateDimensionService {

	default Object validUpdate(VO vo) {
		return null;
	};

	default Object executeUpdate(VO vo) {
		return null;
	};
}
