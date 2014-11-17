package cn.believeus.shiro;



import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;;

public class AuthenticationFilter extends FormAuthenticationFilter {
	private static Log log = LogFactory.getLog(AuthenticationFilter.class);
	public AuthenticationFilter() {
	}

	// 判断请求是否被拒绝
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		log.debug("AuthenticationFilter onAccessDenied()");
		return super.onAccessDenied(request, response);
	}

	// 提交表单的时候如果没有被拒绝创建调用
	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		log.debug("AuthenticationFilter createToken()");
		return super.createToken(request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		Session session = subject.getSession();
		return super.onLoginSuccess(token, subject, request, response);
	}
}
