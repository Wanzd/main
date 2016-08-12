package com.pd.common.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class MailUtil
{
    public static boolean send(Email mail)
    {
        try
        {
            mail.send();
        }
        catch (EmailException e)
        {
            e.printStackTrace();
        }
        return true;
    }
}
