package cn.believeus.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author httpd3
 * 
 */
@Entity
@Table(name = "Tmodule")
public class Tmodule implements Serializable {
	private static final long serialVersionUID = 1762989171385260190L;
	private Integer id;
	private String name;
	// 模块描述
	private String description;
	public Tmodule() {
	}
	
	public Tmodule(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Tmodule(Integer id,String name){
		this.id=id;
		this.name=name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
