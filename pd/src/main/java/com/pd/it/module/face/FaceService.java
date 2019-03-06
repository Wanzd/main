package com.pd.it.module.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.IQueryDimensionService;

@Service
public class FaceService implements IQueryDimensionService {
	@Autowired
	protected IFaceDao dao;

	@Override
	public Object executeQuery(VO vo) {
		VO rsVO = new VO();
		rsVO.put("msg", "test");
		return rsVO;
	}

}
