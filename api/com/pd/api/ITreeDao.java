package com.pd.api;

import com.pd.ehr.vo.DatabaseVO;
import com.pd.ehr.vo.IEhrFilterVO;

public interface ITreeDao<VO extends DatabaseVO, FO extends IEhrFilterVO> extends IBaseDao<VO, FO>
{
    
}
