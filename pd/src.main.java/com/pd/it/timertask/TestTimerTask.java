package com.pd.it.timertask;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestTimerTask
{
    @Scheduled(cron = "0 0/5 * * * ?")
    public void refreshIoTable()
    {
        System.out.println("test:refreshIoTable" + new Date());
    }
}
