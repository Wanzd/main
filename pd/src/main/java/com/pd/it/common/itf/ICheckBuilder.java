package com.pd.it.common.itf;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ICheck;
import com.pd.it.common.itf.ICheckIn;
import com.pd.it.common.itf.ILogic;

public interface ICheckBuilder<In, Out> extends IBuilder<In, Out>, ILogic<In, Out>, ICheckIn<In>, ICheck<In> {
	@Override
	public default Out build(In in) {
		if (!checkIn(in)) {
			return null;
		}
		if (!check(in)) {
			return null;
		}
		return logic(in);
	}
}
