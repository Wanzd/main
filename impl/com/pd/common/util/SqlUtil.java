package com.pd.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Properties;

public class SqlUtil
{
    public static Connection getConnection(String type, String url, String user, String password)
    {
        if (type == null)
        {
            return null;
        }
        String sqlType = type.toLowerCase(Locale.ENGLISH);
        
        if (sqlType.equals("mysql"))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            try
            {
                Connection conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static String getConf(String type, String attr)
    {
        Properties ps = new Properties();
        try
        {
            File pFile = new File(String.format("conf/%s.properties", type));
            ps.load(new FileReader(pFile));
            return ps.getProperty(attr);
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
