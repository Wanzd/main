package com.pd.ehr.base.mail.dto;

public class SenderVo
{
    
    private String host;
    
    private String from;
    
    private String user;
    
    private String pass;
    
    public SenderVo(String host, String from, String user, String pass)
    {
        super();
        this.host = host;
        this.from = from;
        this.user = user;
        this.pass = pass;
    }
    
    public String getHost()
    {
        return host;
    }
    
    public void setHost(String host)
    {
        this.host = host;
    }
    
    public String getFrom()
    {
        return from;
    }
    
    public void setFrom(String from)
    {
        this.from = from;
    }
    
    public String getUser()
    {
        return user;
    }
    
    public void setUser(String user)
    {
        this.user = user;
    }
    
    public String getPass()
    {
        return pass;
    }
    
    public void setPass(String pass)
    {
        this.pass = pass;
    }
    
}
