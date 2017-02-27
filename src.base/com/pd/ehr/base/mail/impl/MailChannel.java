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
import org.apache.commons.mail.EmailException;

import com.pd.base.EhrApi.Agent.ISender;
import com.pd.ehr.base.mail.dto.EhrMailVo;

public enum MailChannel implements ISender<EhrMailVo>
{
    NetEaseBySession("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456")
    {
        @Override
        public void send(EhrMailVo _mailVo)
        {
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.host", host);
            props.setProperty("mail.transport.protocol", "smtp");
            
            Authenticator auth = new DefaultAuthenticator(user, pass);
            Session session = Session.getDefaultInstance(props, auth);
            Message msg = new MimeMessage(session);
            try
            {
                msg.setRecipients(RecipientType.TO, _mailVo.getToAddresses().toArray(new InternetAddress[_mailVo.getToAddresses().size()]));
                msg.setFrom(new InternetAddress(from));
                msg.setSubject(_mailVo.getSubject());
                msg.setContent("test", "text/html;charset=utf-8");
                Transport.send(msg);
            }
            catch (MessagingException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    },
    NetEaseByApache("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456")
    {
        @Override
        public void send(EhrMailVo _mailVo)
        {
            _mailVo.setHostName(host);
            Authenticator auth = new DefaultAuthenticator(user, pass);
            _mailVo.setAuthenticator(auth);
            _mailVo.setSmtpPort(25);
            _mailVo.setCharset("UTF-8");
            try
            {
                _mailVo.setFrom(from);
                _mailVo.send();
            }
            catch (EmailException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    ;
    
    protected String host, from, user, pass;
    
    private MailChannel(String _host, String _from, String _user, String _pass)
    {
        host = _host;
        from = _from;
        user = _user;
        pass = _pass;
    }
    
    public void send(EhrMailVo _mailVo)
    {
        NetEaseBySession.send(_mailVo);
    }
    
}
