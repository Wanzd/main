package com.pd.it.rest.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.ObjectX;
import com.pd.it.common.Reflects;
import com.pd.it.job.dao.IBigDataDao;
import com.pd.it.job.model.BigDataDTO;
import com.pd.it.job.model.BigDataFO;
import com.pd.it.operation.api.IQueryOperation;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.rest.api.IRest;

@RestController
@RequestMapping("/rest/bigData")
public class BigDataRest implements IRest, IQueryRest<BigDataFO, BigDataDTO> {
	@Inject
	private IBigDataDao dao;

	@Override
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public List<BigDataDTO> queryList(@RequestBody JSONObject jo) {
		BigDataFO fo = ObjectX.x(jo, BigDataFO.class);
		IQueryOperation<BigDataFO, BigDataDTO> operation = Reflects.firstExistField(this, IQueryOperation.class,
				"dao,service,business");
		return operation.queryList(fo);
	}
}
