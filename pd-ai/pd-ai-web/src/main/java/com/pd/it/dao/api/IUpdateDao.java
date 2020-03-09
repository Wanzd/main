package com.pd.it.dao.api;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.it.operation.api.IDeleteOperation;
import com.pd.it.operation.api.IInsertListOperation;

public interface IUpdateDao<FO, DTO> extends IInsertListOperation<DTO>, IDeleteOperation<FO> {

	int updateList(@Param("list") List<DTO> list) throws SQLException;

	int deleteList(@Param("list") List<DTO> list) throws SQLException;

}
