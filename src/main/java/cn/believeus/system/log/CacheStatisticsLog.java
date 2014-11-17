package cn.believeus.system.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.SessionFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

import cn.believeus.system.util.PropertyAssist;
/*Begin Author:wuqiwei Date:2014-04-07 CreateReason:使用切面统计hibernate二级缓存信息*/
@Aspect
@Component
public class CacheStatisticsLog {
	private static final Log  log=LogFactory.getLog(CacheStatisticsLog.class);
	@Resource
	private SessionFactory sessionFactory;
	@Pointcut("execution(* cn.believeus.dao.BelieveusComDao.*(..))")
	private void pointCut(){}
	@Before(value="pointCut()")
	public void showStatisticsLog(){
		String displayStatisticsLog=PropertyAssist.getValue("DisplayStatisticsLog");
		if (displayStatisticsLog.equals("true")) {
			Date nowTime=new Date();
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Statistics statistics = sessionFactory.getStatistics();
			String[] cacheRegionNames = statistics.getSecondLevelCacheRegionNames();
			for (String reginName : cacheRegionNames) {
				SecondLevelCacheStatistics cacheStatistics = statistics.getSecondLevelCacheStatistics(reginName);
				long cacheMissCount = cacheStatistics.getMissCount();
				long cacheHitCount = cacheStatistics.getHitCount();
				long cachePutCount = cacheStatistics.getPutCount();
				log.debug(time.format(nowTime)+":  "+reginName+" info: secondCacheMissCount:"+cacheMissCount+" secondCacheHitCount:"+cacheHitCount+" secondCachePutCount:"+cachePutCount);
			}
		}
	}
	
}
/*End Author:wuqiwei Date:2014-04-07 CreateReason:使用切面统计hibernate二级缓存信息*/
