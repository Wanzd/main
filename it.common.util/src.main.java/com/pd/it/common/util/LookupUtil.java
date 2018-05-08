package com.pd.it.common.util;

import java.util.List;

import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.vo.VO;

public class LookupUtil
{
    public static List<VO> raType(VO vo)
    {
        IDbDao lookupTypeDao = BeanUtil.<IDbDao> getBean("com.pd.it.dao.System$ILookupTypeDao");
        return lookupTypeDao.ra(vo);
    }
    
    public static VO rItem(String type, String key)
    {
        IDbDao commonDao = BeanUtil.<IDbDao> getBean("com.pd.it.dao.ICommonDao");
        VO dbVO = new VO();
        dbVO.put("sql", String.format("select * from lookup_t where type_id='%s' and id='%s'", type, key));
        return DbUtil.r(commonDao, dbVO);
    }
    
    public static List<VO> raItem(VO vo)
    {
        IDbDao commonDao = BeanUtil.<IDbDao> getBean("com.pd.it.dao.ICommonDao");
        vo.put("sql", String.format("select * from lookup_t where type_id='%s'", vo.v("typeId")));
        return DbUtil.ra(commonDao, vo);
    }
    
    public static List<VO> raTemplate()
    {
        VO mailTemplateVO = new VO();
        mailTemplateVO.put("sql", "select * from mail_template_t");
        
        List<VO> rsList = DbUtil.raCommon(mailTemplateVO);
        return rsList;
    }
    
    public static VO rTemplate(String templateId)
    {
        VO mailTemplateVO = new VO();
        mailTemplateVO.put("sql", String.format("select * from mail_template_t where id='%s'", templateId));
        VO rsVO = DbUtil.rCommon(mailTemplateVO);
        return rsVO;
    }
    
}
