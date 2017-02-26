package com.pd.ehr.user.api;

import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.user.dto.UserFo;
import com.pd.ehr.user.dto.UserVo;

public interface IUserService<_Vo extends UserVo, _Fo extends UserFo, _Dao extends IUserDao<_Vo, _Fo>> extends IDbService<_Vo, _Fo, _Dao>
{
    
}
