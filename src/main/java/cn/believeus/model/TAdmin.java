package cn.believeus.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * AbstractTadmin entity provides the base persistence definition of the Tadmin
 * entity. @author MyEclipse Persistence Tools
 */
/**
 * @author wuqiwei a
 */
@Indexed
@Entity
@Table(name = "TAdmin")
public class TAdmin implements Serializable{
	// 正常
	public static final Integer StatusNormal=0;
	// 封禁
	public static final Integer StatusBlock=1;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2445415767284999720L;
	private Integer id;
	private String adminName;
	private String headImg;
	private String email;
	private String adminPassword;
	private Long adminLastLoginTime;
	/*状态:0正常 1:封禁*/
	private Integer status;
	private Set<Tbowen> bowens = new HashSet<Tbowen>();

	// Constructors

	/** default constructor */
	public TAdmin() {
	}
	
	public TAdmin(Integer id, String adminName,String email, String headImg) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.headImg = headImg;
		this.email=email;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	@Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Long getAdminLastLoginTime() {
		return this.adminLastLoginTime;
	}

	public void setAdminLastLoginTime(Long adminLastLoginTime) {
		this.adminLastLoginTime = adminLastLoginTime;
	}
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setBowens(Set<Tbowen> bowens) {
		this.bowens = bowens;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Tbowen.class)
	@Cascade(CascadeType.SAVE_UPDATE)
	@ContainedIn
	@JoinColumn(name = "fk_adminId", referencedColumnName = "id")
	public Set<Tbowen> getBowens() {
		return bowens;
	}
	
}