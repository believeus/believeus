package cn.believeus.common.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import cn.believeus.model.TAdmin;
import cn.believeus.service.BaseService;

/**
 * @author wuqiwei 当程序启动时调用onApplicationEvent方法并且注入servletContext对象
 */
@Component
public class InitAdminListener implements ApplicationListener<ApplicationEvent>, ServletContextAware {
	private static final Log log=LogFactory.getLog(InitAdminListener.class);
	@Resource
	private BaseService baseService;
	/*Begin Author:wuqiwei Date:2014-03-28 AddReason:初始化后台最高权限管理员*/
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// 监听tomcat启动事件
		if(event instanceof ContextRefreshedEvent){
			TAdmin admin = (TAdmin) baseService.findObject(TAdmin.class, "adminName", "admin");
			if (admin != null)return;
			admin = new TAdmin();
			admin.setAdminName("admin");
			admin.setAdminPassword("believeus");
			baseService.saveOrUpdate(admin);
			log.info("init background login admin");
		}
		// 监听tomcat处理请求事件
		if(event instanceof ServletRequestHandledEvent){
			
		}
	}
	/*End Author:wuqiwei Date:2014-03-28 AddReason:初始化后台最高权限管理员*/
	@Override
	public void setServletContext(ServletContext servletContext) {
	}

}
