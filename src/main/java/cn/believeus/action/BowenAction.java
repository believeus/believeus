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
import cn.believeus.model.Tbowen;
import cn.believeus.service.BowenService;
import cn.believeus.view.factory.ViewFactory;
@Transactional
public class BowenAction extends DispatchAction {
	BowenService bowenService;
	ViewFactory bowenViewFactory;
	public BowenService getBowenService() {
		return bowenService;
	}
	@Resource(name="bowenService")
	public void setBowenService(BowenService bowenService) {
		this.bowenService = bowenService;
	}
	
	public ViewFactory getBowenViewFactory() {
		return bowenViewFactory;
	}
	@Resource(name="bowenViewFactory")
	public void setBowenViewFactory(ViewFactory bowenViewFactory) {
		this.bowenViewFactory = bowenViewFactory;
	}
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ActionForward bowenIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		// 查看屌丝笑话的个数
		String hql="select count(*) from Tbowen";
		Long bowenCount = bowenService.getBowenCount(hql);
		if (bowenCount>0) {
			String pageId = request.getParameter("pageId");
			if (pageId==null||pageId.equals("")) {
				pageId="1";
			}
			/*Begin Name:wuqiwei Date:2013-08-09 ModifyReason:显示文章优先级为编辑时间然后是点击次数*/
			 hql=("from Tbowen b where b.status !=1 order by b.clickNum,b.editDate desc");
			/*End Name:wuqiwei Date:2013-08-09 ModifyReason:显示文章优先级为编辑时间然后是点击次数*/
			// 获取所有的屌丝笑话
			List<Tbowen> bowenList = bowenService.getPageDateList(hql, Integer.parseInt(pageId)
																				, BelieveusGlobal.perPageCount, bowenCount.intValue());
			request.setAttribute("bowenCount", bowenCount);
			request.setAttribute("bowenList",bowenList);
		}
		/*Begin Name:wuqiwei Date:2013-08-23 AddReason:使用访问者模式解决action逻辑一致而返回视图不同*/
		String bowenIndex = ViewFactory.viewInstance(bowenViewFactory, request, null);
		/*Begin Name:wuqiwei Date:2013-08-23 AddReason:使用访问者模式解决action逻辑一致而返回视图不同*/
		return mapping.findForward(bowenIndex);
	}
	
	// 博文详细页面
		public ActionForward bowenDetail(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String bid = request.getParameter("bid");
			Tbowen bowen = bowenService.getTBowenById(Integer.parseInt(bid));
			/*Begin Name:wuqiwei Date:2013-08-09 AddReason:更新文章的点击次数,根据点击次数来确定显示的优先级*/
			int IncreaseclickNum=bowen.getClickNum()+1;
			bowen.setClickNum(IncreaseclickNum);
			bowenService.savaOrUpdateTBowen(bowen);
			/*Begin Name:wuqiwei Date:2013-08-09 AddReason:更新文章的点击次数,根据点击次数来确定显示的优先级*/
			request.setAttribute("bowen", bowen);
			return mapping.findForward("bowenDetail");
		}
		// 通过分页ajax返回页面
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public ActionForward bowenAjaxList(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response){
			HttpServletRequest req=((HttpServletRequest)request);
			// 查看博文的个数
			String hql="select count(*) from Tbowen";
			Long bowenCount = bowenService.getBowenCount(hql);
			if (bowenCount>0) {
				String pageId = request.getParameter("pageId");
				// 当前页数
				int index= Integer.parseInt(pageId);
				/*Begin Name:wuqiwei Date:2013-08-09 ModifyReason:显示文章优先级为编辑时间然后是点击次数*/
				// 显示不是封禁的中医博文
				hql=("from Tbowen b where b.status !=1 order by b.clickNum,b.editDate desc");
				/*End Name:wuqiwei Date:2013-08-09 ModifyReason:显示文章优先级为编辑时间然后是点击次数*/
				// 获取所有的屌丝笑话
				List<Tbowen> bowenList = bowenService.getPageDateList(hql, index, BelieveusGlobal.perPageCount, bowenCount.intValue());
				req.setAttribute("bowenCount", bowenCount);
				req.setAttribute("bowenList",bowenList);
			}
			return mapping.findForward("subBowenList");
		}
}
