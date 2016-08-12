package com.pd.common.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyDao implements IPropertyDao
{
    private Properties ps = new Properties();
    
    public PropertyDao(String project)
    {
        ClassLoader loader = PropertyDao.class.getClassLoader();
        InputStream is = loader.getResourceAsStream(project + ".properties");
        try
        {
            ps.load(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public String getString(String key)
    {
        if (ps == null)
        {
            return null;
        }
        else
        {
            return ps.getProperty(key);
        }
    }
    
}
