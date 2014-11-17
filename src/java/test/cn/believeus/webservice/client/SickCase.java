
package cn.believeus.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sickCase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sickCase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="doctor" type="{http://service.webservice.believeus.cn/}tDoctor" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="solve" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="user" type="{http://service.webservice.believeus.cn/}tuser" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sickCase", propOrder = {
    "createDate",
    "description",
    "doctor",
    "id",
    "solve",
    "user"
})
public class SickCase {

    protected Long createDate;
    protected String description;
    protected TDoctor doctor;
    protected Integer id;
    protected Short solve;
    protected Tuser user;

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreateDate(Long value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the doctor property.
     * 
     * @return
     *     possible object is
     *     {@link TDoctor }
     *     
     */
    public TDoctor getDoctor() {
        return doctor;
    }

    /**
     * Sets the value of the doctor property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDoctor }
     *     
     */
    public void setDoctor(TDoctor value) {
        this.doctor = value;
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
     * Gets the value of the solve property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getSolve() {
        return solve;
    }

    /**
     * Sets the value of the solve property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setSolve(Short value) {
        this.solve = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link Tuser }
     *     
     */
    public Tuser getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tuser }
     *     
     */
    public void setUser(Tuser value) {
        this.user = value;
    }

}
