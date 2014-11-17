
package cn.believeus.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for drLevel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="drLevel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acceptionLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="chargeLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="doctor" type="{http://service.webservice.believeus.cn/}tDoctor" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="moralLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="patientLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="senseLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="successRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "drLevel", propOrder = {
    "acceptionLevel",
    "chargeLevel",
    "doctor",
    "id",
    "moralLevel",
    "patientLevel",
    "senseLevel",
    "successRate"
})
public class DrLevel {

    protected Integer acceptionLevel;
    protected Integer chargeLevel;
    protected TDoctor doctor;
    protected Integer id;
    protected Integer moralLevel;
    protected Integer patientLevel;
    protected Integer senseLevel;
    protected Integer successRate;

    /**
     * Gets the value of the acceptionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAcceptionLevel() {
        return acceptionLevel;
    }

    /**
     * Sets the value of the acceptionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAcceptionLevel(Integer value) {
        this.acceptionLevel = value;
    }

    /**
     * Gets the value of the chargeLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChargeLevel() {
        return chargeLevel;
    }

    /**
     * Sets the value of the chargeLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChargeLevel(Integer value) {
        this.chargeLevel = value;
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
     * Gets the value of the moralLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMoralLevel() {
        return moralLevel;
    }

    /**
     * Sets the value of the moralLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMoralLevel(Integer value) {
        this.moralLevel = value;
    }

    /**
     * Gets the value of the patientLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPatientLevel() {
        return patientLevel;
    }

    /**
     * Sets the value of the patientLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPatientLevel(Integer value) {
        this.patientLevel = value;
    }

    /**
     * Gets the value of the senseLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSenseLevel() {
        return senseLevel;
    }

    /**
     * Sets the value of the senseLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSenseLevel(Integer value) {
        this.senseLevel = value;
    }

    /**
     * Gets the value of the successRate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSuccessRate() {
        return successRate;
    }

    /**
     * Sets the value of the successRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSuccessRate(Integer value) {
        this.successRate = value;
    }

}
