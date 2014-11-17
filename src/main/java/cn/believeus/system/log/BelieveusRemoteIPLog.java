package cn.believeus.system.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//<!-- aop 需要的命名空间  xmlns:aop="http://www.springframework.org/schema/aop"-->
//<!-- 该命名空间指向  xsi:schemaLocation=http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd -->
@Aspect
@Component(value="believeusRemoteIPInfo")
public class BelieveusRemoteIPLog {
//	private static Log log = LogFactory.getLog(BelieveusRemoteIPInfo.class);
	// ..*代表子包
	//  1.拦截返回值是org.apache.struts.action.ActionForward类型 cn.believeus 下所有的子包下的action包下面所有的类下面所有的方法
//	@Pointcut("execution(org.apache.struts.action.ActionForward cn.believeus..*.action.*.*(..))")
	@Pointcut("execution(org.apache.struts.action.ActionForward cn.believeus.action.IndexAction.execute(..))")
	private void pointCut(){}
	// 2.并且参数分别是 mapping,form,request,response，注意这里的参数要和要拦截的方法参数拼写一致和个数相同
	// 3 Before 代表在要拦截方法之前调用这个方法，因为和拦截方法的参数一致，相当于先将拦截方法的参数放入该方法，
	 //   之后再调用真正的方法
	/*如果不是字符串类型需要加上argNames="mapping,form,request,response"
	在class文件中没生成变量调试信息是获取不到方法参数名字的。
	所以我们可以使用策略来确定参数名：
	如果我们通过“argNames”属性指定了参数名，那么就是要我们指定的；
	argNames 表示的是编译之后remoteIPInfotoLog 方法名仍为mapping,form,request,response*/
	@Before(value="pointCut()&&args(mapping,form,request,response)", argNames="mapping,form,request,response")
	public void remoteIPInfotoLog( ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		 try {
//			 HttpServletRequest req=(HttpServletRequest)request;
//			 String urlStr = "http://ip.taobao.com/service/getIpInfo.php?ip="
//						+  req.getRemoteAddr();
//			  // 将urlstr字符串网址实例化为URL定位地址s
//			   URL url = new URL(urlStr);       
//			   URLConnection conn = url.openConnection();   //打开网站链接
//			   // 如果5秒没有和tomcat/apache/nginx 获得链接,则断开链接
//			   conn.setConnectTimeout(100);
//			   BufferedReader reader = new BufferedReader(new InputStreamReader(
//			   conn.getInputStream()));  //实例化输入流，并获取网页代码  conn.getInputStream() 是需要时间的
//			   String line="";                     //依次循环，至到读的值为空
//			   StringBuilder sb = new StringBuilder();
//			   // jdk bug 这里是获取网络数据，如果没有网络数据的时候，这里会一直的等待
//			   // 该方法是阻塞式的。“你不给我我就等你”
//			while ((line = reader.readLine()) != null) {
//				sb.append(line);
//			}
//			reader.close();
//			/*J*/
//			JSONObject jsonRemoteInfo = new JSONObject(sb.toString());
//			JSONObject data = jsonRemoteInfo.getJSONObject("data");
//			String region = data.getString("region");
//			String city = data.getString("city");
//			String county = data.getString("county");
//			String ip = data.getString("ip");
//			log.info("登录网站的IP地址是--->" + ip + " 位于" + region + " 省" + city
//					+ " 市 " + county + " 县");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
/*
 * 淘宝ip地址查询接口http://ip.taobao.com/service/getIpInfo.php?ip=[ip]页面信息如下：
 * {"code":0,"data":{"country":"\u672a\u5206\u914d\u6216\u8005\u5185\u7f51IP",
 * "country_id"
 * :"IANA","area":"","area_id":"","region":"","region_id":"","city":""
 * ,"city_id":"",
 * "county":"","county_id":"","isp":"","isp_id":"","ip":"127.0.0.1"}}
 */
