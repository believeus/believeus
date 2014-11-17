package cn.believeus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TRole")
public class TRole implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public static final String ViewAndEditRole="View:Edit";
	public static final String ViewRole="View";
	private Integer id;
	/** 角色名 */
	private String name;

	/** 角色描述 */
	private String description;

	/** 一个角色有多个权限 */
	private List<String> authorities = new ArrayList<String>();
	public TRole() {
	}
	
	public TRole(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TRole(Integer id, String name, String description,List<String> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.authorities = authorities;
	}
	
	public TRole(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	/**
	 * 当前角色和权限是一对多的关系
	 */
	@ElementCollection
	@CollectionTable(name = "role_authority")
	public List<String> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}
}
