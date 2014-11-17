package cn.believeus.action;

import java.util.Calendar;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
// begin  Name:wuqiwei  Data:2013-319 Email:1058633117@qq.com 
// AddReason: 主页面使用index.do的请求实现MVC的效果

import cn.believeus.model.Tuser;
import cn.believeus.service.BaseService;
public class IndexAction extends DispatchAction {
	@Resource
	private BaseService userService;
	public ActionForward index(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*Begin Name:wuqiwei Date:2013-4-2 AddReason:防止表单重复提交*/
		saveToken(request);
		/*End Name:wuqiwei Date:2013-4-2 AddReason:防止表单重复提交*/
		return mapping.findForward("index");
	}
	public ActionForward videoList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("videoList");
	}
	/*Begin: Name wuqiwei Data:2013-3-29 AddReason: 解决spring Aop 不能拦截DispatchAction 重写execute 方法即可*/
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String uid = request.getParameter("uid");
		String hql="From Tuser where id='"+uid+"'";
		Tuser student = userService.getTUserByHQL(hql);
		if (student!=null) {
			Calendar calendar = Calendar.getInstance();
			long lastLoginTime = calendar.getTimeInMillis();
			student.setLastLoginTime(lastLoginTime);
			userService.saveOrUpdateByUser(student);
			request.getSession().invalidate();
		}
		//  将用户的session设置为过期
		return new ActionForward("/index.html",true);
	}
	/*End: Name wuqiwei Data:2013-3-29 AddReason: 解决spring Aop 不能拦截DispatchAction 重写execute 方法即可*/
}
// end  Name:wuqiwei  Data:2013-319 Email:1058633117@qq.com 
//AddReason: 主页面使用index.do的请求实现mvc的效果