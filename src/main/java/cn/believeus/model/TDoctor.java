package cn.believeus.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="TDoctor")
public class TDoctor extends Tuser implements Serializable{
	private static final long serialVersionUID = 5758741592904899605L;
	private String licenceID;
	
	// 简介
	private String introduction;
	// 医生的病人多对多关系
	private Set<TSicker> sickers=new HashSet<TSicker>();
	// 医生的医案
	private Set<TCases> cases=new HashSet<TCases>();
	// 医生和医生等级一对一关系
	private DrLevel drLevel;
	// 医生会有多个病人病例
	private Set<SickCase> sickCases=new HashSet<SickCase>();
	// 医生会写一些博文
	private Set<Tbowen> bowens=new HashSet<Tbowen>();
	public TDoctor() {
	}
	
	
	public String getLicenceID() {
		return licenceID;
	}
	public void setLicenceID(String licenceID) {
		this.licenceID = licenceID;
	}
	
	/**
	 * 一对一双向外键关联
	 */
	@OneToOne(mappedBy="doctor")
	public DrLevel getDrLevel() {
		return drLevel;
	}
	public void setDrLevel(DrLevel drLevel) {
		this.drLevel = drLevel;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public void setSickers(Set<TSicker> sickers) {
		this.sickers = sickers;
	}

	
	public void setCases(Set<TCases> cases) {
		this.cases = cases;
	}

	
	@OneToMany(mappedBy="doctor")
	public Set<TCases> getCases() {
		return cases;
	}
	@ManyToMany
	@JoinTable(name = "t_sick_doctor",
    joinColumns = { @JoinColumn(name = "fk_doctorId", referencedColumnName = "id") }, 
    inverseJoinColumns = { @JoinColumn(name = "fk_sickerId", referencedColumnName = "id") })
	public Set<TSicker> getSickers() {
		return sickers;
	}

	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Tbowen.class)
	@JoinColumn(name="fk_doctorId",referencedColumnName="id")
	public Set<SickCase> getSickCases() {
		return sickCases;
	}

	public void setSickCases(Set<SickCase> sickCases) {
		this.sickCases = sickCases;
	}
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Tbowen.class)
	@JoinColumn(name="fk_doctorId",referencedColumnName="id")
	public Set<Tbowen> getBowens() {
		return bowens;
	}

	public void setBowens(Set<Tbowen> bowens) {
		this.bowens = bowens;
	}

	
}
