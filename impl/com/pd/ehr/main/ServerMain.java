package com.pd.ehr.main;

import com.pd.ehr.server.MainServer;

public class ServerMain
{
    public static void main(String[] args)
    {
        MainServer mainServer = new MainServer();
        new Thread(mainServer).start();
    }
}
