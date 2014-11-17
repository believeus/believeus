package cn.believeus.action;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

  
public class MailBackAction extends Action {  
    @Override
 	public ActionForward execute(ActionMapping mapping, ActionForm form,
    			HttpServletRequest request, HttpServletResponse response)
    			throws Exception {
        String key = request.getParameter("key");  
        if(key == null){  
            return mapping.findForward("error");
        }  
          
        String registerName = (String)request.getSession().getAttribute(key);  
        if(registerName == null || registerName.equals("")){  
        	 return mapping.findForward("error"); 
        }  
        //验证成功就跳转至主页面。
        return mapping.findForward("index");
    }  
}
