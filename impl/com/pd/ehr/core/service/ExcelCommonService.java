package com.pd.ehr.core.service;

import java.io.File;

public class ExcelCommonService
{
    
    public static ExcelImportService getExcelImportService(File file)
    {
        return new ExcelImportService(file);
    }
    
}
