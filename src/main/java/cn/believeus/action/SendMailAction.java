package cn.believeus.action;

import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.believeus.system.util.BelieveusAuthenticator;

public class SendMailAction  extends DispatchAction{
	// 发送邮件完成注册。
	  @Override
	 	public ActionForward execute(ActionMapping mapping, ActionForm form,
	    			HttpServletRequest request, HttpServletResponse response)
	    			throws Exception {
				 String toMail = request.getParameter("email");  
				 String registerName = request.getParameter("email");  
				 String userName = "believeusadmin@163.com";   
				 String password = "BELIEVEUS";  
				   
				 String key =Math.random() * Math.random()+"";  
				//待会用户点在邮箱中点击这个链接回到你的网站。
				 /* Begin Name:xiaohuan Date:2013-04-01 ModifyReason:使用反向代理访问tomcat web应用 */
				 String url = "http://www.believeus.cn/mailBack.do?key=" + key;
				 /* End Name:xiaohuan Date:2013-04-01 ModifyReason:使用反向代理访问tomcat web应用 */  
				 HttpSession httpSession = request.getSession();  
				 httpSession.setAttribute(key, registerName);  
				   
				//建立邮件会话 
				 Properties props = new Properties();  
				 props.setProperty("mail.smtp.host", "smtp.163.com");  
				 props.setProperty("mail.smtp.auth", "true");  
				   
				 Authenticator authenticator = new BelieveusAuthenticator(userName, password);  
				//根据属性新建一个邮件会话
				 javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,authenticator);  
				 session.setDebug(true);  
				   
				 try{  
					//设置邮件,设置发件人的地址 
				     Address from = new InternetAddress(userName);  
				   //设置收件人,并设置其接收类型为TO
				     Address to = new InternetAddress(toMail);  
				       
				   //由邮件会话新建一个消息对象
				     MimeMessage msg = new MimeMessage(session);  
				     msg.setFrom(from);  
				     //设置标题
				     msg.setSubject("www.believeus.cn网站注册");  
				     msg.setSentDate(new Date());  
				     //设置信件内容
				     msg.setContent("<a href='" + url + "'>" + url + "</a>", "text/html;charset=utf-8");  
				     msg.setRecipient(RecipientType.TO, to);  
				      
				     //发送邮件
				    Transport transport = session.getTransport("smtp"); 
				  //以smtp方式登录邮箱,第一个参数是发送邮件用的邮件服务器SMTP地址,第二个参数为用户名,第三个参数为密码 
				     transport.connect("smtp.163.com", userName, password);
				   //发送邮件,其中第二个参数是所有已设好的收件人地址 
				     transport.sendMessage(msg,msg.getAllRecipients()); 
				     transport.close(); 
				  
				 } catch(MessagingException e){  
				     e.printStackTrace();  
				 } 
			      request.setAttribute("registerName", registerName);
				 return mapping.findForward("sendMailSuccess");	
		   }
}
