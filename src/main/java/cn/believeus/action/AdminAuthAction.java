package cn.believeus.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminAuthAction {
	private static Log log=LogFactory.getLog(AdminAuthAction.class);
	/**
	 * 后台权限管理主界面
	 */
	public AdminAuthAction() {
		log.debug("AdminPrivilegeAction init");
	}
	@RequestMapping(value = "/adminAuth")
	public String adminPrivilegeIndex(HttpServletRequest request) {
		log.debug("forward:/WEB-INF/superadmin/AdminAuth/index.jsp");
		return "/WEB-INF/superadmin/AdminAuth/index.jsp";
	}



}
