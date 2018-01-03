package builder.java.lang.String;

import java.util.Date;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.DateUtil;

public class Date2String implements IBuilder<Date, String>
{
    public static final String DEFAULT_PATTERN = "yyyyMMdd";
    
    private String pattern;
    
    public Date2String()
    {
        pattern = DEFAULT_PATTERN;
    }
    
    public Date2String(String pattern)
    {
        this.pattern = pattern;
    }
    
    @Override
    public String build(Date in)
    {
        return DateUtil.format(in, pattern);
    }
    
}
