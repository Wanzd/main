package com.pd.it.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pd.it.common.vo.MailVO;

public class MailUtil
{
    public static void send(MailVO vo)
    {
        LogUtil.debug("send to:", vo.getTo());
        Properties props = new Properties(); // ���Լ���һ�������ļ�
        // ʹ��smtp�����ʼ�����Э��
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.163.com");// �洢�����ʼ�����������Ϣ
        props.put("mail.smtp.auth", "true");// ͬʱͨ����֤
        
        Session session = Session.getInstance(props);// ���������½�һ���ʼ��Ự
        // session.setDebug(true); //�������ӡһЩ������Ϣ��
        
        MimeMessage message = new MimeMessage(session);// ���ʼ��Ự�½�һ����Ϣ����
        try
        {
            message.setFrom(new InternetAddress(vo.getFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(vo.getTo()));// �����ռ���,���������������ΪTO
            message.setSubject(vo.getTitle());// ���ñ���
            // �����ż�����
            // message.setText(mailContent); //���� ���ı� �ʼ� todo
            message.setContent(vo.getContent(), "text/html;charset=UTF-8"); // ����HTML�ʼ���������ʽ�ȽϷḻ
            message.setSentDate(new Date());// ���÷���ʱ��
            message.saveChanges();// �洢�ʼ���Ϣ
            
            // �����ʼ�
            // Transport transport = session.getTransport("smtp");
            Transport transport = session.getTransport();
            transport.connect("user", "pass");
            transport.sendMessage(message, message.getAllRecipients());// �����ʼ�,���еڶ�����������������õ��ռ��˵�ַ
            transport.close();
        }
        catch (MessagingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // ���÷����˵ĵ�ַ
        
    }
    
}
