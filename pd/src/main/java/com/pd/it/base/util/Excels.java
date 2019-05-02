package com.pd.it.base.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.pd.it.common.annotation.ExcelCol;
import com.pd.it.common.annotation.ExcelSheet;
import com.pd.it.common.util.AI;

public class Excels {
	public static <OUT> HttpServletResponse getTestResponse(HttpServletResponse response, List<OUT> data)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		Class dataClass = data.get(0).getClass();
		String fileName = _getSheetName(dataClass);
		String time = new SimpleDateFormat("yyyyMMdd-HHmmss.SSS").format(Calendar.getInstance().getTime());
		try {
			response.setHeader("Content-Disposition",
					"attachment; filename=" + java.net.URLEncoder.encode(fileName + "_" + time + ".xls", "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/octet-stream; charset=utf-8");
		HSSFWorkbook wb = new HSSFWorkbook();
		Sheet sh = wb.createSheet();

		// 写ExcelHeader
		Field[] fields = dataClass.getDeclaredFields();
		Row trow = sh.createRow(0);
		for (int i = 0, total = fields.length; i < total; i++) {
			Cell tcell = trow.createCell(i);
			tcell.setCellValue(_getColName(fields[i]));
			sh.setColumnWidth(i, 100 * _getColWidth(fields[i]));
			tcell.setCellStyle(_getHeaderCellStyle(wb));
		}
		for (int i = 0, total = data.size(); i < total; i++) {

			Row tmpRow = sh.createRow(i + 1);
			OUT eachVO = data.get(i);
			for (int j = 0, colCount = fields.length; j < colCount; j++) {
				Field field = fields[j];
				field.setAccessible(true);
				Cell cell = tmpRow.createCell(j);
				if (field.getType().equals(String.class)) {
					Object object = field.get(eachVO);
					cell.setCellValue(object==null?"":object.toString());
					continue;
				}
				if (field.getType().equals(Date.class)) {
					cell.setCellValue((Date) field.get(eachVO));
					CellStyle cellStyle = wb.createCellStyle();
					CreationHelper creationHelper = wb.getCreationHelper();
					short dataFormat = creationHelper.createDataFormat().getFormat("yyyy-MM-dd");
					cellStyle.setDataFormat(dataFormat);
					cell.setCellStyle(cellStyle);
					continue;
				}
				if (field.getType().equals(Long.class)) {
					cell.setCellValue((Long) field.get(eachVO));
					continue;
				}

			}
		}

		ServletOutputStream out = response.getOutputStream();
		wb.write(out);
		out.flush();
		out.close();
		return response;
	}

	private static int _getColWidth(Field field) {
		ExcelCol excelColNameAnnotation = field.getDeclaredAnnotation(ExcelCol.class);
		if (excelColNameAnnotation != null) {
			return excelColNameAnnotation.width();
		}
		;
		return 50;
	}

	private static CellStyle _getHeaderCellStyle(HSSFWorkbook wb) {

		CellStyle headerCellStyle = wb.createCellStyle();
		headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerCellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		headerCellStyle.setFont(font);
		return headerCellStyle;
	}

	private static String _getSheetName(Class dataClass) {
		Annotation excelSheetNameAnnotation = dataClass.getDeclaredAnnotation(ExcelSheet.class);
		if (excelSheetNameAnnotation instanceof ExcelSheet) {
			return ((ExcelSheet) excelSheetNameAnnotation).sheetName();
		}
		;
		return dataClass.getName();
	}

	private static String _getColName(Field field) {
		ExcelCol excelColNameAnnotation = field.getDeclaredAnnotation(ExcelCol.class);
		if (excelColNameAnnotation != null) {
			return excelColNameAnnotation.value();
		}
		;
		return field.getName();
	}
}
