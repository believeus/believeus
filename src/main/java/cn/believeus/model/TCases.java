package cn.believeus.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*医生的病案*/
@Entity
@Table(name="TCases")
public  class TCases implements Serializable{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4038086859656998019L;
	private Integer id;
	private String title;
	private String content;
	private Long editDate;
	private Short status;
	private Long aditDate;
	private String author;
	private TDoctor doctor;

	// Constructors

	/** default constructor */
	public TCases() {
	}

	/** full constructor */
	

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}



	public TCases(Integer id, String title, String content,
			Long editDate, Short status, Long aditDate, String author,
			TDoctor doctor) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.editDate = editDate;
		this.status = status;
		this.aditDate = aditDate;
		this.author = author;
		this.doctor = doctor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Long editDate) {
		this.editDate = editDate;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Long getAditDate() {
		return this.aditDate;
	}

	public void setAditDate(Long aditDate) {
		this.aditDate = aditDate;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@ManyToOne(targetEntity=TDoctor.class)
	@JoinColumn(name="fk_doctorId",referencedColumnName="id")
	public TDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(TDoctor doctor) {
		this.doctor = doctor;
	}

}