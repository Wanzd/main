package com.pd.it.common.itf;

public interface IBuilder<IN, OUT> {
	OUT build(IN in);
}
