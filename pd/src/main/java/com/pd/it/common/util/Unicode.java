package com.pd.it.common.util;

public class Unicode {

	public static String cn2unicode(final String cnStr) {
		char[] utfBytes = cnStr.toCharArray();
		String unicodeBytes = "";
		for (int i = 0; i < utfBytes.length; i++) {
			String hexB = Integer.toHexString(utfBytes[i]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		return unicodeBytes;
	}

	public static String unicode2cn(String dataStr) {
		int start = 0;
		int end = -1;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start);
			String charStr = "";
			if (end > start) {
				charStr = dataStr.substring(start, end);
				buffer.append(charStr);
			} else if (end == start) {
				end = start + 6;
				charStr = dataStr.substring(start + 2, end);
				char letter = (char) Integer.parseInt(charStr, 16); // 16鏉╂稑鍩梡arse閺佹潙鑸扮�涙顑佹稉灞傦拷锟�

				buffer.append(new Character(letter).toString());
			} else {
				charStr = dataStr.substring(start);
				buffer.append(charStr);
			}
			start = end;
		}
		return buffer.toString();
	}
}
