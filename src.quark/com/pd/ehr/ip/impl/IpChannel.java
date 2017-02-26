package com.pd.ehr.ip.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.ip.vo.IpVo;

public enum IpChannel implements IBuilder<String, IpVo>
{
    Ip138(new IpFromIp138Builder());
    private IBuilder<String, IpVo> builder;
    
    private IpChannel(IBuilder<String, IpVo> _builder)
    {
        builder = _builder;
    }
    
    @Override
    public IpVo build(String _in)
    {
        return builder.build(_in);
    }
}
