package com.pd.it.common;

import java.util.ArrayList;
import java.util.List;

import com.pd.base.model.MapVO;

public class ListX {
	public static <IN> List<IN> array(IN[] inArray) {
		List<IN> rsList = new ArrayList<>();
		for (IN eachVO : inArray) {
			rsList.add(eachVO);
		}
		return rsList;
	}

	public static List<MapVO> as(MapVO... vo) {
		return array(vo);
	}
}
