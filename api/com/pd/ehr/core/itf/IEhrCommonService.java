package com.pd.ehr.core.itf;

public interface IEhrCommonService<DataBaseService extends IEhrDatabaseService, ExcelService extends IEhrExcelService<?>>
{
    DataBaseService getDataBaseService();
    
    ExcelService getExcelService();
}
