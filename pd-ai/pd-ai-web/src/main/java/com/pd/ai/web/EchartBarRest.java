package com.pd.ai.web;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.ai.model.EchartBarVO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/echart/bar")
public class EchartBarRest {

	@RequestMapping(value = "/cfg/query")
	@ResponseBody
	public EchartBarVO query() {
		EchartBarVO vo = new EchartBarVO();
		vo.setTitle("成绩单");
		vo.setSubTitle("testSubTitle");
		vo.setLegend(Arrays.asList("数学", "语文", "英语"));
		vo.setXaxis(Arrays.asList("数学", "语文", "英语"));
		vo.addSerie("赵A", Arrays.asList(99D, 120D, 80D));
		vo.addSerie("钱B", Arrays.asList(110D, 105D, 95D));
		return vo;
	}

}
