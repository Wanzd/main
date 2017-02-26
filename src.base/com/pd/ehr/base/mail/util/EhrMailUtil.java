package com.pd.ehr.base.mail.util;

import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.impl.MailChannel;

public class EhrMailUtil
{
    public static void send(EhrMailVo _mailVo)
    {
        for (MailChannel evenChannel : MailChannel.values())
        {
            if (send(evenChannel, _mailVo))
            {
                break;
            }
        }
    }
    
    public static boolean send(MailChannel _channel, EhrMailVo _mailVo)
    {
        _channel.send(_mailVo);
        return true;
    }
    
}
