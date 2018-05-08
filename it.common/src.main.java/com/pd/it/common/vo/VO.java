package com.pd.it.common.vo;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class VO extends HashMap<String, Object>
{
    private static final long serialVersionUID = 8344639996353937629L;
    
    public VO()
    {
        
    }
    
    public VO(Map<String, Object> map)
    {
        super();
        if (map == null)
        {
            return;
        }
        for (String eachKey : map.keySet())
        {
            put(eachKey, map.get(eachKey));
        }
    }
    
    public VO(String jsonStr)
    {
        super();
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        for (String eachKey : jsonObject.keySet())
        {
            put(eachKey, jsonObject.get(eachKey));
        }
    }
    
    public Object obj(String key)
    {
        return get(key);
    }
    
    public VO vo(String key)
    {
        return (VO)get(key);
    }
    
    public Object v(String key)
    {
        Object obj = obj(key);
        if (obj == null)
        {
            return "";
        }
        return obj;
    }
    
    public String str(String key)
    {
        Object obj = obj(key);
        if (obj == null)
        {
            return "";
        }
        return obj.toString();
    }
    
    public static VO newInstance()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Map<String, Object> toMap()
    {
        return (Map<String, Object>)this;
    }
}
