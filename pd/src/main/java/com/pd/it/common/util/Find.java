package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;

import com.pd.it.common.vo.VO;

public class Find {

	public static VO vo(VO in, String xpath) {
		String[] split = xpath.split("/");

		VO cur = in;
		for (String path : split) {
			if (path.startsWith("[") && path.endsWith("]")) {
				String arrayName = path.substring(1, path.indexOf("[", 2));
				List<VO> curArray = cur.list(arrayName);
				String parse = path.substring(path.indexOf("@") + 1, path.indexOf("]"));

				String[] split2 = parse.split("=");
				String pKey = split2[0];
				String pValue = split2[1];

				for (VO eachVO : curArray) {
					System.out.println(eachVO.str("text"));
					if (eachVO.str(pKey).equals(pValue)) {
						cur = eachVO;
						break;
					}
				}
				continue;
			}
			cur = cur.vo(path);
		}
		return cur;
	}

	public static List<VO> vo$list(VO in, String xpath) {
		int lastIndex = xpath.lastIndexOf("/");
		String path = xpath.substring(xpath.lastIndexOf("/[") + 2);
		VO vo = in;
		if (lastIndex >= 0) {
			String preXpath = xpath.substring(0, xpath.lastIndexOf("/"));
			vo = vo(in, preXpath);
		}
		if (vo == null) {
			return null;
		}
		return vo.list(path);
	}

	public static List<String> strs$between(String msg, String startStr, String endStr) {
		int startIdx = 0;
		int endIdx = 0;
		List<String> rsList = new ArrayList<>();
		while (endIdx >= 0) {
			startIdx = msg.indexOf(startStr, endIdx + 1);
			if (startIdx == -1) {
				break;
			}
			startIdx += startStr.length();
			endIdx = msg.indexOf(endStr, startIdx);
			if (endIdx == -1) {
				break;
			}
			String id = msg.substring(startIdx, endIdx);
			if (!rsList.contains(id)) {
				rsList.add(id);
			}
		}
		return rsList;
	}

	public static String str$between(String msg, String startStr, String endStr) {
		int startIdx = msg.indexOf(startStr) + startStr.length();
		int endIdx = msg.indexOf(endStr, startIdx);
		if (startIdx < 0 || endIdx < 0 || startIdx > endIdx) {
			return "";
		}
		msg = msg.substring(startIdx, endIdx);
		return msg;
	}

	public static String str$start(String msg, String startStr) {
		int startIdx = msg.indexOf(startStr) + startStr.length();
		if (startIdx < 0) {
			return "";
		}
		msg = msg.substring(startIdx);
		return msg;
	}

	public static String str$trim(String msg, String trimStr) {
		msg = msg.trim();
		return msg;
	}

	public static String vo$str(VO in, String xpath) {
		int lastIndex = xpath.lastIndexOf("/");
		String path = xpath.substring(xpath.lastIndexOf("/") + 1);
		VO vo = in;
		if (lastIndex >= 0) {
			String preXpath = xpath.substring(0, xpath.lastIndexOf("/"));
			vo = vo(in, preXpath);
		}
		if (vo == null) {
			return null;
		}
		return vo.str(path);
	}

	public static double vo$num(VO in, String xpath) {
		int lastIndex = xpath.lastIndexOf("/");
		String path = xpath.substring(xpath.lastIndexOf("/") + 1);
		VO vo = in;
		if (lastIndex >= 0) {
			String preXpath = xpath.substring(0, xpath.lastIndexOf("/"));
			vo = vo(in, preXpath);
		}
		if (vo == null) {
			return 0;
		}
		return vo.num(path);
	}
}
