package com.pd.it.task.dig;

import java.util.List;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.Find;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.vo.VO;

public class JokeQiushibaikeDigTask implements ITask
{
    
    @Override
    public void execute()
    {
        // 清除旧数据
        // Db.u("joke$qiushibaike.truncate");
        
        // 获取新数据
        VO vo = new VO();
        boolean flag = true;
        AI.build(new JokeQiushibaikeParseBuilder());
        
    }
    
    private class JokeQiushibaikeParseBuilder implements IBuilder<VO, List<VO>>
    {
        
        @Override
        public List<VO> build(VO in)
        {
            
            int curPage = 0;
            boolean pageFlag = true;
            String historyId = "";
            page: while (pageFlag)
            {
                VO vo = new VO();
                curPage++;
                if (curPage > 100000000)
                {
                    pageFlag = false;
                }
                String url = "https://www.qiushibaike.com/history/" + historyId;
                
                vo.put("url", url);
                VO rest = NetUtil.jsoup(vo);
                
                if (rest == null)
                {
                    break;
                }
                String str = rest.str("msg");
                historyId = Find.str$between(str, " href=\"/history/", "/");
                boolean endFlag = true;
                int endIndex = 0;
                vo: while (endFlag)
                {
                    int startIndex = str.indexOf("<a href=\"/article/", endIndex);
                    if (startIndex < 0)
                    {
                        break vo;
                    }
                    startIndex += 9;
                    endIndex = str.indexOf("\"", startIndex);
                    List<String> idList = Find.strs$between(str, " <a href=\"/article/", "\"");
                    
                    for (String eachId : idList)
                    {
                        VO tmpVO = AI.build(new QiushibaikeParseBuilder(),
                            new VO("url", "https://www.qiushibaike.com/article/" + eachId));
                        if (tmpVO != null)
                        {
                            
                            Db.u("joke$qiushibaike.us", new VO("list", AI.list(tmpVO)));
                        }
                        try
                        {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
            return null;
        }
        
    }
    
    private class QiushibaikeParseBuilder implements IBuilder<VO, VO>
    {
        
        @Override
        public VO build(VO in)
        {
            
            VO rest = NetUtil.jsoup(in);
            
            if (rest == null)
            {
                return null;
            }
            String msg = rest.str("msg");
            
            VO rsVO = new VO();
            String url = in.str("url");
            
            String id = url.substring(url.lastIndexOf("/") + 1);
            rsVO.put("id", id);
            String content = Find.str$between(msg, "<div class=\"content-text\">", "</div>");
            content = Find.str$trim(content, ";");
            content = content.substring(0, content.length() - 1);
            if (content.length() > 2000)
            {
                return null;
            }
            rsVO.put("content", content);
            
            String thumbs = Find.str$between(msg, "data-votes=\"", "\"");
            thumbs = Find.str$trim(thumbs, ";");
            rsVO.put("thumbs", AI.num(thumbs));
            
            String comments = Find.str$between(msg, "<span class=\"comments\">", " 评论");
            comments = Find.str$trim(comments, ";");
            rsVO.put("comments", AI.num(comments));
            return rsVO;
        }
        
    }
}
