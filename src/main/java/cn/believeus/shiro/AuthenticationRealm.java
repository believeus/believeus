package cn.believeus.shiro;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import cn.believeus.global.BelieveusGlobal;
import cn.believeus.model.TAdmin;
import cn.believeus.service.BaseService;


/**
 * Realm设计思想:需要被shiro验证通过，通过验证的标志是拥有凭证和密码，才能被shiro授权
 *
 */
public class AuthenticationRealm extends AuthorizingRealm {
	private static Log log = LogFactory.getLog(AuthenticationRealm.class);
	@Resource
	private BaseService baseService;

	public AuthenticationRealm() {
		log.debug("init AuthenticationRealm");
	}

	/**
	 * 获取认证信息
	 */
	@Override
	// 根据username和password验证该用户是否能成为shiro的(subject)用户
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) {
		log.debug("AuthenticationInfo doGetAuthenticationInfo");
		UsernamePasswordToken authenticationToken = (UsernamePasswordToken) token;
		String username = authenticationToken.getUsername();
		String password = new String(authenticationToken.getPassword());
		log.debug("UsernamePasswordToken-----username="+username+" password="+password);
		String hql="FROM TAdmin admin where admin.adminName='"+ username + "' and admin.adminPassword='"+password+"'";
		TAdmin admin = (TAdmin)baseService.findObject(hql);
		/*Begin Name:wuqiwei Date:2013-12-17 AddReason:shiro和当前应用共享一个session,将管理员信息放入session中*/
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(BelieveusGlobal.SessionAdmin, admin);
		/*End  Name:wuqiwei Date:2013-12-17 AddReason:shiro和当前应用共享一个session,将管理员信息放入session中*/
		long adminId = 0;
		Principal principal = null;
		if (admin != null) {
			adminId = admin.getId();
			principal = new Principal(adminId, username);
		}
		if (principal!=null) {
			// 需要有凭证和密码才能进入到成功页面
			return new SimpleAuthenticationInfo(principal, password, getName());
		}
		throw new UnknownAccountException();
	}

	// 如果没有变成shiro用户，就不会进行权限判断和判断
	// 如果没有授权过但判断权限的时候，会先经过授权，之后才进行判断权限
	@Override
	public AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 根据该用户授于相应的权限
		Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
		if (principal != null) {
			// 获取所有授权信息。
			/*
			 * List<String> authorities =
			 * adminService.findAuthorities(principal.getId());
			 */
			List<String> authorities = new ArrayList<String>();
			authorities.add("admin:member");
			if (authorities != null) {
				SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
				authorizationInfo.addStringPermissions(authorities);
				return authorizationInfo;
			}
		}
		return null;
	}

}