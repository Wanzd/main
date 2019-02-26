package com.pd.it.web.itf;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

public interface IMultyRouteService {

	@ResponseBody
	@RequestMapping(value = "/{dimension}/query", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	default Object query(@PathVariable("dimension") String dimension, @RequestBody(required = false) FO fo) {
		IDimensionService service = getService(dimension);
		if (service == null) {
			return "NO_SERVICE";
		}
		Object ra = service.query(fo);
		return X.jsonStr(ra);
	}

	default Object update(String dimension, VO vo) {
		IDimensionService service = getService(dimension);
		if (service == null) {
			return "NO_SERVICE";
		}
		return service.update(vo);
	}

	default IDimensionService getService(String dimension) {
		try {
			Field fieldByDimension = this.getClass().getDeclaredField(dimension);
			fieldByDimension.setAccessible(true);
			Object object = fieldByDimension.get(this);
			if (object instanceof IDimensionService) {
				return (IDimensionService) object;
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
