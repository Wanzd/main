package com.pd.it.restService;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.X;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;
import com.pd.it.restService.EconomicServiceSet.EconomicConfigService;
import com.pd.it.restService.EconomicServiceSet.EconomicDetailService;
import com.pd.it.restService.EconomicServiceSet.EconomicMonthlyService;

@RestController
@RequestMapping("economic")
public class EconomicRestService {

	@Autowired
	private EconomicDetailService detailService;
	@Autowired
	private EconomicConfigService configService;
	@Autowired
	private EconomicMonthlyService monthlyService;

	@ResponseBody
	@RequestMapping(value = "rs/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rs(@PathVariable("dimension") String dimension, LinkedHashMap<String, String> json) {
		List<VO> rs = null;
		switch (dimension) {
		case "detail":
			rs = detailService.rs();
			return X.jsonStr(rs);
		case "config":
			rs = configService.rs();
			return X.jsonStr(rs);
		case "monthly":
			rs = monthlyService.rs();
			return X.jsonStr(rs);
		}

		return null;
	}

	@ResponseBody
	@RequestMapping(value = "us/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String us(@PathVariable("dimension") String dimension, @RequestParam LinkedHashMap<String, Object> in,
			LinkedHashMap<String, String> json) {
		List<VO> rs = null;
		int rsI = -1;
		VO vo = new VO(in);
		String object = vo.str("list");
		object = object.replaceAll("'", "''");
		List<VO> list = VO.list$str(object);
		switch (dimension) {
		case "detail":

			rsI = detailService.us(list);
			ResultVO resultVO = ResultVO.success(rsI + "");
			return X.jsonStr(resultVO);
		case "config":
			rsI = configService.us(list);
			return X.jsonStr(rsI);
		case "monthly":
			rsI = monthlyService.us(list);
			return X.jsonStr(rsI);
		}

		return null;
	}

	@ResponseBody
	@RequestMapping(value = "ds/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String ds(@PathVariable("dimension") String dimension, @RequestParam LinkedHashMap<String, Object> in,
			LinkedHashMap<String, String> json) {
		List<VO> rs = null;
		int rsI = -1;
		VO vo = new VO(in);
		String object = vo.str("list");
		object = object.replaceAll("'", "''");
		List<VO> list = VO.list$str(object);
		switch (dimension) {
		case "detail":

			rsI = detailService.ds(list);
			ResultVO resultVO = ResultVO.success(rsI + "");
			return X.jsonStr(resultVO);
		case "config":
			rsI = configService.ds(list);
			return X.jsonStr(rsI);
		case "monthly":
			rsI = monthlyService.ds(list);
			return X.jsonStr(rsI);
		}

		return null;
	}
}
