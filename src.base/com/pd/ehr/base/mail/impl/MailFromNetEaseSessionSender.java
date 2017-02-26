package com.pd.ehr.base.mail.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.commons.mail.DefaultAuthenticator;

import com.pd.base.EhrApi.Agent.ISender;
import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.dto.SenderVo;

class MailFromNetEaseSessionSender implements ISender<EhrMailVo>
{
    private SenderVo senderVo;
    
    public MailFromNetEaseSessionSender(String _host, String _from, String _user, String _pass)
    {
        senderVo = new SenderVo(_host, _from, _user, _pass);
    }
    
    @Override
    public void send(EhrMailVo _mailVo)
    {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.host", senderVo.getHost());
        props.setProperty("mail.transport.protocol", "smtp");
        
        Authenticator auth = new DefaultAuthenticator(senderVo.getUser(), senderVo.getPass());
        Session session = Session.getDefaultInstance(props, auth);
        Message msg = new MimeMessage(session);
        try
        {
            msg.setRecipients(RecipientType.TO, _mailVo.getToAddresses().toArray(new InternetAddress[_mailVo.getToAddresses().size()]));
            msg.setFrom(new InternetAddress(senderVo.getFrom()));
            msg.setSubject(_mailVo.getSubject());
            msg.setContent("test", "text/html;charset=utf-8");
            ;
            Transport.send(msg);
        }
        catch (MessagingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
