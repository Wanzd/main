package com.pd.it.common.util;

import com.pd.it.common.itf.ISender;

public class Sends {
	public static <MsgVO, Sender> String send(MsgVO msgVO, ISender<MsgVO> sender) {
		return sender.send(msgVO);
	}
}
