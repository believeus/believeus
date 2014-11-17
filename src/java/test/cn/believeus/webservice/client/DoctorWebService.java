
package cn.believeus.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "DoctorWebService", targetNamespace = "http://service.webservice.believeus.cn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DoctorWebService {


    /**
     * 
     * @param id
     * @return
     *     returns cn.believeus.webservice.client.TDoctor
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findDoctorById", targetNamespace = "http://service.webservice.believeus.cn/", className = "cn.believeus.webservice.client.FindDoctorById")
    @ResponseWrapper(localName = "findDoctorByIdResponse", targetNamespace = "http://service.webservice.believeus.cn/", className = "cn.believeus.webservice.client.FindDoctorByIdResponse")
    public TDoctor findDoctorById(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

}
