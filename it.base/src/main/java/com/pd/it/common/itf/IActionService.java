package com.pd.it.common.itf;

import com.pd.it.common.vo.VO;

public interface IActionService {

	Object query(VO vo);

	Object update(VO vo);

}
