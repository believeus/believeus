1.创建索引存放目录:/date/believeusIndex
  sudo mkdir -p /date/believeusIndex
  sudo chmod tomcat:tomcat /date/believeusIndex

2.IKAnalyse添加扩展分词词库
  在src/main/resources创建IKAnalyzer.cfg.xml配置文件
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">  
  <properties>  
    <comment>IK Analyzer 扩展配置</comment>
    <!-- 用户可以在这里配置自己的扩展字典,最前面也需要加斜杠'/',要不然加载不成功 -->
     <entry key="ext_dict">/dicdata/electric.dic;/dicdata/diet.dic;/dicdata/product.dic</entry> 
     <!-- 用户可以在这里配置自己的扩展停止词字典    -->
     <!--  <entry key="ext_stopwords">/dicdata/ext_stopword.dic</entry>  -->
  </properties>
  *.dic是通过src/main/resources/dicsrc/*.scel通过SogouLibAnalyse解析出的文本词库放置在src/main/resources/dicdata下