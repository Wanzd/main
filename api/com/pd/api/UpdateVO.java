package com.pd.api;

public class UpdateVO<_VO>
{
    private _VO oldVO;
    
    private _VO newVO;

    public _VO getOldVO()
    {
        return oldVO;
    }

    public void setOldVO(_VO oldVO)
    {
        this.oldVO = oldVO;
    }

    public _VO getNewVO()
    {
        return newVO;
    }

    public void setNewVO(_VO newVO)
    {
        this.newVO = newVO;
    }

    
}
