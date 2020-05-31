package com.pd.it.rest.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.Reflects;
import com.pd.it.common.constants.RestPathConst;
import com.pd.it.operation.api.IQueryOperation;

public interface IQueryInfoRest<FO, DTO> {

	@RequestMapping(value = RestPathConst.QUERY_INFO)
	@ResponseBody
	default DTO query(@RequestBody JSONObject fo) {
		IQueryOperation<FO, DTO> op = Reflects.firstExistField(this, IQueryOperation.class, "dao,service,business");
		return op.query((FO) fo);
	}

}
