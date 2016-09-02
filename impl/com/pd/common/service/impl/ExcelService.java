package com.pd.common.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pd.common.exception.CommonException;
import com.pd.common.util.ExceptionUtil;
import com.pd.common.util.LogService;
import com.pd.common.util.LogUtil;
import com.pd.common.vo.api.IBaseVO;

public class ExcelService
{
    private LogService logService = LogUtil.getService("excelService", ExcelService.class);
    
    private Workbook wb = null;
    
    public ExcelService(File excelFile)
        throws CommonException
    {
        init(excelFile);
        
    }
    
    private void init(File excelFile)
        throws CommonException
    {
        boolean isE2007 = false; // �ж��Ƿ���excel2007��ʽ
        if (excelFile.getAbsolutePath().endsWith("xlsx"))
        {
            isE2007 = true;
        }
        InputStream input = null;
        try
        {
            input = new FileInputStream(excelFile);
        }
        catch (FileNotFoundException e)
        {
            ExceptionUtil.exception("FileNotFound");
        }
        
        try
        {
            if (isE2007)
            {
                wb = new HSSFWorkbook(input);
            }
            else
            {
                wb = new XSSFWorkbook(input);
            }
        }
        catch (IOException e)
        {
            ExceptionUtil.exception("FileNotFound");
        }
    }
    
    public List<String> getSchema(String sheetName)
    {
        List<String> result = new ArrayList<String>();
        if (wb != null)
        {
            Sheet sheet = wb.getSheet(sheetName); // ��õ�һ���?
            Row row = sheet.getRow(0); // ��������
            System.out.println("Row #" + row.getRowNum()); // ����кŴ�0��ʼ
            Iterator<Cell> cells = row.cellIterator(); // ��õ�һ�еĵ����
            while (cells.hasNext())
            {
                Cell cell = cells.next();
                logService.debug("Cell #" + cell.getColumnIndex());
                switch (cell.getCellType())
                { // ���cell�е�������������
                    case HSSFCell.CELL_TYPE_NUMERIC:
                        logService.debug(cell.getNumericCellValue());
                        result.add(cell.getNumericCellValue() + "");
                        break;
                    case HSSFCell.CELL_TYPE_STRING:
                        logService.debug(cell.getStringCellValue());
                        result.add(cell.getStringCellValue());
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN:
                        logService.debug(cell.getBooleanCellValue());
                        result.add(cell.getBooleanCellValue() + "");
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA:
                        logService.debug(cell.getCellFormula());
                        result.add(cell.getCellFormula());
                        break;
                    default:
                        logService.debug("unsuported sell type");
                        break;
                }
            }
        }
        return result;
    }
    
    public List<IBaseVO> list(String sheetName)
    {
        List<IBaseVO> result = new ArrayList<IBaseVO>();
        List<String> schema = getSchema(sheetName);
        if (wb != null)
        {
            Sheet sheet = wb.getSheet(sheetName); // ��õ�һ���?
            Iterator<Row> rows = sheet.rowIterator(); // ��õ�һ���?�ĵ����
            while (rows.hasNext())
            {
                Row row = rows.next(); // ��������
                System.out.println("Row #" + row.getRowNum()); // ����кŴ�0��ʼ
                Iterator<Cell> cells = row.cellIterator(); // ��õ�һ�еĵ����
                while (cells.hasNext())
                {
                    Cell cell = cells.next();
                    System.out.println("Cell #" + cell.getColumnIndex());
                    switch (cell.getCellType())
                    { // ���cell�е�������������
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        default:
                            System.out.println("unsuported sell type");
                            break;
                    }
                }
            }
        }
        
        return result;
    }
    
}
