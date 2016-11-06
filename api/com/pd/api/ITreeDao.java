package com.pd.api;

import java.util.List;

public interface ITreeDao<_Vo extends DbVO, _Fo extends IFo> extends IBaseDao<_Vo, _Fo>
{
    List<_Vo> root();
    List<_Vo> sub(_Fo fo);
}
