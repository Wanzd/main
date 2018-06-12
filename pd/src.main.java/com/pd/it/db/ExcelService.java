package com.pd.it.db;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.provider.CommonSqlProvider;
import com.pd.it.common.util.DbUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.MatrixVO;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.ICommonDao;

@RestController
@RequestMapping("excelService")
public class ExcelService
{
    @Autowired
    private ICommonDao dao;
    
    @Autowired
    private HttpServletRequest request;
    
    @ResponseBody
    @RequestMapping(value = "export/{action}_{module}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public HttpServletResponse export(HttpServletResponse response,
        @PathVariable("") LinkedHashMap<String, String> path, @RequestParam LinkedHashMap<String, Object> in,
        LinkedHashMap<String, String> json)
    {
        KV pathKV = new KV(path);
        String action = "ra";
        VO sqlCfg = CommonSqlProvider.cfg(new KV(path), new VO(in));
        List<VO> rsList = DbUtil.ra(dao, sqlCfg);
        JSONArray cols = JSON.parseArray("[{\"col\":\"year\",\"name\":\"年份\"},{\"col\":\"demand\",\"name\":\"需求\"}]");
        MatrixVO matrix = new MatrixVO(cols, rsList);
        try
        {
            getTestResponse(response, matrix);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return response;
        // return JSON.toJSONString(rsVO);
    }
    
    private HttpServletResponse getTestResponse(HttpServletResponse response, MatrixVO matrix)
        throws IOException
    {
        response.reset();
        String fileName = "test";
        String time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
        try
        {
            response.setHeader("Content-Disposition",
                "attachment; filename=" + java.net.URLEncoder.encode(fileName + time + ".xls", "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.setContentType("application/octet-stream; charset=utf-8");
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sh = wb.createSheet();
        Row trow = sh.createRow(0);
        String[] names = matrix.getNames();
        for (int i = 0, total = names.length; i < total; i++)
        {
            Cell tcell = trow.createCell(i);
            tcell.setCellValue(names[i]);
        }
        
        String[] cols = matrix.getCols();
        VO[] values = matrix.getValues();
        for (int rownum = 0; rownum < values.length; rownum++)
        {
            Row row = sh.createRow(rownum + 1);
            for (int cellnum = 0; cellnum < cols.length; cellnum++)
            {
                String curCol = cols[cellnum];
                Cell cell = row.createCell(cellnum);
                cell.setCellValue(values[rownum].str(curCol));
            }
        }
        ServletOutputStream out = response.getOutputStream();
        wb.write(out);
        out.flush();
        out.close();
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value = "import/{module}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String importExcel(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        path.put("action", "import");
        in.put("id", path.get("id"));
        VO sqlCfg = CommonSqlProvider.cfg(new KV(path), new VO(in));
        VO rsVO = DbUtil.r(dao, sqlCfg);
        return JSON.toJSONString(rsVO);
    }
    
}
