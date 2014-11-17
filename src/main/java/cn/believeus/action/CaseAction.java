package cn.believeus.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.believeus.global.BelieveusGlobal;
import cn.believeus.model.TCases;
import cn.believeus.service.CaseService;

@Controller
public class CaseAction {
	@Resource
	CaseService casesService;

	public CaseService getCasesService() {
		return casesService;
	}

	public void setCasesService(CaseService casesService) {
		this.casesService = casesService;
	}

	@RequestMapping(value = "/casesIndex")
	public String casesIndex(HttpServletRequest request) {
		int perPageCount = BelieveusGlobal.perPageCount;
		StringBuilder hql = new StringBuilder("select count(*) from TCases");
		Long totalCount = casesService.getTCasesCount(hql.toString());
		if (totalCount.intValue() > 0) {
			request.setAttribute("casesCount", totalCount.intValue());
			String select_hql = "From TCases";
			int currentPage = 1;
			List<TCases> casesList = casesService.getPageDateList(select_hql,
					currentPage, perPageCount, totalCount.intValue());
			request.setAttribute("casesList", casesList);
		}
		return "/jsp/cases/casesList.jsp";
	}

	// /casesDetail-id-${cases.id}.jhtml
	@RequestMapping("/casesDetail-id-{id:[0-9]+}")
	public String casesDetail(@PathVariable(value="id") Integer id,
			HttpServletRequest request) {
		TCases cases = casesService.findTCasesById(TCases.class, id);
		request.setAttribute("cases", cases);
		return "/jsp/cases/casesDetail.jsp";
	}

	@RequestMapping("/subCasesAjaxList-pageId-{pageIndex:[0-9]+}")
	public String subCasesAjaxList(@PathVariable(value="pageIndex") Integer pageIndex,
			HttpServletRequest request) {
		StringBuilder hql = new StringBuilder("select count(*) from TCases");
		Long totalCount = casesService.getTCasesCount(hql.toString());
		if (totalCount.intValue()>0) {
			int perPageCount = BelieveusGlobal.perPageCount;
			List<TCases> subYianList = casesService.getPageDateList(hql.toString(),
					pageIndex, perPageCount, totalCount.intValue());
			request.setAttribute("subYianList", subYianList);
		}
		return "/jsp/cases/subCasesList.jsp";
	}
}
