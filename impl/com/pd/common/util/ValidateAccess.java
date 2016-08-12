package com.pd.common.util;

public class ValidateAccess
{
    private String input;
    
    public ValidateAccess(String _input)
    {
        input = _input;
    }
    
    public boolean notNull()
    {
        return null == input;
    }
    
    public boolean isNull()
    {
        return null != input;
    }
    
    public boolean match(String matchStr)
    {
        if (isNull())
        {
            return false;
        }
        return input.matches(matchStr);
    }
}
