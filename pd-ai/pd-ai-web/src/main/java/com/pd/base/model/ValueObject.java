package com.pd.base.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ValueObject extends HashMap<String, Object> {
	private static final long serialVersionUID = 8344639996353937629L;

	public ValueObject() {

	}

	public ValueObject(Map<String, ?> map) {
		super();
		if (map == null) {
			return;
		}
		for (String eachKey : map.keySet()) {
			put(eachKey, map.get(eachKey));
		}
	}

	public ValueObject(Attr... attrs) {
		super();
		p(attrs);
	}

	public ValueObject(String jsonStr) {
		super();
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		for (String eachKey : jsonObject.keySet()) {
			put(eachKey, jsonObject.get(eachKey));
		}
	}

	public static List<ValueObject> list$str(String jsonStr) {
		List<ValueObject> rsList = new ArrayList<ValueObject>();
		JSONArray parseArray = JSON.parseArray(jsonStr);
		for (int i = 0; i < parseArray.size(); i++) {
			rsList.add(new ValueObject(parseArray.get(i).toString()));
		}
		return rsList;
	}

	public Object obj(String key) {
		Object obj = get(key);
		return obj;
	}

	public <Out> Out obj(String key, Class<Out> outClass) {
		Object object = get(key);
		if (object == null) {
			return null;
		}

		String jsonString = JSON.toJSONString(object);
		return JSON.parseObject(jsonString, outClass);
	}

	public ValueObject vo(String key) {
		Object object = get(key);
		if (object instanceof Map) {
			return new ValueObject((Map) object);
		}
		return (ValueObject) object;
	}

	public List<ValueObject> list(String key) {
		Object object = get(key);
		if (object == null) {
			List<ValueObject> rsList = new ArrayList<ValueObject>();
			put(key, rsList);
			return rsList;
		}
		if (object instanceof List) {
			return (List<ValueObject>) object;
		}

		return (List<ValueObject>) object;
	}

	public Object v(String key) {
		Object obj = get(key);
		if (obj == null) {
			return "";
		}
		return obj;
	}

	public String str(String key) {
		Object obj = get(key);
		if (obj == null) {
			return "";
		}
		return obj.toString();
	}

	public ValueObject p(Attr... attrs) {
		for (Attr attr : attrs) {
			put(attr.getKey(), attr.getValue());
		}
		return this;
	}

	public ValueObject nvl(Attr... attrs) {
		for (Attr attr : attrs) {
			if (get(attr.getKey()) == null) {
				p(attr);
			}
		}
		return this;
	}

	public double num(String key) {
		Object v = get(key);
		if (v != null) {
			try {
				return Double.valueOf(v.toString());
			} catch (Exception e) {

			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public void init() {
		put("language", "CHN");
	}

	public ValueObject p(String key, Object value) {
		put(key, value);
		return this;
	}
}
