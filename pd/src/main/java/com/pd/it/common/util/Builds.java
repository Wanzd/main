package com.pd.it.common.util;

import java.util.HashMap;
import java.util.Map;

import com.pd.it.common.itf.IBridge;
import com.pd.it.common.itf.IBuilder;

public class Builds {

	public static <In, Out> Out build(In in, IBuilder<In, Out> builder) {
		if (builder == null) {
			return null;
		}
		return builder.build(in);
	}

	public static <In, Out> Out bridge(In in, IBuilder<?, ?>... builders) {
		if (builders == null) {
			return null;
		}
		Object out = in;
		for (IBuilder eachBuilder : builders) {
			if (eachBuilder == null) {
				return null;
			}
			out = eachBuilder.build(out);
		}
		try {
			Out rs = (Out) out;
			return rs;
		} catch (Exception e) {
			LogUtil.err(e);
		}
		return null;
	}

	public static <In, Out> Out bridge(In in, IBridge<In, Out> bridge) {
		return bridge(in, bridge.getBuilders());
	}

	public static <K, V> Map<K, V> map(Map<K, V> map, Object... in) {
		if (map == null) {
			map = new HashMap<K, V>();
		}
		if (in.length % 2 != 0) {
			return map;
		}
		for (int i = 0; i < in.length; i += 2) {
			map.put((K) in[i], (V) in[i + 1]);
		}
		return map;
	}
}
