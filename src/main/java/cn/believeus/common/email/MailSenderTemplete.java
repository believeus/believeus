package cn.believeus.common.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailSenderTemplete {
	private BelieveusMailSender sender;
	private VelocityEngine velocityEngine;

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public BelieveusMailSender getSender() {
		return sender;
	}

	public void setSender(BelieveusMailSender sender) {
		this.sender = sender;
	}

	public void sendMail(MailBean mail) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,"utf-8");
		try {
			// 发送邮件的emal人
			helper.setFrom(sender.getUsername());
			helper.setTo(mail.getEmailTo());
			helper.setSubject(mail.getEmailTitle());
			helper.setSentDate(new Date());
			// 设置发送内容
			Map<String, Object> model=new HashMap<String, Object>();
			model.put("FOOTER", "Believeus 感谢你对我们的支持");
			model.put("CONTENTS", mail.getEmailContent());
			model.put("extra", "感谢有你");
			@SuppressWarnings("deprecation")
			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, 
					"cn/believeus/common/email/Admin_to_User_Mail.vm", model);
			// 发送邮件的是html类型
			helper.setText(text, true);
			// 设置当前发送的邮箱服务器是server@mdaxue.com
			sender.setCurrentMailId(0);
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
