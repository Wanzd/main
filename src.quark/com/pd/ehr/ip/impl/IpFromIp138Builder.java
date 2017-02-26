package com.pd.ehr.ip.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.ip.vo.IpVo;
import com.pd.ehr.util.Json;
import com.pd.ehr.util.Json.JsonUtil;

class IpFromIp138Builder implements IBuilder<String, IpVo>
{
    
    @Override
    public IpVo build(String _in)
    {
        Json.Dto.Fo fo = new Json.Dto.Fo().setUrl("http://1212.ip138.com/ic.asp");
        String json = JsonUtil.html(fo);
        int startIndex = json.indexOf("[");
        int endIndex = json.indexOf("]");
        String ip = json.substring(startIndex + 1, endIndex);
        return new IpVo().setIp(ip);
    }
    
}