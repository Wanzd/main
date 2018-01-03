package builder.java.lang.String;

import com.pd.it.common.itf.IBuilder;

public class Ip implements IBuilder<String, String>
{
    
    @Override
    public String build(String _in)
    {
        // Json.Dto.Fo fo = new Json.Dto.Fo().setUrl("http://1212.ip138.com/ic.asp");
        // String json = JsonUtil.html(fo);
        // int startIndex = json.indexOf("[");
        // int endIndex = json.indexOf("]");
        // String ip = json.substring(startIndex + 1, endIndex);
        // return new IpVo().setIp(ip);
        return "127.0.0.1";
    }
    
}
