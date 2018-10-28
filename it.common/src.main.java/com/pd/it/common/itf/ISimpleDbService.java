package com.pd.it.common.itf;

public interface ISimpleDbService<_VO, _Dao extends ISimpleDao<_VO>> extends IDbService<_VO,_VO,_VO, _Dao> {
}
