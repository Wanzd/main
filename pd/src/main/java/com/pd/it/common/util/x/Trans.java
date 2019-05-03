package com.pd.it.common.util.x;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.vo.VO;

public class Trans {

	public static <Out> Out obj(Object in, Class<Out> outClass) {
		String jsonString = JSON.toJSONString(in);
		return JSON.parseObject(jsonString, outClass);
	}

	public static <Out> List<Out> list(List in, Class<Out> outClass) {
		List<Out> rsList = new ArrayList<>();
		for (Object eachVO : in) {
			rsList.add(obj(eachVO, outClass));
		}
		return rsList;
	}

	public static <OUT> List<OUT> matrixList(String text, Class<OUT> clazz) {
		List<OUT> rsList = new ArrayList<>();
		String[] rows = text.split("\r\n");
		String schemaStr = rows[0];

		String[] schemas = schemaStr.split("\\|");
		for (int i = 1, total = rows.length; i < total; i++) {
			String rowStr = rows[i];
			VO vo = new VO();
			String[] cols = rowStr.split("\\|");

			for (int j = 0, totalJ = schemas.length; j < totalJ; j++) {
				if (cols.length > j) {
					vo.p(schemas[j], cols[j]);
				}
			}
			OUT outVO = Trans.obj(vo, clazz);
			rsList.add(outVO);
		}
		return rsList;
	}
}
