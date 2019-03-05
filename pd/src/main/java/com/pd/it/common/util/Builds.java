package com.pd.it.common.util;

import com.pd.it.common.itf.IBuilder;

public class Builds {

	public static <In, Out> Out build(In in, IBuilder<In, Out> builder) {
		if (builder == null) {
			return null;
		}
		return builder.build(in);
	}

}
