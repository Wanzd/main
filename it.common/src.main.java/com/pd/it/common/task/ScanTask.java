package com.pd.it.common.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.Task;

import com.pd.it.common.itf.ITask;

public class ScanTask extends Task implements ITask
{
    
    @Override
    public List<ITask> sub()
    {
        List<ITask> rsList = new ArrayList<ITask>();
        rsList.add(new ScanTask$Pmd());
        return rsList;
    }
    
}
