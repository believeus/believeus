package cn.believeus.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * 医生评价等级
 * 这就是在限制医生的医德，负责的为病人解决问题
 */
@Entity
@Table(name = "TDrLevel")
public class DrLevel implements Serializable {
	private static final long serialVersionUID = 3344244619653411362L;
	private Integer id;
	// 技能等级
	private Integer skillLevel;
	// 耐心等级
	private Integer patientLevel;
	// 收费等级
	private Integer chargeLevel;
	// 印象分
	private Integer senseLevel;
	// 成功率:直接和病案成功率有关
	private Integer successRate;
	// 医生的责任感等级
	private Integer dutyLevel;
	// 医生的敬业等级
	private Integer devotionLevel;
	// 医生的职业道德
	private Integer moralLevel;
	// 分析病情，病人的采纳率
	private Integer acceptionLevel;
	// 医生回答问题的活跃度由病人去评定
	private Integer ativityLevel;
	// 医生等级和医生是一对一的关系
	private TDoctor doctor;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}


	public Integer getPatientLevel() {
		return patientLevel;
	}

	public void setPatientLevel(Integer patientLevel) {
		this.patientLevel = patientLevel;
	}

	public Integer getChargeLevel() {
		return chargeLevel;
	}

	public void setChargeLevel(Integer chargeLevel) {
		this.chargeLevel = chargeLevel;
	}

	public Integer getSenseLevel() {
		return senseLevel;
	}

	public void setSenseLevel(Integer senseLevel) {
		this.senseLevel = senseLevel;
	}

	public Integer getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(Integer successRate) {
		this.successRate = successRate;
	}
	
	public int getDutyLevel() {
		return dutyLevel;
	}

	public void setDutyLevel(Integer dutyLevel) {
		this.dutyLevel = dutyLevel;
	}

	public int getDevotionLevel() {
		return devotionLevel;
	}

	public void setDevotionLevel(Integer devotionLevel) {
		this.devotionLevel = devotionLevel;
	}

	public Integer getMoralLevel() {
		return moralLevel;
	}

	public void setMoralLevel(Integer moralLevel) {
		this.moralLevel = moralLevel;
	}
	
	public Integer getAcceptionLevel() {
		return acceptionLevel;
	}

	public void setAcceptionLevel(Integer acceptionLevel) {
		this.acceptionLevel = acceptionLevel;
	}
	
	public int getAtivityLevel() {
		return ativityLevel;
	}

	public void setAtivityLevel(Integer ativityLevel) {
		this.ativityLevel = ativityLevel;
	}

	
	/**
	 * 一对一双向外键关联
	 */
	 @OneToOne(cascade=CascadeType.ALL)  
	 @JoinColumn(name="fk_doctorId")  
	public TDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(TDoctor doctor) {
		this.doctor = doctor;
	}
}
