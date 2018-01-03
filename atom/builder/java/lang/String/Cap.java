package builder.java.lang.String;

import com.pd.it.common.itf.IBuilder;

public class Cap implements IBuilder<String, String>
{
    
    public String build(String in)
    {
        if (in == null)
        {
            return null;
        }
        return in.substring(0, 1).toUpperCase() + in.substring(1);
    }
    
}
