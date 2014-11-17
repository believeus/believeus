package cn.believeus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;
import org.wltea.analyzer.lucene.IKAnalyzer;


@Entity
@Indexed
@Table(name="TBowen")
public class Tbowen implements Serializable{

	// Fields
	private static final long serialVersionUID = 3602154568580768633L;
	private Integer id;
	private String title;
	private String content;
	private Long editDate;
	private Integer replyNum;
	private Short status;
	private Integer clickNum;
	private TAdmin admin;
	private TDoctor doctor;

	// Constructors

	/** default constructor */
	public Tbowen() {
	}
	
	public Tbowen(Integer id, String title, String content, Long editDate,
			Integer replyNum, Short status, Integer clickNum, TAdmin admin,TDoctor doctor) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.editDate = editDate;
		this.replyNum = replyNum;
		this.status = status;
		this.clickNum = clickNum;
		this.admin = admin;
		this.doctor=doctor;
	}

	/** full constructor */

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/*@DocumentId改值必须要,为每一个索引创建一个documentid对应数据库中的id.原理是当store=Store.NO的时候
	 * 会根据documentid去查找数据中的id填充该store=Store.NO的值
	 * 原理：
	 * /*
	 * Note :无论store=Store.NO还是store=Store.YES都不会影响最终的搜索能力。
	 * store.YES的作用是可以在搜索后可以直接从索引中获取域的完整值。
	 * 在hibernate中,如果store=Store.NO,搜索结果中，域的值是通过数据库中获取，
	 * 如果store=Store.YES，域的值是直接从索引文档中获取
	 * */
	@DocumentId
	@Field(store=Store.YES)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(nullable=false)
	@Field(store=Store.YES,index = Index.NO, analyzer = @Analyzer(impl =IKAnalyzer.class ))
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	/*Begin Author:wuqiwei Date:2014-03-29 AddReason:让Sting映射mysql的text文本类型*/
	@Column(columnDefinition="text comment '文章内容'")
	/*End Author:wuqiwei Date:2014-03-29 AddReason:让Sting映射mysql的text文本类型*/
	/*
	 * Note :无论store=Store.NO还是store=Store.YES都不会影响最终的搜索能力。
	 * store.YES的作用是可以在搜索后可以直接从索引中获取域的完整值。
	 * 在hibernate中,如果store=Store.NO,搜索结果中，域的值是通过数据库中获取，
	 * 如果store=Store.YES，域的值是直接从索引文档中获取
	 * */
	@Field(store=Store.NO,index = Index.TOKENIZED, analyzer = @Analyzer(impl = IKAnalyzer.class ))
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	public void setEditDate(Long editDate) {
		this.editDate = editDate;
	}

	@Column(nullable = false,columnDefinition="bigint comment '博文的编辑时间'")
	public Long getEditDate() {
		return editDate;
	}

	
	@Column(columnDefinition = "smallint default 0")
	public Integer getReplyNum() {
		return this.replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

	/*Begin Author:wuqiwei Date:2014-03-29  AddReason:设置默认值。注意：这时数据库类型一定要自己指定，Hibernate不会再为你指定数据库列的类型。如果没指定，在hbm2dll时就会抛出异常*/
	@Column(columnDefinition = "smallint default 0 COMMENT '文章的状态 0：正常 1:封禁'")
	/*End Author:wuqiwei Date:2014-03-29  AddReason:设置默认值。注意：这时数据库类型一定要自己指定，Hibernate不会再为你指定数据库列的类型。如果没指定，在hbm2dll时就会抛出异常*/
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
	/*Begin Author:wuqiwei Date:2014-03-29  AddReason:设置默认值。注意：这时数据库类型一定要自己指定，Hibernate不会再为你指定数据库列的类型。如果没指定，在hbm2dll时就会抛出异常*/
	@Column(columnDefinition = "int default 0 COMMENT '博文的点击次数'")
	/*End  Author:wuqiwei Date:2014-03-29  AddReason:设置默认值。注意：这时数据库类型一定要自己指定，Hibernate不会再为你指定数据库列的类型。如果没指定，在hbm2dll时就会抛出异常*/
	public Integer getClickNum() {
		return this.clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	@ManyToOne(fetch=FetchType.EAGER)//多对一的时候可以获取admin对象
	@JoinColumn(name="fk_adminId",referencedColumnName="id")// 会在多的一端生成fk_adminId 和 id对应的是数据库字段
	@IndexedEmbedded
	public TAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(TAdmin admin) {
		this.admin = admin;
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