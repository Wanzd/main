package com.pd.it.service.api;

import com.pd.it.common.Reflects;
import com.pd.it.operation.api.ITruncateOperation;

public interface ITruncateService {

	default void truncate() {
		ITruncateOperation operation = Reflects.firstExistField(this, ITruncateOperation.class, "dao");
		operation.truncate();
	}

}
