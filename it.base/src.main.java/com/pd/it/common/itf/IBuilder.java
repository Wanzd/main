package com.pd.it.common.itf;

/**
 * 通用构建器接口
 * @author Administrator
 *
 * @param <In>
 * @param <Out>
 */
public interface IBuilder<In, Out> {
	Out build(In in);

	default Out build(In in, String[] param) {
		return build(in);
	};

}
