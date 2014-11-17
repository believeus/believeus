
package cn.believeus.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.believeus.webservice.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindDoctorByIdResponse_QNAME = new QName("http://service.webservice.believeus.cn/", "findDoctorByIdResponse");
    private final static QName _FindDoctorById_QNAME = new QName("http://service.webservice.believeus.cn/", "findDoctorById");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.believeus.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TCases }
     * 
     */
    public TCases createTCases() {
        return new TCases();
    }

    /**
     * Create an instance of {@link DrLevel }
     * 
     */
    public DrLevel createDrLevel() {
        return new DrLevel();
    }

    /**
     * Create an instance of {@link SickCase }
     * 
     */
    public SickCase createSickCase() {
        return new SickCase();
    }

    /**
     * Create an instance of {@link TAdmin }
     * 
     */
    public TAdmin createTAdmin() {
        return new TAdmin();
    }

    /**
     * Create an instance of {@link TAdminTmoduleTRole }
     * 
     */
    public TAdminTmoduleTRole createTAdminTmoduleTRole() {
        return new TAdminTmoduleTRole();
    }

    /**
     * Create an instance of {@link Tbowen }
     * 
     */
    public Tbowen createTbowen() {
        return new Tbowen();
    }

    /**
     * Create an instance of {@link Tmodule }
     * 
     */
    public Tmodule createTmodule() {
        return new Tmodule();
    }

    /**
     * Create an instance of {@link FindDoctorById }
     * 
     */
    public FindDoctorById createFindDoctorById() {
        return new FindDoctorById();
    }

    /**
     * Create an instance of {@link TDoctor }
     * 
     */
    public TDoctor createTDoctor() {
        return new TDoctor();
    }

    /**
     * Create an instance of {@link Tuser }
     * 
     */
    public Tuser createTuser() {
        return new Tuser();
    }

    /**
     * Create an instance of {@link FindDoctorByIdResponse }
     * 
     */
    public FindDoctorByIdResponse createFindDoctorByIdResponse() {
        return new FindDoctorByIdResponse();
    }

    /**
     * Create an instance of {@link TRole }
     * 
     */
    public TRole createTRole() {
        return new TRole();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDoctorByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.believeus.cn/", name = "findDoctorByIdResponse")
    public JAXBElement<FindDoctorByIdResponse> createFindDoctorByIdResponse(FindDoctorByIdResponse value) {
        return new JAXBElement<FindDoctorByIdResponse>(_FindDoctorByIdResponse_QNAME, FindDoctorByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDoctorById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.believeus.cn/", name = "findDoctorById")
    public JAXBElement<FindDoctorById> createFindDoctorById(FindDoctorById value) {
        return new JAXBElement<FindDoctorById>(_FindDoctorById_QNAME, FindDoctorById.class, null, value);
    }

}
