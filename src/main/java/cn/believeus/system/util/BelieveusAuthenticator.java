package cn.believeus.system.util;

import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;  
  
public class BelieveusAuthenticator extends Authenticator {  
    private String userName;  
    private String password;  
  
    public BelieveusAuthenticator(String userName, String password){  
        this.userName = userName;  
        this.password = password;  
    }  
  
    @Override  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(userName, password);  
    }  
}  
