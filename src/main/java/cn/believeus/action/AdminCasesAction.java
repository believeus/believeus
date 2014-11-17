package cn.believeus.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.believeus.global.BelieveusGlobal;
import cn.believeus.model.TAdmin;
import cn.believeus.model.TCases;
import cn.believeus.service.CaseService;

/**
 * @author wuqiwei
 * 
 */
@Controller
public class AdminCasesAction {
	@Resource
	CaseService casesService;

	public CaseService getCasesService() {
		return casesService;
	}

	public void setCasesService(CaseService casesService) {
		this.casesService = casesService;
	}

	/**
	 * 后台医案添加/编辑页面
	 */
	@RequestMapping(value = "/adminNewCasesView")
	public String adminNewCasesView(HttpServletRequest request) {
		return "/WEB-INF/superadmin/Cases/newCases.jsp";
	}

	/**
	 * 保存医案
	 */
	@RequestMapping("adminSaveCases")
	public String adminSaveCases(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("editorValue");
		TCases cases = new TCases();
		cases.setStatus(BelieveusGlobal.NormalStatus);
		cases.setTitle(title);
		cases.setContent(content);
		cases.setEditDate(System.currentTimeMillis());
		TAdmin admin = (TAdmin) session
				.getAttribute(BelieveusGlobal.SessionAdmin);
		cases.setAuthor(admin.getAdminName());
		casesService.saveOrUpdateCases(cases);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;

	}

	/**
	 * 后台医案的首页面
	 */
	@RequestMapping(value = "/adminCasesIndex")
	public String adminCasesIndex(HttpServletRequest request) {
		String hql = "select count(*) From TCases";
		// 编辑条数据跳转到该条数据的所在页
		Integer currentPage=(Integer) request.getAttribute("currentPage");
		if (currentPage == null) {
			currentPage = 1;
		}
		int perPageCount = BelieveusGlobal.adminCasesPerCount;
		Long casesCount = casesService.getTCasesCount(hql.toString());
		request.setAttribute("casesCount", casesCount.intValue());
		request.setAttribute("currentPage", currentPage);
		if (casesCount.intValue() > 0) {
			hql = "From TCases";
			List<TCases> casesliList = casesService.getPageDateList(hql,
					currentPage, perPageCount, casesCount.intValue());
			request.setAttribute("casesliList", casesliList);
		}
		return "/WEB-INF/superadmin/Cases/casesList.jsp";
	}

	@RequestMapping("/adminSubCasesAjaxList-pageId-{pageIndex:[0-9]+}")
	public String subCasesAjaxList(@PathVariable(value="pageIndex") Integer pageIndex,
			HttpServletRequest request) {
		StringBuilder hql = new StringBuilder("select count(*) from TCases");
		Long totalCount = casesService.getTCasesCount(hql.toString());
		if (totalCount.intValue() > 0) {
			int perPageCount = BelieveusGlobal.adminCasesPerCount;
			String selectHql = "From TCases";
			List<TCases> subCasesList = casesService.getPageDateList(selectHql,
					pageIndex, perPageCount, totalCount.intValue());
			request.setAttribute("subCasesList", subCasesList);
			request.setAttribute("currentPage", pageIndex);
		}
		return "/WEB-INF/superadmin/Cases/subCasesList.jsp";
	}

	/**
	 * 
	 */
	@RequestMapping("adminDeleteCases-id-{id:[0-9]+}-currPage-{currentPage:[0-9]+}")
	public String deleteCasesById(@PathVariable(value="id") Integer id,
			@PathVariable(value="currentPage") Integer currentPage, HttpServletRequest request) {
		String hql="Delete From TCases where id='"+id+"'";
		casesService.deleteCasesByHql(hql);
		return subCasesAjaxList(currentPage, request);
	}

	/**
	 * 显示编辑页面
	 */
	// /adminCasesEdit-id-${cases.id}-currpage-${currentPage}.jhtml
	@RequestMapping("adminCasesEdit-id-{id:[0-9]+}-currpage-{currpage:[0-9]+}")
	public String adminCasesEditView(@PathVariable(value="id") Integer id,
			HttpServletRequest request, @PathVariable(value="currpage") Integer currpage) {
		TCases cases = casesService.findTCasesById(TCases.class, id);
		request.setAttribute("currPage", currpage);
		request.setAttribute("cases", cases);
		return "/WEB-INF/superadmin/Cases/editCases.jsp";
	}

	@RequestMapping("adminSaveCasesEdit-id-{id:[0-9]+}-currPage-{currentPage:[0-9]+}")
	public String adminSaveCasesEdit(HttpServletRequest request,@PathVariable(value="id") Integer id,@PathVariable(value="currentPage") Integer currentPage){
		HttpSession session = request.getSession();
		TCases cases = casesService.findTCasesById(TCases.class, id);
		String title = request.getParameter("title");
		String content = request.getParameter("editorValue");
		cases.setTitle(title);
		cases.setContent(content);
		cases.setEditDate(System.currentTimeMillis());
		TAdmin admin = (TAdmin) session.getAttribute(BelieveusGlobal.SessionAdmin);
		cases.setAuthor(admin.getAdminName());
		casesService.saveOrUpdateCases(cases);
		request.setAttribute("currentPage", currentPage);
		return adminCasesIndex(request);
	}
}
