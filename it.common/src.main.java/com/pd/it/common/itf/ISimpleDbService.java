package com.pd.it.common.itf;

import com.pd.it.common.vo.FO;

public interface ISimpleDbService<_VO, _Dao extends ISimpleDao<_VO>> extends IDbService<_VO,FO,_VO, _Dao> {
}
