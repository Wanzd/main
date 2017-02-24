package com.pd.ehr;

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
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import com.pd.EhrApi.Agent.ISender;
import com.pd.ehr.EhrMail.Dto.EhrMailVo;
import com.pd.ehr.EhrMail.Dto.SenderVo;
import com.pd.ehr.EhrMail.MailSender.NetEaseByApacheSender;
import com.pd.ehr.EhrMail.MailSender.NetEaseBySessionSender;

public class EhrMail
{
    public static void send(EhrMailVo _mailVo)
    {
        for (EhrMailChannel evenChannel : EhrMailChannel.values())
        {
            if (send(evenChannel, _mailVo))
            {
                break;
            }
        }
    }
    
    public static boolean send(EhrMailChannel _channel, EhrMailVo _mailVo)
    {
        _channel.send(_mailVo);
        return true;
    }
    
    public static enum EhrMailChannel implements ISender<EhrMailVo>
    {
        NetEaseBySession("netEase", new NetEaseBySessionSender("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456")), NetEaseByApache("netEase",
            new NetEaseByApacheSender("smtp.163.com", "testwzd@163.com", "testwzd@163.com", "testwzd123456"));
        
        private String name;
        
        private ISender<EhrMailVo> sender;
        
        private EhrMailChannel(String _name, ISender<EhrMailVo> _sender)
        {
            name = _name;
            sender = _sender;
        }
        
        @Override
        public void send(EhrMailVo _mailVo)
        {
            sender.send(_mailVo);
            
        }
        
        public String getName()
        {
            return name;
        }
        
    }
    
    public static class MailSender
    {
        public static class NetEaseByApacheSender implements ISender<EhrMailVo>
        {
            private SenderVo senderVo;
            
            public NetEaseByApacheSender(String _host, String _from, String _user, String _pass)
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
        
        public static class NetEaseBySessionSender implements ISender<EhrMailVo>
        {
            private SenderVo senderVo;
            
            public NetEaseBySessionSender(String _host, String _from, String _user, String _pass)
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
    }
    
    public static class Dto
    {
        public static class EhrMailVo extends Email
        {
            
            @Override
            public Email setMsg(String arg0)
                throws EmailException
            {
                return null;
            }
            
        }
        
        public static class SenderVo
        {
            
            private String host;
            
            private String from;
            
            private String user;
            
            private String pass;
            
            public SenderVo(String host, String from, String user, String pass)
            {
                super();
                this.host = host;
                this.from = from;
                this.user = user;
                this.pass = pass;
            }
            
            public String getHost()
            {
                return host;
            }
            
            public void setHost(String host)
            {
                this.host = host;
            }
            
            public String getFrom()
            {
                return from;
            }
            
            public void setFrom(String from)
            {
                this.from = from;
            }
            
            public String getUser()
            {
                return user;
            }
            
            public void setUser(String user)
            {
                this.user = user;
            }
            
            public String getPass()
            {
                return pass;
            }
            
            public void setPass(String pass)
            {
                this.pass = pass;
            }
            
        }
        
    }
    
    public static class Test extends EhrTestCase
    {
        public void testSendMailByBundle()
            throws EmailException
        {
            EhrMailVo ehrMailVo = new EhrMailVo();
            ehrMailVo.addTo("8363800@163.com");
            ehrMailVo.setSubject("testAtomEhrMail");
            ehrMailVo.setMsg("test");
            EhrMail.send(ehrMailVo);
        }
    }
}
