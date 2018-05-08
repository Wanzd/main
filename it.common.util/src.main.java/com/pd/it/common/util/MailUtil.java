package com.pd.it.common.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pd.it.common.builder.MailVOBuilder;
import com.pd.it.common.vo.MailVO;
import com.pd.it.common.vo.VO;

public class MailUtil
{
    private static VO ps = new VO();
    static
    {
        ps.put("username", LookupUtil.rItem("systemCfg", "mail.username").v("value"));
        ps.put("password", LookupUtil.rItem("systemCfg", "mail.password").v("value"));
    }
    
    public static void send(String templateId, VO vo)
    {
        VO inVO = new VO();
        VO mailTemplateVO = LookupUtil.rTemplate(templateId);
        inVO.put("template", mailTemplateVO);
        inVO.put("in", vo);
        MailVO mailVO = AI.build(new MailVOBuilder(), inVO);
        send(mailVO);
        
    }
    
    public static void send(MailVO vo)
    {
        Properties props = new Properties();
        // 设置用户的认证方式
        props.setProperty("mail.smtp.auth", "true");
        // 设置传输协议
        props.setProperty("mail.transport.protocol", "smtp");
        // 设置发件人的SMTP服务器地址
        props.setProperty("mail.smtp.host", "smtp.163.com");
        // 2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        // 设置调试信息在控制台打印出来
        session.setDebug(true);
        // 3、创建邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        try
        {
            msg.setFrom(new InternetAddress("testwzd@163.com"));
            msg.setContent(vo.getContent(), "text/html;charset=UTF-8");
            msg.setSubject(vo.getTitle());
            // 4、根据session对象获取邮件传输对象Transport
            Transport transport = session.getTransport();
            // 设置发件人的账户名和密码
            transport.connect(ps.str("username"), ps.str("password"));
            Address[] to = new Address[] {new InternetAddress(vo.getTo())};
            transport.sendMessage(msg, to);
        }
        catch (MessagingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
