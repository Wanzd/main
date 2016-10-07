package com.pd.ehr.server;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainServer implements Runnable
{
    private volatile boolean liveFlag = true;
    
    private ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(30);
    
    @Override
    public void run()
    {
        newScheduledThreadPool.schedule(new ICheckServer(), 1000, TimeUnit.MILLISECONDS);
        while (liveFlag)
        {
            System.out.println("MainServer:check");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void tryStop()
    {
        liveFlag = false;
    }
}
