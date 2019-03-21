package com.pd.it.web.itf.action.parallel;

import com.pd.it.common.vo.VO;

public interface ITaskAction {

	default Object task(VO fo) {
		Object validRs = validTask(fo);
		if (validRs != null) {
			return validRs;
		}
		new Thread() {
			@Override
			public void run() {
				executeTask(fo);
			}
		}.start();
		return new VO().put("MSG", "Task started!");
	};

	default Object validTask(VO vo) {
		return null;
	};

	default Object executeTask(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
