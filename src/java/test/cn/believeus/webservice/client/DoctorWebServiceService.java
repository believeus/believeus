
package cn.believeus.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.jws.HandlerChain;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DoctorWebServiceService", targetNamespace = "http://service.webservice.believeus.cn/", wsdlLocation = "http://www.believeus.cn/doctor?wsdl")
@HandlerChain(file="chain-handle.xml")
public class DoctorWebServiceService
    extends Service
{

    private final static URL DOCTORWEBSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(cn.believeus.webservice.client.DoctorWebServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = cn.believeus.webservice.client.DoctorWebServiceService.class.getResource(".");
            url = new URL(baseUrl, "http://www.believeus.cn/doctor?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://www.believeus.cn/doctor?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DOCTORWEBSERVICESERVICE_WSDL_LOCATION = url;
    }

    public DoctorWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DoctorWebServiceService() {
        super(DOCTORWEBSERVICESERVICE_WSDL_LOCATION, new QName("http://service.webservice.believeus.cn/", "DoctorWebServiceService"));
    }

    /**
     * 
     * @return
     *     returns DoctorWebService
     */
    @WebEndpoint(name = "DoctorWebServicePort")
    public DoctorWebService getDoctorWebServicePort() {
        return super.getPort(new QName("http://service.webservice.believeus.cn/", "DoctorWebServicePort"), DoctorWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DoctorWebService
     */
    @WebEndpoint(name = "DoctorWebServicePort")
    public DoctorWebService getDoctorWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.webservice.believeus.cn/", "DoctorWebServicePort"), DoctorWebService.class, features);
    }

}
