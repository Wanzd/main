package builder.com.pd.it.common.vo.MailVO;

import com.pd.it.common.itf.ISender;
import com.pd.it.common.util.MailUtil;
import com.pd.it.common.util.StringUtil;
import com.pd.it.common.vo.MailVO;

public class MailSender implements ISender<MailVO>
{
    
    @Override
    public String send(MailVO msgVO)
    {
        MailUtil.send(msgVO);
        return StringUtil.BLANK;
    }
    
}
