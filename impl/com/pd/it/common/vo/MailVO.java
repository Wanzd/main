package com.pd.it.common.vo;

public class MailVO
{
    private String from, to, cc, bcc;
    
    private String title, content;
    
    public String getFrom()
    {
        return from;
    }
    
    public void setFrom(String from)
    {
        this.from = from;
    }
    
    public String getTo()
    {
        return to;
    }
    
    public void setTo(String to)
    {
        this.to = to;
    }
    
    public String getCc()
    {
        return cc;
    }
    
    public void setCc(String cc)
    {
        this.cc = cc;
    }
    
    public String getBcc()
    {
        return bcc;
    }
    
    public void setBcc(String bcc)
    {
        this.bcc = bcc;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
