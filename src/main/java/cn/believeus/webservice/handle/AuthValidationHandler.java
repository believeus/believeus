package cn.believeus.webservice.handle;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

@Service
public class AuthValidationHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		try {
			if (!isRequest) {
				SOAPMessage soapMsg = context.getMessage();
				Node usernameNode = soapMsg.getSOAPHeader().getElementsByTagName("username").item(0);
				Node passwordNode = soapMsg.getSOAPHeader().getElementsByTagName("password").item(0);
				if (usernameNode != null && passwordNode != null) {
					String username = usernameNode.getTextContent();
					String password = passwordNode.getTextContent();
					if ((username.equals("believeus") && password.equals("believeus!@#"))) {
						return true;
					} else {
						SOAPBody body = soapMsg.getSOAPBody();
						this.throwHeaderInvalid(body, "用户名密码不正确");
						return false;
					}
				} else {
					SOAPBody body = soapMsg.getSOAPBody();
					this.throwHeaderInvalid(body, "用户名密码不正确");
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {

	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

	private void throwHeaderInvalid(SOAPBody body, String causeInfo) {
		try {
			// 添加一个错误信息
			SOAPFault fault = body.addFault();
			fault.setFaultString("协议无效:" + causeInfo);
			throw new SOAPFaultException(fault);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	}
}
