package cn.believeus.form;

import org.apache.struts.action.ActionForm;

public class TAdminLoginForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 419679839890323152L;
	private String adminName;
	private String adminPassword;
	private String adminPurview;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminPurview() {
		return adminPurview;
	}
	public void setAdminPurview(String adminPurview) {
		this.adminPurview = adminPurview;
	}
}
