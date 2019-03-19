package com.pd.it.common.util;

import com.pd.it.common.itf.IChange;

/**
 * 我的玩具类~
 * 
 * @author thinkpad
 *
 */
public class Toy {

	/**
	 * 过程内聚执行函数
	 * 
	 * @param in
	 * @param x
	 * @return
	 */
	public static <IN, OUT> OUT x(IN in, IChange<IN, OUT> x) {
		return x.x(in);
	}
}
