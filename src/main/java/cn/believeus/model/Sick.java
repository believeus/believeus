package cn.believeus.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.believeus.model.SickCategory;

/*Begin Author:wuqiwei Date:2014-04-06 AddReason:疾病*/
@Entity
@Table(name = "TSick")
public class Sick implements Serializable {

	private static final long serialVersionUID = -5411772720560729805L;
	private int id;
	private String name;
	private List<SickCategory> sickCategory;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false,columnDefinition="varchar(30) comment '疾病名称'")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*不加@ManyToOne(targetEntity=SickCategory.class)注解
	 * 会报org.hibernate.AnnotationException: 
	 * @OneToOne or @ManyToOne on cn.believeus.model.sickCategory 
	 * references an unknown entity: java.util.List*/
	@ManyToOne(targetEntity=SickCategory.class)
	@JoinColumn(name="fk_sick_categoryId",referencedColumnName="id")
	public List<SickCategory> getSickCategory() {
		return sickCategory;
	}

	public void setSickCategory(List<SickCategory> sickCategory) {
		this.sickCategory = sickCategory;
	}
	
	
	
}
