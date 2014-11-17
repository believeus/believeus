
package cn.believeus.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tbowen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tbowen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://service.webservice.believeus.cn/}tAdmin" minOccurs="0"/>
 *         &lt;element name="clickNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="doctor" type="{http://service.webservice.believeus.cn/}tDoctor" minOccurs="0"/>
 *         &lt;element name="editDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="replyNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tbowen", propOrder = {
    "admin",
    "clickNum",
    "content",
    "doctor",
    "editDate",
    "id",
    "replyNum",
    "status",
    "title"
})
public class Tbowen {

    protected TAdmin admin;
    protected Integer clickNum;
    protected String content;
    protected TDoctor doctor;
    protected Long editDate;
    protected Integer id;
    protected Integer replyNum;
    protected Short status;
    protected String title;

    /**
     * Gets the value of the admin property.
     * 
     * @return
     *     possible object is
     *     {@link TAdmin }
     *     
     */
    public TAdmin getAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdmin }
     *     
     */
    public void setAdmin(TAdmin value) {
        this.admin = value;
    }

    /**
     * Gets the value of the clickNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getClickNum() {
        return clickNum;
    }

    /**
     * Sets the value of the clickNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClickNum(Integer value) {
        this.clickNum = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
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
     * Gets the value of the editDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEditDate() {
        return editDate;
    }

    /**
     * Sets the value of the editDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEditDate(Long value) {
        this.editDate = value;
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
     * Gets the value of the replyNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReplyNum() {
        return replyNum;
    }

    /**
     * Sets the value of the replyNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReplyNum(Integer value) {
        this.replyNum = value;
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
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
