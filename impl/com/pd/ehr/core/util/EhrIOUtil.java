package com.pd.ehr.core.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EhrIOUtil
{
    
    public static BufferedWriter getBufferedWriterByFile(File outputFile)
    {
        BufferedWriter bw = null;
        try
        {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bw;
    }
    
}
