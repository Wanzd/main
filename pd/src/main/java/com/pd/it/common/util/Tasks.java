package com.pd.it.common.util;

import java.util.ArrayList;
import java.util.List;

import com.pd.it.common.itf.ITask;

public class Tasks {

	public static void execute(ITask task) {
		List<ITask> subList = task.sub();
		if (subList != null) {
			for (ITask itTask : subList) {
				itTask.execute();
			}
		} else {
			task.execute();
		}
	}

	public static void task(final ITask task) {
		Thread th = new Thread() {
			@Override
			public void run() {
				List<ITask> subList = task.sub();
				if (subList != null) {
					for (ITask itTask : subList) {
						itTask.execute();
					}
				} else {
					task.execute();
				}
			}
		};
		th.start();
	}

	
	

}
