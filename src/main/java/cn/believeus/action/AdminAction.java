package cn.believeus.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class AdminAction extends DispatchAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}

	// 后台管理主界面
	public ActionForward adminIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("index");
	}

	public ActionForward manageIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("adminManage");
	}
	// 后台欢迎页面
	public ActionForward welcomeIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("adminWelcom");
	}

	// 后台更新信息概要
	public ActionForward summaryIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("adminSummary");
	}
	// 后台管理员退出
	public void adminLogout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		/*Begin Name:wuqiwei Date:2013-12-17 AddReason:管理员退出清空掉验证和权限信息*/
		SecurityUtils.getSubject().logout();
		/*End Name:wuqiwei Date:2013-12-17 AddReason:管理员退出清空掉验证和权限信息*/
		String adminHtml = "<script type=\"text/javascript\">top.location.href=\"http://www.believeus.cn/admin.html\";</script>";
		request.getSession().removeAttribute("SessionCollegeAdmin");
		response.getOutputStream().print(adminHtml);
		return;
	}

}
