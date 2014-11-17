
package cn.believeus.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tAdminTmoduleTRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAdminTmoduleTRole">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="admin" type="{http://service.webservice.believeus.cn/}tAdmin" minOccurs="0"/>
 *         &lt;element name="auth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="module" type="{http://service.webservice.believeus.cn/}tmodule" minOccurs="0"/>
 *         &lt;element name="moduleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="role" type="{http://service.webservice.believeus.cn/}tRole" minOccurs="0"/>
 *         &lt;element name="roleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAdminTmoduleTRole", propOrder = {
    "admin",
    "auth",
    "id",
    "module",
    "moduleName",
    "role",
    "roleName"
})
public class TAdminTmoduleTRole {

    protected TAdmin admin;
    protected String auth;
    protected Integer id;
    protected Tmodule module;
    protected String moduleName;
    protected TRole role;
    protected String roleName;

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
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuth(String value) {
        this.auth = value;
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
     * Gets the value of the module property.
     * 
     * @return
     *     possible object is
     *     {@link Tmodule }
     *     
     */
    public Tmodule getModule() {
        return module;
    }

    /**
     * Sets the value of the module property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tmodule }
     *     
     */
    public void setModule(Tmodule value) {
        this.module = value;
    }

    /**
     * Gets the value of the moduleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the value of the moduleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link TRole }
     *     
     */
    public TRole getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRole }
     *     
     */
    public void setRole(TRole value) {
        this.role = value;
    }

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

}
