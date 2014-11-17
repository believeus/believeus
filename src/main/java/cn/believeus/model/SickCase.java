package cn.believeus.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * 病人病例
 */
@Entity
@Table(name="TSickCase")
public class SickCase implements Serializable{

	private static final long serialVersionUID = 5670468182796166694L;
	private Integer id;
	// 病症描述
	private String description;
	// 病例状态 0:正常 1:封禁
	private Short status;
	// 是否解决(0:未解决 1:解决)
	private Short solve;
	// 病例创建时间
	private Long createDate;
	// 同一个人发送多个病例
	// 一对多关系
	private TSicker sicker;
	private TDoctor doctor;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	
	public Short getSolve() {
		return solve;
	}
	public void setSolve(Short solve) {
		this.solve = solve;
	}
	@ManyToOne(targetEntity=Tuser.class)
	@JoinColumn(name="fk_sickerId",referencedColumnName="id")
	public TSicker getSicker() {
		return sicker;
	}
	public void setSicker(TSicker sicker) {
		this.sicker = sicker;
	}
	/*public Tuser getUser() {
		return user;
	}
	public void setUser(Tuser user) {
		this.user = user;
	}*/
	// 多个病例对应一个医生
	@ManyToOne
	@JoinColumn(name="fk_doctorId",referencedColumnName="id")
	public TDoctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(TDoctor doctor) {
		this.doctor = doctor;
	}
	
}
