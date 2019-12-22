package com.pd.it.dao.api;

public interface IDao<VO, FO, DTO> extends IQueryDao<FO, DTO>, IUpdateDao<DTO> {
}
