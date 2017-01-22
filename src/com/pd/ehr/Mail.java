package com.pd.ehr;

import java.util.ResourceBundle;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Builder.IBuilder;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.Mail.Dao;
import com.pd.ehr.Mail.FO;
import com.pd.ehr.Mail.Service.DbService;
import com.pd.ehr.Mail.VO;

public class Mail extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class VO extends EhrDataBaseVO
    {
        protected Email email;
        
        protected String[] to, cc, bcc;
        
        public Email getEmail()
        {
            return email;
        }
        
        public void setEmail(Email email)
        {
            this.email = email;
        }
        
        public String[] getTo()
        {
            return to;
        }
        
        public void setTo(String[] to)
        {
            this.to = to;
        }
        
        public String[] getCc()
        {
            return cc;
        }
        
        public void setCc(String[] cc)
        {
            this.cc = cc;
        }
        
        public String[] getBcc()
        {
            return bcc;
        }
        
        public void setBcc(String[] bcc)
        {
            this.bcc = bcc;
        }
    }
    
    public static class FO extends VO implements IEhrFilterVO
    {
        
    }
    
    private static class VoBuilder
    {
        public static class ToEmail
        {
            public static class ByLocalResourceBundle implements IBuilder<ResourceBundle, Email>
            {
                @Override
                public Email build(ResourceBundle bundle)
                {
                    Email resultEmail = new Email()
                    {
                        
                        @Override
                        public Email setMsg(String arg0)
                            throws EmailException
                        {
                            // TODO Auto-generated method stub
                            return null;
                        }
                    };
                    resultEmail.setHostName(bundle.getString("host"));
                    resultEmail.setAuthentication(bundle.getString("user"), bundle.getString("pass"));
                    try
                    {
                        resultEmail.setFrom(bundle.getString("from"));
                        resultEmail.addTo(bundle.getString("to"));
                    }
                    catch (EmailException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    return resultEmail;
                }
                
            }
        }
    }
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    
    public static class Service
    {
        public static class MailService
        {
            public static void send(VO vo)
            {
                Email email = vo.email;
                
                try
                {
                    email.send();
                }
                catch (EmailException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        public static class DbService implements IDbService<VO, FO, Dao>
        {
            
        }
    }
    
    public static class Test extends EhrTestCase
    {
        public void testSendMailByBundle()
        {
            Mail.VO mailVO = new Mail.VO();
            ResourceBundle bundle = ResourceBundle.getBundle("com.pd.ehr.base.atom.mail");
            mailVO.email = new Mail.VoBuilder.ToEmail.ByLocalResourceBundle().build(bundle);
            Mail.Service.MailService.send(mailVO);
        }
    }
}
