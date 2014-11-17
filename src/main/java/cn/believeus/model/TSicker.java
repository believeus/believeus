package cn.believeus.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table
public class TSicker extends Tuser implements Serializable {

	private static final long serialVersionUID = -7585100364146033198L;
	private Set<TDoctor> doctors = new HashSet<TDoctor>();
	// 一对多 一个用户可以发生多个病例
	private Set<SickCase> sickCases = new HashSet<SickCase>();

	@ManyToMany(mappedBy = "sickers", fetch = FetchType.EAGER)
	@BatchSize(size = 5)
	public Set<TDoctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<TDoctor> doctors) {
		this.doctors = doctors;
	}
	@OneToMany(fetch = FetchType.EAGER, targetEntity = SickCase.class)
	@BatchSize(size = 5)
	@JoinColumn(name = "fk_sickerId", referencedColumnName = "id")
	public Set<SickCase> getSickCases() {
		return sickCases;
	}

	public void setSickCases(Set<SickCase> sickCases) {
		this.sickCases = sickCases;
	}

}
