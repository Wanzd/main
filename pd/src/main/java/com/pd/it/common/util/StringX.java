package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.VO;

public class StringX {
	public static String from(VO in, String key) {
		Object value = in.get(key);
		return value == null ? null : value.toString();

	}

	public static String json(Object rs) {
		if (rs instanceof String) {
			return (String) rs;
		}
		return JSON.toJSONString(rs);
	}

	public static <OUT_CLASS> OUT_CLASS transform(Object object, Class<OUT_CLASS> targetClass) {
		String jsonString = JSON.toJSONString(object);
		return JSON.parseObject(jsonString, targetClass);
	}

	/**
	 * 瀵瑰瓧绗︿覆棣栧瓧姣嶈浆鎴愬ぇ鍐欏瓧姣�
	 * 
	 * @param in
	 * @return
	 */
	public static String cap(String in) {
		if (in == null) {
			return in;
		}
		if (in.length() > 0) {
			return in.substring(0, 1).toUpperCase() + in.substring(1);
		}
		return "";
	}

	public static VO vo(Object vo) {
		if (vo instanceof VO) {
			return (VO) vo;
		}
		return null;
	}

	public static int int$str(String yearStr) {
		return Integer.valueOf(yearStr);
	}

	public static BatchVO<VO> transformBatch(VO vo, Class<VO> class1) {

		return null;
	}

	public static <In> List<In> list(In... in) {
		List<In> rsList = new ArrayList<In>();
		for (In eachIn : in) {
			rsList.add(eachIn);
		}
		return rsList;
	}

	public static double num(String v) {
		try {
			return Double.valueOf(v.toString());
		} catch (Exception e) {
		}
		return 0;
	}
}
