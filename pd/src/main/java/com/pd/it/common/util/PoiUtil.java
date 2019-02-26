//package com.pd.it.common.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class PoiUtil {
//
//	public static void genWord(CommonObject co) {
//		String content = co.v("content");
//		byte b[] = content.getBytes();
//		ByteArrayInputStream bais = new ByteArrayInputStream(b);
//		POIFSFileSystem poifs = new POIFSFileSystem();
//		DirectoryEntry directory = poifs.getRoot();
//		try {
//			DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
//			File file = new File(co.v("filePath"));
//			FileOutputStream fos = new FileOutputStream(file);
//			// 输出到本地文件的话，new一个文件流
//			// FileOutputStream ostream = new FileOutputStream(path+ fileName);
//			poifs.writeFilesystem(fos);
//			bais.close();
//			fos.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// 输出
//	}
//
//}
