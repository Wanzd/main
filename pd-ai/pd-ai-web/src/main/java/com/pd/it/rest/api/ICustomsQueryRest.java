package com.pd.it.rest.api;

import org.springframework.web.bind.annotation.RequestBody;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryOperation;

public interface ICustomsQueryRest<FO, DTO> extends IQueryInfoRest<FO, DTO>, IQueryListRest<FO, DTO>,
		IQueryPagedListRest<FO, DTO>, IQueryDimensionListRest<FO, DTO>, IQueryDimensionPagedListRest<FO, DTO>,
		IQueryComboRest<FO, DTO> {
	default String queryJson(@RequestBody JSONObject fo) {
		IQueryOperation<FO, DTO> op = Reflects.firstExistField(this, IQueryOperation.class, "dao,service,business");
		return op.queryJson((FO) fo);
	}

}
