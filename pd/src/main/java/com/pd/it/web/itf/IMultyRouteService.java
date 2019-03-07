package com.pd.it.web.itf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;

public interface IMultyRouteService {

	@ResponseBody
	@RequestMapping(value = "/{dimension}/query", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object query(@PathVariable("dimension") String dimension, @RequestBody(required = false) FO fo) {
		IQueryService service = Reflects.field(this, dimension + "Service");
		if (service == null) {
			return ResultVO.error("Not support this dimension:" + dimension);
		}
		Object ra = service.query(fo);
		return X.jsonStr(ra);
	}

	default Object update(String dimension, VO vo) {
		IUpdateService service = Reflects.field(this, dimension + "Service");
		if (service == null) {
			return ResultVO.error("Not support this dimension:" + dimension);
		}
		return service.update(vo);
	}

}
