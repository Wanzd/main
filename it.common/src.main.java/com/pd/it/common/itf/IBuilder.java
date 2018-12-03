package com.pd.it.common.itf;

public interface IBuilder<In, Out> {
	default Out build(In in) {
		return null;
	}

	default Out build(In in, String[] param) {
		return build(in);
	};

}
