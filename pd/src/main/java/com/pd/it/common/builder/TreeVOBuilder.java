package com.pd.it.common.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.Builds;
import com.pd.it.common.util.Valids;
import com.pd.it.common.vo.VO;

public class TreeVOBuilder implements IBuilder<List<VO>, List<VO>> {

	@Override
	public List<VO> build(List<VO> in) {
		List<VO> rsList = new ArrayList<>();
		Map<String, VO> tmpMap = new HashMap<String, VO>();

		for (VO eachVO : in) {
			tmpMap.put(eachVO.str("id"), eachVO);
		}

		for (VO eachVO : in) {
			String parentId = eachVO.str("parentId");
			if (Valids.notEmpty(parentId)) {
				VO parentVO = tmpMap.get(parentId);
				List<VO> childList = parentVO.list("children");
				childList.add(eachVO);
			} else {
				rsList.add(eachVO);
			}
		}

		return rsList;
	}

	public static void main(String[] args) {
		List<VO> list = new ArrayList<>();
		VO vo1 = new VO();
		vo1.put("parentId", null);
		vo1.put("id", 1);
		list.add(vo1);

		VO vo2 = new VO();
		vo2.put("parentId", 1);
		vo2.put("id", 2);
		list.add(vo2);

		VO vo3 = new VO();
		vo3.put("parentId", 1);
		vo3.put("id", 3);
		list.add(vo3);

		List<VO> rsList = Builds.build(list, new TreeVOBuilder());
		System.out.println(JSON.toJSONString(rsList));
	}

}
