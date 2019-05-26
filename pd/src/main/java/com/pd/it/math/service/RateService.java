package com.pd.it.math.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.service.IQueryService;
import com.pd.math.RateUtil;

@Service
public class RateService implements IQueryService {

	@Override
	public Object executeR(VO vo) {
		String action = vo.str("action");
		Method method = Reflects.method(this, action);
		if (method == null) {
			return ResultVO.fail("not impl");
		}
		try {
			return method.invoke(this, vo);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return ResultVO.error(e);
		}

	}

	private Object getTimesByOneRate(VO vo) {
		VO dataVO = vo.vo("data");

		double oneRate = dataVO.num("oneRate");
		double targetRate = dataVO.num("targetRate");
		double timesByOneRate = RateUtil.getTimesByOneRate(oneRate, targetRate);

		VO rsVO = new VO();
		rsVO.p("timesByOneRate", timesByOneRate);
		return rsVO;
	}

	private Object getRateByTimes(VO vo) {
		VO dataVO = vo.vo("data");

		double oneRate = dataVO.num("oneRate");
		double times = dataVO.num("times");
		double targetRate = RateUtil.getRateByTime(oneRate, times);

		VO rsVO = new VO();
		rsVO.p("targetRate", targetRate);
		return rsVO;
	}
}