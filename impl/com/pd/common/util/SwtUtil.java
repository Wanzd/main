package com.pd.common.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.pd.common.vo.AlarmVO;

public class SwtUtil
{
    public static void msg(AlarmVO vo)
    {
        MessageBox box = new MessageBox(new Shell(Display.getCurrent()));
        box.setText(vo.getTitle());
        box.setMessage(vo.getText());
        box.open();
    }
}
