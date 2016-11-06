package com.pd.api;

public class UpdateVO<VO>
{
    private VO oldVO;
    
    private VO newVO;
    
    public VO getOldVO()
    {
        return oldVO;
    }
    
    public void setOldVO(VO oldVO)
    {
        this.oldVO = oldVO;
    }
    
    public VO getNewVO()
    {
        return newVO;
    }
    
    public void setNewVO(VO newVO)
    {
        this.newVO = newVO;
    }
}
