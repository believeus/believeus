package cn.believeus.action;

import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.believeus.common.email.MailBean;
import cn.believeus.common.email.MailSenderTemplete;
import cn.believeus.form.StudentCommonForm;
import cn.believeus.model.TAdmin;
import cn.believeus.model.TNotice;
import cn.believeus.model.Tuser;
import cn.believeus.service.AdminService;
import cn.believeus.service.NoticeService;
import cn.believeus.service.BaseService;

public class AdminUserAction extends DispatchAction {
	@Resource
	private BaseService userService;
	@Resource
	private AdminService adminService;
	@Resource
	private NoticeService noticeService;
	@Resource
	private MailSenderTemplete mailSenderTemplete;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}

	// 后台用户管理主界面
	public ActionForward adminUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String currentPage = request.getParameter("currentPage");
		// 获取所有用户个数。
		String hql="select count(*) from Tuser";
		Long totalCount = userService.getUserCount(hql);
		if (totalCount > 0) {
			hql = "select user from Tuser user order by id desc";
			List<Tuser> studentList = null;
			if (currentPage == null || currentPage.equals("")) {
				studentList = userService.getPageDateList(hql, 1, 15,
						totalCount.intValue());
				request.setAttribute("currentPage", 1);
			} else {
				studentList = userService.getPageDateList(hql,
						Integer.parseInt(currentPage), 15,
						totalCount.intValue());
				request.setAttribute("currentPage", currentPage);
			}
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("studentList", studentList);
			// 获取所有的用户
			if (currentPage != null && Integer.parseInt(currentPage) >= 1) {
				return mapping.findForward("ajaxSubUserList");
			}
		}
		return mapping.findForward("index");
	}

	// 获取用户信息。
	public ActionForward userInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer userId = Integer.parseInt(request.getParameter("uid"));
		Tuser user = userService.getUserById(Tuser.class, userId);
		request.setAttribute("user", user);
		return mapping.findForward("viewUser");
	}
	public ActionForward mail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("mail");
	}

	// 删除用户
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Hibernate 就是要让你不用SQL语句操作数据库而是用对象去操控数据库
		Tuser student = new Tuser();
		Integer userId = Integer.parseInt(request.getParameter("uid"));
		student.setId(userId);
		userService.deletUser(student);
		// 获取上一次的链接地址
		return adminUser(mapping, form, request, response);
	}

	// 修改用户状态
	public void changeUserStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = new PrintWriter(response.getOutputStream());
		String uid = request.getParameter("uid");
		String status = request.getParameter("ustatus");
		if (status.equals("0")) {
			status = "1";
		} else if (status.equals("1")) {
			status = "0";
		}
		/*Begin Name:wuqiwei Date:2013-10-28 23:05:01 BugRepire:添加管理员编辑时间*/
		Long adminEditDate=System.currentTimeMillis();
		String hql = "update Tuser user set user.status='" + status
				+ "' ,adminEditDate='"+adminEditDate+"'"+" where user.id='" + uid + "'";
		userService.saveOrUpdateByHQL(hql);
		/*End Name:wuqiwei Date:2013-10-28 23:05:01 BugRepire:添加管理员编辑时间*/
		Integer ustatus = Integer.parseInt(status);
		if (ustatus == 0) {
			status = "\"正常\"";
		} else if (ustatus == 1) {
			status = "\"封禁\"";
		} else {
			status = "\"推荐\"";
		}
		String existInfo = "{\"value\":" + status + "}";
		writer.println(existInfo);
		writer.close();
	}

	// 批量删除用户
	public ActionForward batchProcessDelect(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String stuIds = request.getParameter("uid");
		String hql="delete from Tuser stu where stu.id in ("+stuIds+")";
		userService.deletUserByHQL(hql);
		// 获取上一次的链接地址
		String refererURI = request.getHeader("Referer");
		return new ActionForward(refererURI, true);
	}

	// 批量用户正常
	public void batchProcessuseNormal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		batchProcessuse(mapping, form, request, response, "1", "0", "正常");
	}

	// 批量用户封禁
	public void batchProcessuseBan(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		batchProcessuse(mapping, form, request, response, "0", "1", "封禁");
	}

	// 批量处理公共方法。
	public void batchProcessuse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			String positive, String anti, String data) throws Exception {
		/*
		 * positive：第五个参数表示用户状态， anti：第六个参数表示用户要改变的状态， data：第七个参数表示要返回的状态的文字显示。
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = new PrintWriter(response.getOutputStream());
		String uid = request.getParameter("uid");
		String status = request.getParameter("ustatus");
		// 把用户状态变为相反的状态。
		if (status.equals(positive)) {
			status = anti;
		}
		String hql = "update Tuser student set student.status='" + status
				+ "'  where student.id='" + uid + "'";
		userService.saveOrUpdateByHQL(hql);
		String existInfo = "{\"value\":\"" + data + "\"}";
		writer.println(existInfo);
		writer.close();
	}
	//简单搜索。
	public ActionForward SearchUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StudentCommonForm myForm = (StudentCommonForm) form;
		StringBuilder hql = new StringBuilder();
		hql.append("FROM Tuser stu where stu.id>0");
		if (myForm.getEmail().equals("") && myForm.getId() == 0
				&& myForm.getNickName().equals("")) {
			// 判断邮箱、id、名字 是否为空。
			return mapping.findForward("index");
		}
		if (!myForm.getEmail().equals("")) {
			hql.append("  and stu.email='"+myForm.getEmail()+"'");
		}
		if (!myForm.getNickName().equals("")) {
			hql.append("  and stu.nickName='"+myForm.getNickName()+"'");
		}
		if (myForm.getId() != 0) {
			hql.append("  and stu.id='"+myForm.getId()+"'");
		}
		List<Tuser> studentList = userService.getUserList(hql, null);
		request.setAttribute("studentList", studentList);
		return mapping.findForward("index");
	}
	/*Begin Name:wuqiwei Date:2013-10-28 23:13:11 AddReason:管理员申请*/
	public ActionForward adminApply(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("uid"));
		Short applyStatus=Short.parseShort(request.getParameter("applyStatus"));
		Tuser user = userService.getUserById(Tuser.class, id);
		user.setApplyStatus(applyStatus);
		userService.saveOrUpdateByUser(user);
		// 变成普通用户
		if (applyStatus==Tuser.applyNomal) {
			String hql="Delete from TAdmin where email='"+user.getEmail()+"'";
			userService.deletUserByHQL(hql);
		}else if(applyStatus==Tuser.applyBeAdmin) {
			TAdmin admin=new TAdmin();
			admin.setEmail(user.getEmail());
			admin.setAdminName(user.getNickName());
			admin.setAdminPassword("believeus");
			admin.setHeadImg(user.getHeadImg());
			adminService.saveOrUpdate(admin);
			/*Begin Name:wuqiwei Date:2013-11-5 07:43:26 AddReason:保存站内信*/
			TNotice notice=new TNotice();
			notice.setTitle("管理员申请成功");
			notice.setContent("您后台的登录帐号为:"+admin.getEmail()+",您的登录密码为:"+admin.getAdminPassword()+"。已将您的帐号和密码发送到了您的"+admin.getEmail()+"邮箱,请查收");
			notice.setUser(user);
			noticeService.saveNotice(notice);
			/*End Name:wuqiwei Date:2013-11-5 07:43:26 AddReason:保存站内信*/
			MailBean mail = new MailBean();
			mail.setEmailTo(admin.getEmail());
			mail.setEmailTitle("感谢您对我们网站的关注");
			mail.setEmailContent("您后台的登录帐号为:"+admin.getEmail()+",您的登录密码为:"+admin.getAdminPassword());
			mailSenderTemplete.sendMail(mail);
		}
		return new ActionForward("/adminViewUser-uid-"+id+".html",true);
	}
	/*End Name:wuqiwei Date:2013-10-28 23:13:11 AddReason:管理员申请*/
		
}