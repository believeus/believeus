package cn.believeus.common.email;
import java.util.ArrayList;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class BelieveusMailSender extends JavaMailSenderImpl implements
		JavaMailSender {
	private ArrayList<String> userNameList;
	private ArrayList<String> passwordList;
	private int currentMailId = 0;
	@Override
	protected void doSend(MimeMessage[] arg0, Object[] arg1)
			throws MailException {
		super.doSend(arg0, arg1);
		super.setUsername(userNameList.get(currentMailId));
		super.setPassword(passwordList.get(currentMailId));
	}

	public int getCurrentMailId() {
		return currentMailId;
	}

	public void setCurrentMailId(int currentMailId) {
		this.currentMailId = currentMailId;
	}

	@Override
	public String getUsername() {
		return userNameList.get(currentMailId);
	}
	
	@Override
	public String getPassword() {
		return passwordList.get(currentMailId);
	}

	@Override
	public void setPassword(String password) {
		if(passwordList == null)
			passwordList = new ArrayList<String>();
		//split password in ,
		String[] passwords = password.split(",");
		if(passwords != null) {
			for(String pw : passwords) {
				passwordList.add(pw);
			}
		}
		super.setPassword(passwordList.get(currentMailId));
	}

	@Override
	public void setUsername(String username) {
		if(userNameList == null)
			userNameList = new ArrayList<String>();
		//split usernmae in ,
		String[] userNames = username.split(",");
		if(userNames != null) {
			for(String user : userNames) {
				userNameList.add(user);
			}
		}
		super.setUsername(userNameList.get(currentMailId));
	}

}
