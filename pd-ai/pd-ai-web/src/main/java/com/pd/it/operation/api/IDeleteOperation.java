package com.pd.it.operation.api;

import org.apache.ibatis.annotations.Param;

public interface IDeleteOperation<FO> {

	int delete(@Param("fo") FO fo);

}
