package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;
import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryOperation;

public interface IQueryPagedListRest<FO, DTO> {

	@RequestMapping(value = "/queryPagedList/{pageSize}/{curPage}")
	@ResponseBody
	default PagedResult<DTO> queryPagedList(@RequestBody JSONObject fo, PageVO pageVO) {
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class,
				"dao,service,business");
		List<DTO> pagedList = operation.queryPagedList((FO) fo, pageVO);
		int count = operation.queryCount((FO) fo);
		pageVO.setTotal(count);
		return new PagedResult(pagedList, pageVO);
	}

}
