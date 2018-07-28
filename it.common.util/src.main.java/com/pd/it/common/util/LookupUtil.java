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
        String sql = String.format("select * from sys_lookupitem_t where type_id='%s' and id='%s'", type, key);
        return DbCmd.r(sql);
    }
    
    public static List<VO> raItem(VO vo)
    {
        String sql = String.format("select * from sys_lookupitem_t where type_id='%s'", vo.v("typeId"));
        return DbCmd.ra(sql);
    }
    
    public static List<VO> raTemplate()
    {
        
        List<VO> rsList = DbCmd.ra("select * from mail_template_t");
        return rsList;
    }
    
    public static VO rTemplate(String templateId)
    {
        String sql = String.format("select * from mail_template_t where id='%s'", templateId);
        return DbCmd.r(sql);
    }
    
}
