package com.pd.common.vo;

import java.util.Collections;
import java.util.List;

public class EmailVO
{
    private String fromEmail;
    
    private String fromName;
    
    private List<String> toList;
    
    private List<String> ccList;
    
    private String subject;
    
    private String content;
    
    public EmailVO(String fromEmail, String fromName, List<String> toList, List<String> ccList, String subject,
        String content)
    {
        super();
        this.fromEmail = fromEmail;
        this.fromName = fromName;
        this.toList = toList;
        this.ccList = ccList;
        this.subject = subject;
        this.content = content;
    }
    
    public String getFromEmail()
    {
        return fromEmail;
    }
    
    public String getFromName()
    {
        return fromName;
    }
    
    public List<String> getToList()
    {
        return toList;
    }
    
    public List<String> getCcList()
    {
        return ccList;
    }
    
    public String getSubject()
    {
        return subject;
    }
    
    public String getContent()
    {
        return content;
    }
    
}
