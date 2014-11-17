package cn.believeus.hibernatesearch.example.test;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.believeus.model.Tbowen;
import cn.believeus.service.BowenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HibernateSearchExampleTest {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private BowenService bowenService;
	
	
	/*Test: Author:WUQIWEI Date:2014-03-29 TestReason:初始化索引*/
	@Test
	public void initIndexTest(){
		FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
		 try {
			 fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*Test: Author:WUQIWEI  Date:2014-03-29 TestReason:多属性查询*/
	@Test
	public void multiFieldQueryParserSearchTest(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		String[] fields = {"content"};
		String keyword = "绝症";
		String[] values = {keyword};
		Query luceneQuery=null;
		try {
			luceneQuery = MultiFieldQueryParser.parse(Version.LUCENE_36, values, fields,new IKAnalyzer());
			// 按发布时间排倒序
			Sort sort = new Sort(new SortField("editDate", SortField.LONG, true));
			FullTextQuery hibQuery = fullTextSession.createFullTextQuery(luceneQuery, Tbowen.class);
			//根据编辑时间排序
			hibQuery.setSort(sort);
			// 分页设置
			hibQuery.setFirstResult(0);
			hibQuery.setMaxResults(50);
			@SuppressWarnings("unchecked")
			List<Tbowen> bowen = hibQuery.list();
			for (Iterator<Tbowen> iterator = bowen.iterator(); iterator.hasNext();) {
				Tbowen tbowen = (Tbowen) iterator.next();
				System.out.println(tbowen.getTitle());
				
			}
			tx.commit();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	/*Test: Author:WUQIWEI  Date:2014-03-29 TestReason:QueryParser查询*/
	@Test
	public void queryParserTest(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		QueryParser parser = new QueryParser(Version.LUCENE_36,"content",new IKAnalyzer());   
		try {
			Query luceneQuery = parser.parse("厨房电器");
			FullTextQuery query = fullTextSession.createFullTextQuery(luceneQuery, Tbowen.class );
			@SuppressWarnings("unchecked")
			List<Tbowen> list =query.list();
			@SuppressWarnings("rawtypes")
			Iterator iterator = list.iterator();
			for (;iterator.hasNext();) {
				Tbowen tbowen = (Tbowen) iterator.next();
				System.out.println(tbowen.getTitle());
			}
			tx.commit();
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}
	/*Test Author:WUQIWEI DATE:2014-03-30 TestReason:嵌入对象联合查询.Tbowen中有一个admin对象。根据admin.name=admin的查询Tbowen对象*/
	@Test
	public void indexedEmbeddedSearch(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		QueryParser parser = new QueryParser(Version.LUCENE_36,"admin.adminName",new IKAnalyzer());   
		try {
			Query luceneQuery = parser.parse("admin");
			FullTextQuery query = fullTextSession.createFullTextQuery(luceneQuery, Tbowen.class );
			@SuppressWarnings("unchecked")
			List<Tbowen> list =query.list();
			@SuppressWarnings("rawtypes")
			Iterator iterator = list.iterator();
			for (;iterator.hasNext();) {
				Tbowen tbowen = (Tbowen) iterator.next();
				System.out.println(tbowen.getTitle());
			}
			tx.commit();
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}
	/*Test Author:WUQIWEI Date:2014-03-30 TestReason:查看分词结果*/
	@Test
	public void displayToken(){
        try {
        	Tbowen bowen = bowenService.getTBowenById(3);
        	StringReader reader=new StringReader(bowen.getContent());
        	IKAnalyzer analyzer= new IKAnalyzer();
            //将一个字符串创建成Token流
            TokenStream stream  = analyzer.tokenStream("content", reader);
            //保存相应词汇
            CharTermAttribute cta = stream.addAttribute(CharTermAttribute.class);
            while(stream.incrementToken()){
                System.out.print("[" + cta + "]");
            }
            System.out.println();
            analyzer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@After
	public void destory(){
		sessionFactory.close();
	}
}
