package cn.believeus.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.believeus.global.BelieveusGlobal;
import cn.believeus.model.TAdmin;
import cn.believeus.model.Tbowen;
import cn.believeus.service.BaseService;
import cn.believeus.service.BowenService;

@Transactional
public class AdminBowenAction extends DispatchAction {
	private BaseService baseService;

	public BowenService getBowenService() {
		return bowenService;
	}

	@Resource(name = "bowenService")
	public void setBowenService(BowenService bowenService) {
		this.bowenService = bowenService;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	};

	// 博文后台管理
	public ActionForward adminBowen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("adminBowen");
	}

	// 获得博文列表
	public ActionForward bowenList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取游戏总个数
		String hql = "select count(*) from Tbowen";
		Long totalCount = bowenService.getBowenCount(hql);
		if (totalCount > 0) {
			hql = "select bowen from Tbowen bowen order by editDate desc";
			// 获取第一页的笑话数据 每页5条数据必须和前台的分页器保持一致
			int currentPage = 1;
			List<Tbowen> bowenList = bowenService.getPageDateList(hql,
					currentPage, BelieveusGlobal.adminBowenPerCount,
					totalCount.intValue());
			request.setAttribute("bowenCount", totalCount);
			request.setAttribute("bowenList", bowenList);
			request.setAttribute("currentPage", currentPage);
		}
		return mapping.findForward("bowenList");
	}

	// 分页获得博文列表
	public ActionForward ajaxBowenList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取游戏总个数
		String hql = "select count(*) from Tbowen";
		Long totalCount = bowenService.getBowenCount(hql);
		if (totalCount > 0) {
			hql = "from Tbowen order by editDate desc";
			// 获取第一页的笑话数据 每页5条数据必须和前台的分页器保持一致
			String pageId = request.getParameter("pageId");
			int currentPage = Integer.parseInt(pageId);
			List<Tbowen> bowenList = bowenService.getPageDateList(hql,
					currentPage, BelieveusGlobal.adminBowenPerCount,
					totalCount.intValue());
			request.setAttribute("bowenCount", totalCount);
			request.setAttribute("bowenList", bowenList);
			request.setAttribute("currentPage", currentPage);
		}
		return mapping.findForward("ajaxBowenList");
	}

	// 新建博文界面
	public ActionForward saveNewBowenView(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return mapping.findForward("bowenNewView");
	}

	// 保存新建的博文
	public ActionForward saveNewBowen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("editorValue");
		String refererURL = request.getHeader("Referer");
		Tbowen bowen = new Tbowen();
		bowen.setTitle(title);
		bowen.setContent(content);
		bowen.setEditDate(System.currentTimeMillis());
		TAdmin admin = (TAdmin) request.getSession().getAttribute(
				BelieveusGlobal.SessionAdmin);
		bowen.setAdmin(admin);
		bowenService.savaOrUpdateTBowen(bowen);
		return new ActionForward(refererURL, true);
	}

	// 编辑博文界面
	public ActionForward bowenEditView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String Jid = request.getParameter("Jid");
		Tbowen tbowen = bowenService.getTBowenById(Integer.parseInt(Jid));
		String refererURL = request.getHeader("Referer");
		request.setAttribute("Jid", Jid);
		request.setAttribute("refererURL", refererURL);
		request.setAttribute("bowen", tbowen);
		return mapping.findForward("saveEditBowenView");
	}

	// 保存编辑的博文
	public ActionForward saveEditBowen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("Jid");
		String title = request.getParameter("title");
		String content = request.getParameter("editorValue");
		String refererURL = request.getParameter("refererURL");
		Tbowen bowen = bowenService.getTBowenById(Integer.parseInt(id));
		TAdmin admin = (TAdmin) request.getSession().getAttribute(
				BelieveusGlobal.SessionAdmin);
		bowen.setTitle(title);
		bowen.setContent(content);
		bowen.setEditDate(System.currentTimeMillis());
		bowen.setAdmin(admin);
		bowenService.savaOrUpdateTBowen(bowen);
		return new ActionForward(refererURL, true);
	}

	// 删除博文界面
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {
			Exception.class, RuntimeException.class })
	public ActionForward deleteBowen(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String Jid = request.getParameter("Jid");
		String hql = ("delete from Tbowen bowen where bowen.id='" + Jid + "'");
		bowenService.deleteBowen(hql);
		// 获取笑话列表
		return bowenList(mapping, form, request, response);
	}

	// 博文详细页面
	public ActionForward bowenDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String jId = request.getParameter("jId");
		Tbowen bowen = bowenService.getTBowenById(Integer.parseInt(jId));
		request.setAttribute("bowen", bowen);
		return mapping.findForward("bowenDetail");
	}
}
