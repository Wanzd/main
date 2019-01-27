package com.pd.it.common.itf;

import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

public interface IActionService {

	Object query(FO vo);

	Object update(VO vo);

}
