package com.pd.ehr.base.mail.test;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.impl.MailChannel;

public class EhrMailTest
{
    @Test
    public void testSendMailByBundle()
        throws EmailException
    {
        EhrMailVo ehrMailVo = new EhrMailVo();
        ehrMailVo.addTo("8363800@163.com");
        ehrMailVo.setSubject("wzd测试邮件");
        ehrMailVo.setMsg("今天天气不错");
//        MailChannel.NetEaseByApache.send(ehrMailVo);
        MailChannel.NetEaseBySession.send(ehrMailVo);
    }
}
