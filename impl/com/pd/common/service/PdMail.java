package com.pd.common.service;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import com.pd.common.util.Config;
import com.pd.common.vo.EmailVO;

public class PdMail extends Email
{
    public PdMail(EmailVO email)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("com.pd.common.util.mail");
        try
        {
            String aHostName = bundle.getString("host");
            String userName = bundle.getString("user");
            String password = bundle.getString("pass");
            setAuthentication(userName, password);
            setHostName(aHostName);
            setFrom(email.getFromEmail(), email.getFromName());
            List<String> toList = email.getToList();
            if (toList != null)
            {
                for (String to : toList)
                {
                    if (to.trim().length() > 0)
                    {
                        addTo(to);
                    }
                }
            }
            List<String> ccList = email.getCcList();
            if (ccList != null)
            {
                for (String cc : ccList)
                {
                    if (cc.trim().length() > 0)
                    {
                        addCc(cc);
                    }
                }
            }
            setSubject(email.getSubject());
            setMsg(email.getContent());
        }
        catch (EmailException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public Email setMsg(String arg0)
        throws EmailException
    {
        this.setContent("", null);
        return this;
    }
    
}
