package com.pd.it.common.util;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NetUtil {
	public static String content(Map<String, String> _vo) {
		try {
			String url = _vo.get("url");
			Document doc = Jsoup.connect(url).data("query", "java").userAgent("Mozilla").cookie("auth", "token")
					.timeout(30000).post();
			return doc.html();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
