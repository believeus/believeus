一.配置 memcached service:
  安装: Install memcached:
   sudo apt-get install memcached
  启动 start memcached:
    memcached -d -m 10 -u root -l localhost -p 11211 -c 256 -P /tmp/memcached.pid


二.添加ehcache的监控
   1.在http://ehcache.org/documentation/monitor.html#Installation_And_Configuration下载ehcache-monitor-kit-1.0.0-distribution.tar.gz包
   2.解压缩到目录下，复制ehcache-monitor-kit-1.0.0\lib\ehcache-probe-1.0.0.jar包到application的web-inf/lib目录下
   3.将以下配置copy的ehcache.xml文件的ehcache标签中，注：上述链接中说的配置少写了个probe包名
       <cacheManagerPeerListenerFactory  
        class="org.terracotta.ehcachedx.monitor.probe.ProbePeerListenerFactory"  
        properties="monitorAddress=localhost, monitorPort=9889" />
   4.在\ehcache-monitor-kit-1.0.0\etc\ehcache-monitor.conf中可以配置监控的ip和端口号。
   5.启动被监控的web application和ehcache-monitor-kit-1.0.0\bin目录下的startup.bat（在windows环境下）
   6.在浏览器中输入 http://localhost:9889/monitor/即可开始监控 