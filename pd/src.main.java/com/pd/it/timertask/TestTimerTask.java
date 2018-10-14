package com.pd.it.timertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.pd.it.common.util.AI;
import com.pd.it.task.heat.HouseLocationHeatTask;

@Controller
public class TestTimerTask {
	@Scheduled(cron = "0 0/30 * * * ?")
	public void refreshJobData() {
		// AI.execute(new Job51Task());
		// AI.execute(new HouseLocationHeatTask());
	}

}
