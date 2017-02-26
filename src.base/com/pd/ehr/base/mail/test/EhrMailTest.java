package com.pd.ehr.base.mail.test;

import org.apache.commons.mail.EmailException;
import org.junit.Test;

import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.util.EhrMailUtil;

public class EhrMailTest
{
    @Test
    public void testSendMailByBundle()
        throws EmailException
    {
        EhrMailVo ehrMailVo = new EhrMailVo();
        ehrMailVo.addTo("8363800@163.com");
        ehrMailVo.setSubject("testAtomEhrMail");
        ehrMailVo.setMsg("test");
        EhrMailUtil.send(ehrMailVo);
    }
}
