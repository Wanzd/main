package com.pd.it.common.itf;

import com.pd.base.model.MapVO;

public interface IBuilder<IN, OUT> {
	OUT build(IN in);

	default void init(MapVO rs) {
	};
}
