package com.pd.it.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryOperation;

public interface IGetRest<FO, DTO> {

	@RequestMapping(value = "/get")
	@ResponseBody
	default List<DTO> queryList(@RequestBody JSONObject fo) {
		IQueryOperation<FO, DTO> operation = Reflects.firstExistField(this, "dao,service,business",
				IQueryOperation.class);
		return operation.queryList((FO) fo);
	}

}
