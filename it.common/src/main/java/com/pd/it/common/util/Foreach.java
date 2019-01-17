package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;

import com.pd.it.common.itf.IBuilder;

/**
 * javascriptÄ£·Â¹¤¾ßforeach
 * 
 * @author thinkpad
 *
 */
public class Foreach {

	public static <IN, OUT> List<OUT> build(List<IN> list, IBuilder<IN, OUT> builder) {
		List<OUT> outList = new ArrayList<OUT>();
		for (IN eachItem : list) {
			outList.add(builder.build(eachItem));
		}
		return outList;
	}

}
