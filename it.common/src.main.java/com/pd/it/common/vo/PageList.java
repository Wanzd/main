package com.pd.it.common.vo;

import java.util.ArrayList;

/**�ֲ������װVO��*/
public class PageList<VO> extends ArrayList<VO>
{
    private static final long serialVersionUID = 9034138639691681290L;
    
    private PageVO page;
    
    public PageVO getPage()
    {
        return page;
    }
    
    public void setPage(PageVO page)
    {
        this.page = page;
    }
}
