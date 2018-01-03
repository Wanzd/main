package com.pd.it.common.itf;

public interface IBuilder<In, Out> {
	Out build(In _in);
}
