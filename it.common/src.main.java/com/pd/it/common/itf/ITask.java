package com.pd.it.common.itf;

import java.util.List;

public interface ITask
{
    void execute();
    
    List<ITask> sub();
}
