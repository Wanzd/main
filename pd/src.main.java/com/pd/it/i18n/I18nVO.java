package com.pd.it.i18n;

import java.util.Date;
import java.util.Map;

public class I18nVO
{
    protected String id;
    
    protected String name;
    
    protected String sex;
    
    protected Date birthday;
    
    protected String birthdayN;
    
    protected String phoneNumber;
    
    protected Map<String, Object> other;
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public Date getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }
    
    public String getBirthdayN()
    {
        return birthdayN;
    }
    
    public void setBirthdayN(String birthdayN)
    {
        this.birthdayN = birthdayN;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public Map<String, Object> getOther()
    {
        return other;
    }
    
    public void setOther(Map<String, Object> other)
    {
        this.other = other;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
}
