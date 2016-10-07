package com.pd.ehr.server;

public class ICheckServer implements Runnable
{
    private volatile boolean liveFlag = true;
    
    @Override
    public void run()
    {
        
        while (liveFlag)
        {
            System.out.println("icheck");
            try
            {
                Thread.sleep(2000);
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
