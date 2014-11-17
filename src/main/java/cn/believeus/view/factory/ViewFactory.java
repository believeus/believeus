package cn.believeus.view.factory;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用访问者模式返回对应的视图
 */
/*Begin Name:wuqiwei Date:2013-08-23 AddReason:使用访问者模式解决action逻辑一致而返回视图不同*/
public abstract class ViewFactory {
	public static String viewInstance(ViewFactory viewFactory, HttpServletRequest request,Object obj) {
		return viewFactory.getView(request, obj);
	}
	public abstract String getView(HttpServletRequest request, Object obj);
}
/*End Name:wuqiwei Date:2013-08-23 AddReason:使用访问者模式解决action逻辑一致而返回视图不同*/
