package com.pd.it.base.util.x;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.StringX;
import com.pd.it.common.vo.BatchVO;

public class BatchX {

	public static <OUT> BatchVO<OUT> vo(Object vo, Class<OUT> outClass) {
		String jsonStr = StringX.json(vo);
		BatchVO batchVO = JSON.parseObject(jsonStr, BatchVO.class);

		BatchVO<OUT> rsBatch = new BatchVO<>();
		rsBatch.setItems2Create(ListX.list(batchVO.getItems2Create(), outClass));
		rsBatch.setItems2Update(ListX.list(batchVO.getItems2Update(), outClass));
		rsBatch.setItems2Delete(ListX.list(batchVO.getItems2Delete(), outClass));
		return rsBatch;
	}

}
