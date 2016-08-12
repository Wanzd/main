package com.pd.common.builder;

import org.apache.commons.mail.Email;

import com.pd.common.service.PdMail;
import com.pd.common.vo.EmailVO;

public class MailBuilder
{
    private EmailVO mailVO = null;
    
    public MailBuilder(EmailVO _mailVO)
    {
        mailVO = _mailVO;
    }
    
    public Email build()
    {
        PdMail mail = new PdMail(mailVO);
        return mail;
    }
}
