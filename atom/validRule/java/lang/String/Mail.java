package validRule.java.lang.String;

import com.pd.it.common.itf.IValidRule;

public class Mail implements IValidRule<String>
{
    
    public boolean valid(String in)
    {
        return in.matches(".*@.*");
    }
    
}
