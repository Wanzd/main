package com.pd.it.dev.genModel;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pd.it.common.util.x.Trans;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.service.ICommonService;

@Service
public class GenModelService implements ICommonService {

	@Override
	public Object executeRa(VO vo) {
		String text = vo.str("text");
		List<GenModelVO> rsList = Trans.matrixList(text, GenModelVO.class);
		return rsList;
	}

}
