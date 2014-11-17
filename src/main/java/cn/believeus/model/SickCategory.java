package cn.believeus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Begin Author:wuqiwei Date:2014-04-06 AddReason:疾病*/
@Entity
@Table(name = "TSickCategory")
public class SickCategory implements Serializable {

	private static final long serialVersionUID = -5411772720560729805L;
	private int id;
	private String name;
	private long cagetoryId;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false,columnDefinition="varchar(30) comment '疾病分类名'")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false,columnDefinition="bigint comment '疾病分类编码'")
	public long getCagetoryId() {
		return cagetoryId;
	}
	public void setCagetoryId(long cagetoryId) {
		this.cagetoryId = cagetoryId;
	}
}
