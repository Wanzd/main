package com.pd.it.common.builder;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.provider.MailTemplateProvider;
import com.pd.it.common.vo.MailVO;
import com.pd.it.common.vo.VO;

public class MailVOBuilder implements IBuilder<VO, MailVO>
{
    
    @Override
    public MailVO build(VO in)
    {
        VO templateVO = in.vo("template");
        VO inVO = in.vo("in");
        MailVO rsVO = new MailVO();
        
        rsVO = MailTemplateProvider.cfg(templateVO, inVO);
        return rsVO;
    }
    
}
