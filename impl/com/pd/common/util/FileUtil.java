package com.pd.common.util;

import java.io.File;

public class FileUtil
{
    
    /**
     * 
     * <һ�仰���ܼ���> <������ϸ����>
     * 
     * @param file
     * @return
     * @exception 1 ɾ���ļ�ʧ��
     */
    public static boolean deleteFile(File file)
    {
        return true;
    }
    
    public static boolean write(File file, String str, boolean add)
    {
        return false;
    }
    
    public static File getDir(String ftlTemplatePath)
    {
        File dir = new File(ftlTemplatePath);
        if (dir.exists() && dir.isDirectory())
        {
            return dir;
        }
        else
        {
            return null;
        }
    }

    public static void listFile(File dir)
    {
        // TODO Auto-generated method stub
        
    }
    
}
