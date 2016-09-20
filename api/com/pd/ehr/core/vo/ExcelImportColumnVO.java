package com.pd.ehr.core.vo;

public class ExcelImportColumnVO
{
    private String excelColumnName;
    
    private String excelColumnType;
    
    private String voTo;
    
    public String getExcelColumnName()
    {
        return excelColumnName;
    }
    
    public void setExcelColumnName(String excelColumnName)
    {
        this.excelColumnName = excelColumnName;
    }
    
    public String getExcelColumnType()
    {
        return excelColumnType;
    }
    
    public void setExcelColumnType(String excelColumnType)
    {
        this.excelColumnType = excelColumnType;
    }
    
    public String getVoTo()
    {
        return voTo;
    }
    
    public void setVoTo(String voTo)
    {
        this.voTo = voTo;
    }
}
