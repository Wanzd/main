package com.pd.ai.timertask
;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestTimerTask {
	@Scheduled(cron = "0 0/30 20 * * ?")
	public void refreshJobData() {
		// AI.execute(new Job51Task());
		// AI.execute(new HouseLocationHeatTask());
	}

}
