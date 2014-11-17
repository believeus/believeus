
package cn.believeus.webservice.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDoctor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDoctor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bowens" type="{http://service.webservice.believeus.cn/}tbowen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cases" type="{http://service.webservice.believeus.cn/}tCases" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="drLevel" type="{http://service.webservice.believeus.cn/}drLevel" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="imgHead" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="introduction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="licenceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loginDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="sickCases" type="{http://service.webservice.believeus.cn/}sickCase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="users" type="{http://service.webservice.believeus.cn/}tuser" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDoctor", propOrder = {
    "address",
    "bowens",
    "cases",
    "drLevel",
    "email",
    "id",
    "imgHead",
    "introduction",
    "licenceID",
    "loginDate",
    "name",
    "password",
    "photoNum",
    "regDate",
    "sex",
    "sickCases",
    "status",
    "users"
})
public class TDoctor {

    protected String address;
    @XmlElement(nillable = true)
    protected List<Tbowen> bowens;
    @XmlElement(nillable = true)
    protected List<TCases> cases;
    protected DrLevel drLevel;
    protected String email;
    protected Integer id;
    protected String imgHead;
    protected String introduction;
    protected String licenceID;
    protected Long loginDate;
    protected String name;
    protected String password;
    protected String photoNum;
    protected Long regDate;
    protected Short sex;
    @XmlElement(nillable = true)
    protected List<SickCase> sickCases;
    protected Short status;
    @XmlElement(nillable = true)
    protected List<Tuser> users;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the bowens property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bowens property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBowens().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tbowen }
     * 
     * 
     */
    public List<Tbowen> getBowens() {
        if (bowens == null) {
            bowens = new ArrayList<Tbowen>();
        }
        return this.bowens;
    }

    /**
     * Gets the value of the cases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCases }
     * 
     * 
     */
    public List<TCases> getCases() {
        if (cases == null) {
            cases = new ArrayList<TCases>();
        }
        return this.cases;
    }

    /**
     * Gets the value of the drLevel property.
     * 
     * @return
     *     possible object is
     *     {@link DrLevel }
     *     
     */
    public DrLevel getDrLevel() {
        return drLevel;
    }

    /**
     * Sets the value of the drLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrLevel }
     *     
     */
    public void setDrLevel(DrLevel value) {
        this.drLevel = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the imgHead property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgHead() {
        return imgHead;
    }

    /**
     * Sets the value of the imgHead property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgHead(String value) {
        this.imgHead = value;
    }

    /**
     * Gets the value of the introduction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets the value of the introduction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntroduction(String value) {
        this.introduction = value;
    }

    /**
     * Gets the value of the licenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenceID() {
        return licenceID;
    }

    /**
     * Sets the value of the licenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenceID(String value) {
        this.licenceID = value;
    }

    /**
     * Gets the value of the loginDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLoginDate() {
        return loginDate;
    }

    /**
     * Sets the value of the loginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLoginDate(Long value) {
        this.loginDate = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the photoNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoNum() {
        return photoNum;
    }

    /**
     * Sets the value of the photoNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoNum(String value) {
        this.photoNum = value;
    }

    /**
     * Gets the value of the regDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRegDate() {
        return regDate;
    }

    /**
     * Sets the value of the regDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRegDate(Long value) {
        this.regDate = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSex(Short value) {
        this.sex = value;
    }

    /**
     * Gets the value of the sickCases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sickCases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSickCases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SickCase }
     * 
     * 
     */
    public List<SickCase> getSickCases() {
        if (sickCases == null) {
            sickCases = new ArrayList<SickCase>();
        }
        return this.sickCases;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setStatus(Short value) {
        this.status = value;
    }

    /**
     * Gets the value of the users property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the users property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tuser }
     * 
     * 
     */
    public List<Tuser> getUsers() {
        if (users == null) {
            users = new ArrayList<Tuser>();
        }
        return this.users;
    }

}
