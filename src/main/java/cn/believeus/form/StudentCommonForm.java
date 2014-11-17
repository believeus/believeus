package cn.believeus.form;

import org.apache.struts.action.ActionForm;

public class StudentCommonForm extends ActionForm {
	
	/**
	 * 增加序列化的作用：每一个类都有一个唯一的序列化ID，
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
	 * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。
	 */
	private static final long serialVersionUID = -2359584857333415258L;
	private Integer id;
	private String nickName;
	private String relName;
	private String headImg;
	private String email;
	private String userPwd;
	private String sex; 
	private Long lastLoginTime;
	private Long regTime;
	private Short stuLevel;
	private Short status;
	private Long adminEditDate;
	private String validateCode;
	private String confirmPwd;
	private String province;
	private String city;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Long getRegTime() {
		return regTime;
	}
	public void setRegTime(Long regTime) {
		this.regTime = regTime;
	}
	public Short getStuLevel() {
		return stuLevel;
	}
	public void setStuLevel(Short stuLevel) {
		this.stuLevel = stuLevel;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Long getAdminEditDate() {
		return adminEditDate;
	}
	public void setAdminEditDate(Long adminEditDate) {
		this.adminEditDate = adminEditDate;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}



}