
package cn.believeus.webservice.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tuser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tuser">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adminEditDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="applyStatus" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="bowens" type="{http://service.webservice.believeus.cn/}tbowen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="doctors" type="{http://service.webservice.believeus.cn/}tDoctor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headImg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastLoginTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photoNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sickCases" type="{http://service.webservice.believeus.cn/}sickCase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tuser", propOrder = {
    "address",
    "adminEditDate",
    "applyStatus",
    "bowens",
    "doctors",
    "email",
    "headImg",
    "id",
    "lastLoginTime",
    "nickName",
    "password",
    "photoNum",
    "regTime",
    "sex",
    "sickCases",
    "status"
})
public class Tuser {

    protected String address;
    protected Long adminEditDate;
    protected Short applyStatus;
    @XmlElement(nillable = true)
    protected List<Tbowen> bowens;
    @XmlElement(nillable = true)
    protected List<TDoctor> doctors;
    protected String email;
    protected String headImg;
    protected Integer id;
    protected Long lastLoginTime;
    protected String nickName;
    protected String password;
    protected String photoNum;
    protected Long regTime;
    protected String sex;
    @XmlElement(nillable = true)
    protected List<SickCase> sickCases;
    protected Short status;

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
     * Gets the value of the adminEditDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdminEditDate() {
        return adminEditDate;
    }

    /**
     * Sets the value of the adminEditDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdminEditDate(Long value) {
        this.adminEditDate = value;
    }

    /**
     * Gets the value of the applyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getApplyStatus() {
        return applyStatus;
    }

    /**
     * Sets the value of the applyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setApplyStatus(Short value) {
        this.applyStatus = value;
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
     * Gets the value of the doctors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the doctors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDoctors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDoctor }
     * 
     * 
     */
    public List<TDoctor> getDoctors() {
        if (doctors == null) {
            doctors = new ArrayList<TDoctor>();
        }
        return this.doctors;
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
     * Gets the value of the headImg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * Sets the value of the headImg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadImg(String value) {
        this.headImg = value;
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
     * Gets the value of the lastLoginTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Sets the value of the lastLoginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastLoginTime(Long value) {
        this.lastLoginTime = value;
    }

    /**
     * Gets the value of the nickName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the value of the nickName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
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
     * Gets the value of the regTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRegTime() {
        return regTime;
    }

    /**
     * Sets the value of the regTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRegTime(Long value) {
        this.regTime = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
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

}
