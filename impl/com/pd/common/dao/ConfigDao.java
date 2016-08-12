package com.pd.common.dao;

import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class ConfigDao
{
    private String filePath = null;
    
    private Properties ps = null;
    
    public ConfigDao(String filePath)
    {
        this.filePath = filePath;
        ps = new Properties();
        InputStream in = (InputStream)ConfigDao.class.getResourceAsStream(this.filePath);
        try
        {
            ps.load(in);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public String getString(String key)
    {
        return ps.getProperty(key);
    }
}
