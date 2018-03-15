package com.pd.it.common.provider;

import org.apache.ibatis.jdbc.SQL;

public class AiSqlProvider
{
    public String c()
    {
        String cStr = new SQL()
        {
            {
                INSERT_INTO("User_t");
                VALUES("id,name", "#{id},#{name}");
            }
        }.toString();
        return cStr;
    }
    
    public String r()
    {
        String dStr = new SQL()
        {
            {
                SELECT("id,name");
                WHERE("id=#{id}");
            }
        }.toString();
        return dStr;
    }
    
    public String d()
    {
        String dStr = new SQL()
        {
            {
                DELETE_FROM("User_t");
                WHERE("id=#{id}");
            }
        }.toString();
        return dStr;
    }
}
