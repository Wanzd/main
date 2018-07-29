package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pd.it.common.vo.VO;
import com.pd.it.util.string.FreeMarkerUtil;

public class Format
{
    
    public static String freeMark(String tmplate, VO vo)
    {
        return FreeMarkerUtil.cal(tmplate, vo);
    }
    
    public static String v(VO in, String key)
    {
        Object value = in.get(key);
        return value == null ? null : value.toString();
        
    }
    
    public static <In> List<VO> map2voList(Map<String, In> rsMap, String keyAttrName, String valueAttrName)
    {
        List<VO> rsList = new ArrayList<VO>();
        for (String eachKey : rsMap.keySet())
        {
            rsList.add(new VO(keyAttrName, eachKey).nvl(valueAttrName, rsMap.get(eachKey)));
        }
        return rsList;
    }
    
    public static String str(String string, Object... params)
    {
        return String.format(string, params);
    }
    
    public static void main(String[] args)
    {
        LogUtil.log(freeMark("${a}_${b}", new VO().nvl("a", "a1").nvl("b", "b1")));
    }
}
