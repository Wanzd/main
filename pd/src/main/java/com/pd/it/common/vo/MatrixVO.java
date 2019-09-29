package com.pd.it.common.vo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import lombok.Data;

@Data
public class MatrixVO {
	private static final long serialVersionUID = 8344639996353937629L;

	private String[] cols;

	private String[] names;

	private VO[] values;

	@SuppressWarnings("unlikely-arg-type")
	public MatrixVO(JSONArray json, List<VO> values) {
		int total = json.size();
		cols = new String[total];
		names = new String[total];
		for (int i = 0; i < total; i++) {
			JSONObject object = (JSONObject) json.get(i);
			cols[i] = object.getString("col");
			names[i] = object.getString("name");
		}
		this.values = values.toArray(new VO[values.size()]);
	}

}
