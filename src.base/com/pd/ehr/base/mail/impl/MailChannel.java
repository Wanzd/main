package com.pd.ehr.base.mail.impl;

import com.pd.base.EhrApi.Agent.ISender;
import com.pd.ehr.base.mail.dto.EhrMailVo;

public enum MailChannel implements ISender<EhrMailVo>
{
    NetEaseBySession(new MailFromNetEaseSessionSender("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456")), NetEaseByApache(
        new MailFromNetEaseByApacheSender("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456"));
    
    private ISender<EhrMailVo> sender;
    
    private MailChannel(ISender<EhrMailVo> _sender)
    {
        sender = _sender;
    }
    
    @Override
    public void send(EhrMailVo _mailVo)
    {
        sender.send(_mailVo);
        
    }
    
}
