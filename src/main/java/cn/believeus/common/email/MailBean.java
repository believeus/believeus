package cn.believeus.common.email;

public class MailBean {
	// email标题
	private String emailTitle;
	// email 发送者姓名
	private String fromUserName;
	// email 发送到哪个email
	private String emailTo;
	// email内容
	private String emailContent;
	// email 额外信息
	private String extra1;
	private String extra2;
	private String extra3;
	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	public String getExtra3() {
		return extra3;
	}

	public void setExtra3(String extra3) {
		this.extra3 = extra3;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public String getEmailTitle() {
		return emailTitle;
	}
	public String getEmailTo() {
		return emailTo;
	}

	public String getFromUserName() {
		return fromUserName;
	}


	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}


	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

}
