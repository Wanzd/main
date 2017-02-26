package com.pd.ehr.quark.user.api;

import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.quark.user.dto.UserFo;
import com.pd.ehr.quark.user.dto.UserVo;

public interface IUserService<_Vo extends UserVo, _Fo extends UserFo, _Dao extends IUserDao<_Vo, _Fo>> extends IDbService<_Vo, _Fo, _Dao>
{
    
}
