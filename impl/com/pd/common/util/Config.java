package com.pd.common.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pd.common.service.EnvPropertyService;
import com.pd.common.service.IPropertyService;
import com.pd.common.service.PropertyService;

public class Config
{
    private static File runBase = null;
    
    private final Logger logger = LoggerFactory.getLogger(Config.class);
    
    private static Map<String, IPropertyService> propertyMap = new HashMap<String, IPropertyService>();
    {
        IPropertyService envService = new EnvPropertyService();
        propertyMap.put("env", envService);
    }
    
    /**
     * 
     * 冷加载 <默认使用冷加载>
     * 
     * @param project
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static IPropertyService getService(String name)
    {
        return getService(name, false);
    }
    
    public static String v(String name, String key)
    {
        IPropertyService service = getService(name, false);
        if (service != null)
        {
            return service.value(key);
        }
        else
        {
            return null;
        }
    }
    
    public static String getUsername()
    {
        return v("system", "user.name");
    }
    
    public static IPropertyService getService(String name, boolean reload)
    {
        boolean findFlag = false;
        if (propertyMap.get(name) != null)
        {
            findFlag = true;
        }
        if (!findFlag || reload)
        {
            IPropertyService service = null;
            if (name == null)
            {
                name = "";
            }
                    service = new PropertyService(name);
                    
            if (service != null)
            {
                propertyMap.put(name, service);
            }
            return service;
        }
        else
        {
            return propertyMap.get(name);
        }
    }
}
