package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.base.model.PageVO;
import com.pd.base.model.PagedResult;
import com.pd.it.common.Reflects;
import com.pd.it.common.StringX;
import com.pd.it.operation.api.IQueryOperation;

public interface IQueryRest<FO, DTO> {

	@RequestMapping(value = "/queryList")
	@ResponseBody
	default List<DTO> queryList(@RequestBody JSONObject fo) {
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class,
				"dao,service,business");
		return operation.queryList((FO) fo);
	}

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

	@RequestMapping(value = "/query{dimension}List")
	@ResponseBody
	default List<DTO> queryDimensionList(@RequestBody JSONObject fo, @PathVariable String dimension) {
		dimension = StringX.decap(dimension);
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class, dimension + "Dao",
				dimension + "Service", dimension + "Business");
		return operation.queryList((FO) fo);
	}

	@RequestMapping(value = "/query{dimension}PagedList/{pageSize}/{curPage}")
	@ResponseBody
	default PagedResult<DTO> queryDimensionPagedList(@RequestBody JSONObject fo, @PathVariable String dimension,
			PageVO pageVO) {
		dimension = StringX.decap(dimension);
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class, dimension + "Dao",
				dimension + "Service", dimension + "Business");
		List<DTO> pagedList = operation.queryPagedList((FO) fo, pageVO);
		int count = operation.queryCount((FO) fo);
		pageVO.setTotal(count);
		return new PagedResult(pagedList, pageVO);
	}
}
