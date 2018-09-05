package com.pd.it.common.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
    
    public VO(String key, Object value)
    {
        super();
        put(key, value);
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
    
    public static List<VO> list$str(String jsonStr)
    {
        List<VO> rsList = new ArrayList<VO>();
        JSONArray parseArray = JSON.parseArray(jsonStr);
        for (int i = 0; i < parseArray.size(); i++)
        {
            rsList.add(new VO(parseArray.get(i).toString()));
        }
        return rsList;
    }
    
    public <Out> Out obj(String key, Class<Out> outClass)
    {
        Object object = get(key);
        if (object == null)
        {
            return null;
        }
        
        String jsonString = JSON.toJSONString(object);
        return JSON.parseObject(jsonString, outClass);
    }
    
    public VO vo(String key)
    {
        Object object = get(key);
        if (object instanceof Map)
        {
            return new VO((Map)object);
        }
        return (VO)object;
    }
    
    public List<VO> list(String key)
    {
        Object object = get(key);
        if (object instanceof List)
        {
            List<VO> rsList = new ArrayList<VO>();
            for (Object eachObj : (List)object)
            {
                rsList.add(new VO((Map)eachObj));
            }
            return rsList;
        }
        return (List<VO>)object;
    }
    
    public Object v(String key)
    {
        Object obj = get(key);
        if (obj == null)
        {
            return "";
        }
        return obj;
    }
    
    public String str(String key)
    {
        Object obj = get(key);
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
    
    public VO nvl(String key, Object value)
    {
        if (get(key) == null)
        {
            put(key, value);
        }
        return this;
    }
    
    public double num(String key)
    {
        Object v = get(key);
        if (v != null)
        {
            try
            {
                return Double.valueOf(v.toString());
            }
            catch (Exception e)
            {
                
            }
        }
        return 0;
    }
    
    @Override
    public String toString()
    {
        StringBuffer sBuffer = new StringBuffer();
        
        sBuffer.append("{");
        for (String eachKey : keySet())
        {
            Object object = get(eachKey);
            String valueStr = object instanceof String ? "'" + object.toString() + "'" : object.toString();
            sBuffer.append("," + eachKey + ":" + valueStr);
        }
        sBuffer.delete(1, 2);
        sBuffer.append("}");
        return sBuffer.toString();
    }
}
