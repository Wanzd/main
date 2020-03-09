package com.pd.it.service.api;

import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IDeleteOperation;

public interface IDeleteService<FO> {

	default int delete(FO fo) {
		IDeleteOperation<FO> op = Reflects.firstExistField(this, IDeleteOperation.class, "dao");
		return op.delete(fo);
	}

}
