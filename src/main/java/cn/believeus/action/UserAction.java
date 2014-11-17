package cn.believeus.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.believeus.form.StudentCommonForm;
import cn.believeus.global.BelieveusGlobal;
import cn.believeus.model.Tuser;
import cn.believeus.service.BaseService;

public class UserAction extends DispatchAction {
	private static Log log = LogFactory.getLog(UserAction.class);
	@Resource
	private BaseService userService;

	/*
	 * Begin: Name wuqiwei Data:2013-3-29 AddReason: 解决spring Aop
	 * 不能拦截DispatchAction 重写execute 方法即可
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}

	/*
	 * End: Name wuqiwei Data:2013-3-29 AddReason: 解决spring Aop
	 * 不能拦截DispatchAction 重写execute 方法即可
	 */
	// 添加用户
	public ActionForward addStudent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		StudentCommonForm regForm = (StudentCommonForm) form;
		String hql = "FROM Tuser user WHERE user.email='" + regForm.getEmail()+ "'";
		Tuser stu = userService.getTUserByHQL(hql);
		if (this.isTokenValid(request, true)) { // 表单不是重复提交才可以进行以下操作。
			if (stu == null) {
				Tuser user = new Tuser();
				user.setNickName(regForm.getNickName());
				user.setHeadImg("images/global/userImg.jpg");
				user.setSex("男");
				user.setEmail(regForm.getEmail());
				/*Begin Author:wuqiwei Data:2014-05-23 ModifyReason:使用MD5进行加密学生密码*/ 
				String password =DigestUtils.md5Hex(regForm.getConfirmPwd());
				/*End Author:wuqiwei Data:2014-05-23 ModifyReason:使用MD5进行加密学生密码*/ 
				user.setPassword(password);
				/* Begin Name:wuqiwei Date:2013-10-26 23:18:54 AddReason:添加注册日期 */
				user.setRegTime(System.currentTimeMillis());
				/* End Name:wuqiwei Date:2013-10-26 23:18:54 AddReason:添加注册日期 */
				user.setLastLoginTime(System.currentTimeMillis());
				user.setStatus(new Short("0"));
				// 根据Email获取用户对象是否为空。
				// 该用户是一个新用户，则保存该用户
				log.info("not repeat insert form data,success insert from data");
				userService.saveOrUpdateByUser(user);
				stu = user;
			}
			this.resetToken(request);
			// 将学生保存到session之中
			session.setAttribute(BelieveusGlobal.SessionUser, stu);
			// 保存成功，跳转到index页面。
			return new ActionForward("http://www.believeus.cn/", true);
		} else {
			log.info(" repeat insert form data");
			// 表单重复提交了，直接去到register页面。
			return mapping.findForward("error");
		}
	}
	
	// 登陆检查
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ActionForward loginCheck(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		StudentCommonForm regForm = (StudentCommonForm) form;
		// 根据Email获取用户对象
		String hql="FROM Tuser user WHERE user.email='" + regForm.getEmail()
				+ "'";
		Tuser user = userService.getTUserByHQL(hql);
		if (user == null) {
			return mapping.findForward("inputError");
		}
		String stuPassword = user.getPassword();
		// 使用密码是否相同比较
		String md5FormPassword = DigestUtils.md5Hex(regForm.getUserPwd());
		if (stuPassword.equals(md5FormPassword)) {
			user.setLastLoginTime(System.currentTimeMillis());
			// 更新用户登陆时间
			userService.updataLoginTime(user);
			session.setAttribute(BelieveusGlobal.SessionUser, user);
			// 跳转到首页面
			return new ActionForward("http://www.believeus.cn/", true);
		} else {
			return mapping.findForward("error");
		}
	}

	// 使用ajax验证验证码的正确性
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void ajaxCheckValidateCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		PrintWriter writer = new PrintWriter(out);
		String checkCode = request.getParameter("checkCode");
		/**Begin Author:wuqiwei Data:2014-05-23 AddReason:将map转换成json避免字符拼接成json带来的麻烦*/
		Map<String,Object> map = new HashMap<String,Object>();
		JSONObject json=null;
		// 验证码忽略大小写
		if (checkCode != null
				&& checkCode.equalsIgnoreCase((String) session
						.getAttribute(BelieveusGlobal.validateCode))) {
			map.put("value", "true");
			json = JSONObject.fromObject(map); 
		} else {
			map.put("value", "error");
			json = JSONObject.fromObject(map); 
		}
		/**End Author:wuqiwei Data:2014-05-23 AddReason:将map转换成json避免字符拼接成json带来的麻烦*/
		writer.println(json.toString());
		writer.close();
		out.close();
	}

	// 使用ajax验证邮箱和密码是否有效
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void ajaxCheckUserByEmail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// json 也是字符串类型 形如 var person={'name':'wuqiwei','age',12''}
		// 是JavaScript定义对象的一种方式
		// 如果要返回json数据必须要 response.setContentType("text/html;charset=UTF-8");
		// 如果要返回xml数据必须要response.setContentType("text/xml;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		PrintWriter writer = new PrintWriter(out);
		String userEmail = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		if (userEmail != null) {
			userEmail = URLDecoder.decode(userEmail, "UTF-8");
		}
		// 根据userEmail查询该邮箱的用户是否存在
		String hql="FROM Tuser user WHERE user.email='" + userEmail + "'";
		Tuser student = userService.getTUserByHQL(hql);
		String jsonPwd = "";
		// 根据邮箱判断该用户，null为该用户未注册
		/**Begin Author:wuqiwei Data:2014-05-23 AddReason:将map转换成json避免字符拼接成json带来的麻烦*/
		Map<String,Object> map = new HashMap<String,Object>();
		if (student == null) {
			userEmail = "no";
			// 该用户已经注册
		} else {
			userEmail = "yes";
		}
		if (pwd != null && !pwd.equals("")) {
			String encryptPwd=DigestUtils.md5Hex(pwd);
			// 输入密码有误
			if (student != null && !student.getPassword().equals(encryptPwd)) {
				jsonPwd = "no";
				// 该用户不存在
			} else if (student == null) {
				jsonPwd = "no";
				// 输入密码正确
			} else {
				jsonPwd = "yes";
			}
			// 如果密码没有填写
		} else {
			jsonPwd = "no";
		}
		map.put("email", userEmail);
		map.put("pwd", jsonPwd);
		JSONObject json = JSONObject.fromObject(map); 
		writer.println(json.toString());
		/**End Author:wuqiwei Data:2014-05-23 AddReason:将map转换成json避免字符拼接成json带来的麻烦*/
		writer.close();
		out.close();
	}

	/* Begin Name:wuqiwei Date:2013-10-31 22:32:16 AddReason:用户提交申请管理员 */
	public ActionForward submitApplyAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String uid = request.getParameter("uid");
		Tuser user = userService
				.getUserById(Tuser.class, Integer.parseInt(uid));
		user.setApplyStatus(Tuser.applySubmit);
		userService.saveOrUpdateByUser(user);
		return new ActionForward("http://www.believeus.cn", true);
	}
	/* End Name:wuqiwei Date:2013-10-31 22:32:16 AddReason:用户提交申请管理员 */
}