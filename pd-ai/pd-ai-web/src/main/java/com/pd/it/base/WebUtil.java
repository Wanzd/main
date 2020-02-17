package com.pd.it.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebUtil {
	public static String post(String urlStr, String data) {
		// 装饰器 缓存读取
		BufferedReader bReader = null;
		// 输入流
		InputStreamReader myReader = null;
		StringBuffer sbuf = new StringBuffer();
		// URL对象
		URL url;
		try {
			url = new URL(urlStr);
			myReader = new InputStreamReader(url.openStream(), "utf-8");
			bReader = new BufferedReader(myReader);
			String s = null;
			while ((s = bReader.readLine()) != null) {
				sbuf.append(s);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				myReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sbuf.toString();
	}
}
