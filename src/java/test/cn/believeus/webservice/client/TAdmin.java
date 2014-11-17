
package cn.believeus.webservice.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tAdmin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAdmin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adminLastLoginTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="adminName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adminPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="admin_Tmodule_TRoles" type="{http://service.webservice.believeus.cn/}tAdminTmoduleTRole" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bowens" type="{http://service.webservice.believeus.cn/}tbowen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headImg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAdmin", propOrder = {
    "adminLastLoginTime",
    "adminName",
    "adminPassword",
    "adminTmoduleTRoles",
    "bowens",
    "email",
    "headImg",
    "id",
    "status"
})
public class TAdmin {

    protected Long adminLastLoginTime;
    protected String adminName;
    protected String adminPassword;
    @XmlElement(name = "admin_Tmodule_TRoles", nillable = true)
    protected List<TAdminTmoduleTRole> adminTmoduleTRoles;
    @XmlElement(nillable = true)
    protected List<Tbowen> bowens;
    protected String email;
    protected String headImg;
    protected Integer id;
    protected Integer status;

    /**
     * Gets the value of the adminLastLoginTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdminLastLoginTime() {
        return adminLastLoginTime;
    }

    /**
     * Sets the value of the adminLastLoginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdminLastLoginTime(Long value) {
        this.adminLastLoginTime = value;
    }

    /**
     * Gets the value of the adminName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * Sets the value of the adminName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminName(String value) {
        this.adminName = value;
    }

    /**
     * Gets the value of the adminPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * Sets the value of the adminPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminPassword(String value) {
        this.adminPassword = value;
    }

    /**
     * Gets the value of the adminTmoduleTRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adminTmoduleTRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdminTmoduleTRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAdminTmoduleTRole }
     * 
     * 
     */
    public List<TAdminTmoduleTRole> getAdminTmoduleTRoles() {
        if (adminTmoduleTRoles == null) {
            adminTmoduleTRoles = new ArrayList<TAdminTmoduleTRole>();
        }
        return this.adminTmoduleTRoles;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

}
