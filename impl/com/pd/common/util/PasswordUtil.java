package com.pd.common.util;

import javax.xml.bind.ValidationException;

public class PasswordUtil
{
    /**
     * 
     * <��ü��ܺ������> <ʹ��md5��ʽ���м���>
     * 
     * @param pass
     * @return
     * @throws ValidationException
     * @see [�ࡢ��#��������#��Ա]
     */
    public static String getEncodePassword(String pass)
        throws ValidationException
    {
        if (!validate(pass))
        {
            throw new ValidationException("pass is not valid");
        }
        return EncryptUtil.md5Encode(pass);
    }
    
    /**
     * 
     * <����û���������ĸ��Ӷ��Ƿ��㹻��> <����������֣���д��ĸ��Сд��ĸ���ҳ��ȱ������6>
     * 
     * @param pass
     * @return
     * @see [�ࡢ��#��������#��Ա]
     */
    private static boolean validate(String pass)
    {
        ValidateAccess access = new ValidateAccess(pass);
        if (access.isNull())
        {
            return false;
        }
        if (!access.match(".{6}.+"))
        {
            return false;
        }
        if (!access.match("[a-z]+"))
        {
            return false;
        }
        if (!access.match("[A-Z]+"))
        {
            return false;
        }
        if (!access.match("[0-9]+"))
        {
            return false;
        }
        return false;
    }
}
