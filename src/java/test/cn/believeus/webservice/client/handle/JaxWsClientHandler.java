package cn.believeus.webservice.client.handle;

import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class JaxWsClientHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (isRequest) {

            try {
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();

                //if no header, add one
                if (soapHeader == null) {
                    soapHeader = soapEnv.addHeader();
                }

                //add an node named "auth"
                QName username = new QName("http://service.webservice.believeus.cn/", "username");
                SOAPHeaderElement usernameHeaderElement = soapHeader.addHeaderElement(username);
                usernameHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                usernameHeaderElement.addTextNode("believeus");
                
                QName passwordQName = new QName("http://service.webservice.believeus.cn/", "password");
                SOAPHeaderElement passwordHeaderElement = soapHeader.addHeaderElement(passwordQName);
                passwordHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                passwordHeaderElement.addTextNode("believeus!@#");
                soapMsg.saveChanges();

                //tracking
                soapMsg.writeTo(System.out);

            } catch (SOAPException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }

        }
        return true;
    }

    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    public void close(MessageContext context) {

    }

    public Set<QName> getHeaders() {
        return null;
    }
/*  <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Header>
		<username xmlns="http://service.webservice.believeus.cn/" 
			  xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" 
                          SOAP-ENV:actor="http://schemas.xmlsoap.org/soap/actor/next">
		believeus
	       </username>
	      <password xmlns="http://service.webservice.believeus.cn/" 
		        xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" 
                        SOAP-ENV:actor="http://schemas.xmlsoap.org/soap/actor/next">
                believeus!@#
              </password>
	</S:Header>
       <S:Body>
	<ns2:findDoctorById xmlns:ns2="http://service.webservice.believeus.cn/">
	     <id>23</id>
        </ns2:findDoctorById>
       </S:Body>
</S:Envelope>*/
}