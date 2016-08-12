package com.pd.common.util;

import javax.xml.bind.ValidationException;

public class PasswordUtil
{
    /**
     * 
     * <获得加密后的密码> <使用md5方式进行加密>
     * 
     * @param pass
     * @return
     * @throws ValidationException
     * @see [类、类#方法、类#成员]
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
     * <检查用户输入密码的复杂度是否足够高> <必须包含数字，大写字母，小写字母，且长度必须大于6>
     * 
     * @param pass
     * @return
     * @see [类、类#方法、类#成员]
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
