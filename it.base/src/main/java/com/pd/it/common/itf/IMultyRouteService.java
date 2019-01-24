package com.pd.it.common.itf;

import java.lang.reflect.Field;

import com.pd.it.base.util.Exceptions;
import com.pd.it.common.vo.VO;

public interface IMultyRouteService {

	default Object query(String dimension, VO vo) {
		IActionService service = getService(dimension);
		if (service == null) {
			return Exceptions.NO_SERVICE;
		}
		return service.query(vo);
	}

	default Object update(String dimension, VO vo) {
		IActionService service = getService(dimension);
		if (service == null) {
			return Exceptions.NO_SERVICE;
		}
		return service.update(vo);
	}

	default IActionService getService(String dimension) {
		try {
			Field fieldByDimension = this.getClass().getDeclaredField(dimension);
			fieldByDimension.setAccessible(true);
			Object object = fieldByDimension.get(this);
			if (object instanceof IActionService) {
				return (IActionService) object;
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
