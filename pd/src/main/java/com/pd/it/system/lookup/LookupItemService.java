package com.pd.it.system.lookup;

import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IActionService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service
public class LookupItemService implements IActionService {

	@Override
	public Object query(FO vo) {

		return "LookupItem_query:test";
	}

	@Override
	public Object update(VO vo) {
		return "LookupItem_update:test";
	}

}
