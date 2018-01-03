package com.pd.it.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pd.it.common.util.AI;
import com.pd.it.common.vo.MailVO;

import builder.com.pd.it.common.vo.MailVO.MailSender;

public class MailTest
{
    @Test
    public void testSendMail()
    {
        MailVO c = AI.c(MailVO.class, "to", "496019830@qq.com");
        String rs = AI.<MailVO, String> send(c, new MailSender());
        assertEquals("success", rs);
    }
}
