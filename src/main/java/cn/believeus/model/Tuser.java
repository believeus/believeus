package cn.believeus.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.wltea.analyzer.lucene.IKAnalyzer;

@Indexed
@Entity
@Table(name = "TUser")
/*使用继承关系创建子类表*/
@Inheritance(strategy=InheritanceType.JOINED)
public class Tuser implements Serializable{
	// 正常用户
	public static final Short statusNormal=0;
	// 封禁用户
	public static final Short statusBanner=1;
	// 恢复成普通用户
	public static final Short applyNomal=0;
	// 推荐成为管理员
	public static final Short applyRecommend = 1;
	// 用户确定申请
	public static final Short applySubmit = 2;
	// 成为believe-us管理员
	public static final Short applyBeAdmin = 3;
	private static final long serialVersionUID = -8573870765776176531L;
	private Integer id;
	private String nickName;
	private String email;
	private String password;
	private String sex;
	private String headImg;
	private Long lastLoginTime;
	private Long regTime;
	private Short status;
	private Long adminEditDate;
	private String photoNum;
	private String address;
	// 申请管理员状态 1 后台提供申请接口，2 用户提交申请 ，3 admin审核通过，该用户成为管理员
	private Short applyStatus;
	
	// 一对多 一个用户可以写多个bowen
	private Set<Tbowen> bowens = new HashSet<Tbowen>();

	// Constructors

	public Tuser() {
	}

	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Field(store = Store.YES, index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class))
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Field(store = Store.YES, index = Index.TOKENIZED)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Long regTime) {
		this.regTime = regTime;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Long getAdminEditDate() {
		return this.adminEditDate;
	}

	public void setAdminEditDate(Long adminEditDate) {
		this.adminEditDate = adminEditDate;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(String photoNum) {
		this.photoNum = photoNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(columnDefinition = "smallint(6) default 0 ")
	public Short getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Short applyStatus) {
		this.applyStatus = applyStatus;
	}


	// 如果Set<Tbowen>集合中不是泛型，targetEntity = Tbowen.class指定
	//@OneToMany(fetch = FetchType.EAGER, targetEntity = Tbowen.class)
	@OneToMany(fetch = FetchType.EAGER)
	@BatchSize(size = 5)
	@JoinColumn(name = "fk_userId", referencedColumnName = "id")
	public Set<Tbowen> getBowens() {
		return bowens;
	}

	public void setBowens(Set<Tbowen> bowens) {
		this.bowens = bowens;
	}

}