package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.Reflects;
import com.pd.it.common.StringX;
import com.pd.it.operation.api.IQueryOperation;

public interface IDimensionQueryRest<FO, DTO> {

	@RequestMapping(value = "/query{dimension}")
	@ResponseBody
	default List<DTO> queryDimension(@RequestBody JSONObject fo, @PathVariable String dimension) {
		dimension = StringX.decap(dimension);
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, IQueryOperation.class, dimension + "Dao",
				dimension + "Service", dimension + "Business");
		return operation.queryList((FO) fo);
	}

}
