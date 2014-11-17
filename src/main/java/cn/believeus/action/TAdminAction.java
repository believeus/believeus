package cn.believeus.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.believeus.form.TAdminLoginForm;
import cn.believeus.model.TAdmin;
import cn.believeus.service.AdminService;

public class TAdminAction {
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(TAdminAction.class);
	@Resource
	private AdminService adminService;

	// 检查管理员登录。
	public ActionForward AdminloginCheck(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TAdminLoginForm tAdminLoginForm = (TAdminLoginForm) form;
		// 根据名字获取用户对象
		String hql = "FROM TAdmin admin WHERE admin.adminName='"
				+ tAdminLoginForm.getAdminName() + "'";
		TAdmin admin = adminService.findAdminByHQL(hql);
		if (admin == null) {
			return mapping.findForward("index");
		}
		String stuPassword = admin.getAdminPassword();
		// 使用密码是否相同比较
		if (stuPassword.equals(tAdminLoginForm.getAdminPassword())) {
			// 跳转到首页面
			return mapping.findForward("index");
		} else {
			return mapping.findForward("error");
		}
	}
}