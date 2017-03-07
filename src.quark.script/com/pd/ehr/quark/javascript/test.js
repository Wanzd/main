var batShell;
batShell=new ActiveXObject("WScript.Shell");
var batFlag1=batShell.Run("cmd.exe /c md D:/test1",0,true);
var batFlag=batShell.Run("D:/workspace/ehr.core/src.quark.script/com/pd/ehr/quark/javascript/test.bat",0,true);
