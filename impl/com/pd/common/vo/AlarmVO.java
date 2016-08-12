package com.pd.common.vo;

import java.util.Date;

public class AlarmVO
{
    private String title;
    
    private String text;
    
    private String rule;
    
    public AlarmVO(String title, String text, String rule)
    {
        super();
        this.title = title;
        this.text = text;
        this.rule = rule;
    }
    
    private Date nextAlarm;
    
    public String getTitle()
    {
        return title;
    }
    
    public String getText()
    {
        return text;
    }
    
    public String getRule()
    {
        return rule;
    }
    
    public Date getNextAlarm()
    {
        return nextAlarm;
    }
    
}
