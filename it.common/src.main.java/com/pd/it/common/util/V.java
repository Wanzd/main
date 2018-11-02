package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pd.it.common.vo.VO;

public class V
{
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
    
    /**
     * 
     * 判断输入的字符串是否是汉字，数字或字母
     * 
     * @param tmpStr
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isWordChar(String tmpStr)
    {
        if (tmpStr.matches(".*[的是和等有或及与如(其它)(其他)享(熟悉)(岗位)(任职要求)(相关)(发展)(应用)你我他它她].*"))
        {
            return false;
        }
        return tmpStr.matches("[\\da-zA-Z\\u4e00-\\u9fcc]+");
    }
}
