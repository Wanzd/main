package com.pd.it.common.itf;

import java.util.List;

public interface ITask
{
    boolean run();
    List<ITask> sub();
}
