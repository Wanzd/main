package com.pd.it.dao.api;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pd.it.operation.api.IInsertListOperation;

public interface IUpdateDao<DTO> extends IInsertListOperation<DTO> {

	int updateList(@Param("list") List<DTO> list) throws SQLException;

	int deleteList(@Param("list") List<DTO> list) throws SQLException;

	int delete(@Param("fo") DTO dto) throws SQLException;
}
