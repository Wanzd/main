package com.pd.it.common.util.x;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IChange;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.VO;

public class VO2BatchVO implements IChange<VO, BatchVO<VO>> {
	@Override
	public BatchVO<VO> x(VO in) {
		BatchVO<VO> rsBatchVO = new BatchVO<>();
		String jsonStr = StringX.json(in);
		BatchVO parseObject = JSON.parseObject(jsonStr, BatchVO.class);
		return parseObject;
	}

}
