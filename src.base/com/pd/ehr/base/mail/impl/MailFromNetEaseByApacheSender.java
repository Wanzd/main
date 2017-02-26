package com.pd.ehr.base.mail.impl;

import javax.mail.Authenticator;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;

import com.pd.base.EhrApi.Agent.ISender;
import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.dto.SenderVo;

class MailFromNetEaseByApacheSender implements ISender<EhrMailVo>
{
    private SenderVo senderVo;
    
    public MailFromNetEaseByApacheSender(String _host, String _from, String _user, String _pass)
    {
        senderVo = new SenderVo(_host, _from, _user, _pass);
    }
    
    @Override
    public void send(EhrMailVo _mailVo)
    {
        _mailVo.setHostName(senderVo.getHost());
        Authenticator auth = new DefaultAuthenticator(senderVo.getUser(), senderVo.getPass());
        _mailVo.setAuthenticator(auth);
        _mailVo.setSmtpPort(25);
        _mailVo.setCharset("UTF-8");
        try
        {
            _mailVo.setFrom(senderVo.getFrom());
            _mailVo.send();
        }
        catch (EmailException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
