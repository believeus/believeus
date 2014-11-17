package cn.believeus.dao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.believeus.dao.BaseDao;
import cn.believeus.exception.UnSupportTypeExcetion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BaseDaoTest {
	@Resource
	private BaseDao believeusComDao;
	/*Begin Author:wuqiwei Date:2014-03-29 TestReason:批量插入数据*/
	@Test
	public void batchUpdate_InsertTest(){
		String sql="insert into TUser(email,nickName,password) values(?,?,?)";
		ArrayList<LinkedHashMap<Object,Object>> arrayList = new ArrayList<LinkedHashMap<Object, Object>>();
		LinkedHashMap<Object, Object> wuqiweiLinkedHashMap=new LinkedHashMap<Object, Object>();
		wuqiweiLinkedHashMap.put(1, "1058633117@qq.com");
		wuqiweiLinkedHashMap.put(2, "wuqiwei");
		wuqiweiLinkedHashMap.put(3, "believeus");
		
		LinkedHashMap<Object, Object> wuhuanrongLinkedHashMap=new LinkedHashMap<Object, Object>();
		wuhuanrongLinkedHashMap.put(1, "569009496@qq.com");
		wuhuanrongLinkedHashMap.put(2, "wuhuanrong");
		wuhuanrongLinkedHashMap.put(3, "believeus!@#");
		
		LinkedHashMap<Object, Object> wuchunlianLinkedHashMap=new LinkedHashMap<Object, Object>();
		wuchunlianLinkedHashMap.put(1, "45885639@qq.com");
		wuchunlianLinkedHashMap.put(2, "wuchunlian");
		wuchunlianLinkedHashMap.put(3, "123156believeus");
		arrayList.add(wuqiweiLinkedHashMap);
		arrayList.add(wuhuanrongLinkedHashMap);
		arrayList.add(wuchunlianLinkedHashMap);
		//believeusComDao.batchUpdate(sql, arrayList);
	}
	
	/*Begin Author:wuqiwei Date:2014-03-29 TestReason:批量删除数据*/
	@Test
	public void batchUpdate_deleteTest(){
		String sql="delete from TUser where email in (?,?,?)";
		ArrayList<LinkedHashMap<Object,Object>> arrayList = new ArrayList<LinkedHashMap<Object, Object>>();
		LinkedHashMap<Object, Object> linkedHashMap=new LinkedHashMap<Object, Object>();
		linkedHashMap.put(1, "1058633117@qq.com");
		linkedHashMap.put(2, "569009496@qq.com");
		linkedHashMap.put(3, "45885639@qq.com");

		arrayList.add(linkedHashMap);
		//believeusComDao.batchUpdate(sql, arrayList);
	}
	/*Begin Author:wuqiwei Date:2014-03-29 TestReason:批量更新数据*/
	@Test
	public void batchUpdate_updateTest() throws Exception{
		String sql="update  TUser set sex=? where email=?";
		ArrayList<LinkedHashMap<Object,Object>> arrayList = new ArrayList<LinkedHashMap<Object, Object>>();
		LinkedHashMap<Object, Object> wuqiweilinkedHashMap=new LinkedHashMap<Object, Object>();
		wuqiweilinkedHashMap.put(1, "male");
		wuqiweilinkedHashMap.put(2, "1058633117@qq.com");
		
		LinkedHashMap<Object, Object> wuhuanronglinkedHashMap=new LinkedHashMap<Object, Object>();
		wuhuanronglinkedHashMap.put(1, "female");
		wuhuanronglinkedHashMap.put(2, "569009496@qq.com");

		arrayList.add(wuqiweilinkedHashMap);
		arrayList.add(wuhuanronglinkedHashMap);
		//believeusComDao.batchUpdate(sql, arrayList);
	}
	
	/*Begin Author:wuqiwei Date:2014-03-29 TestReason:测试确定不支持java.io.FileInputStream类型*/
	@Test(expected=UnSupportTypeExcetion.class)
	public void batchUpdate_UnSupporInputStreamTypeTest() throws Exception{
		String sql="update  TUser set sex=? where email=?";
		ArrayList<LinkedHashMap<Object,Object>> arrayList = new ArrayList<LinkedHashMap<Object, Object>>();
		LinkedHashMap<Object, Object> wuqiweilinkedHashMap=new LinkedHashMap<Object, Object>();
		wuqiweilinkedHashMap.put(1, "male");
		wuqiweilinkedHashMap.put(2, new FileInputStream(new File("/home/wuqiwei/fdfs-web整合架构图.graphml")));
		arrayList.add(wuqiweilinkedHashMap);
		//baseDao.batchUpdate(sql, arrayList);
	}
	
	/*Begin Author:wuqiwei Date:2014-03-29 TestReason:测试确定不支持java.io.Reader类型*/
	@Test(expected=UnSupportTypeExcetion.class)
	public void batchUpdate_UnSupporReaderTypeTest() throws Exception{
		String sql="update  TUser set sex=? where email=?";
		ArrayList<LinkedHashMap<Object,Object>> arrayList = new ArrayList<LinkedHashMap<Object, Object>>();
		LinkedHashMap<Object, Object> wuqiweilinkedHashMap=new LinkedHashMap<Object, Object>();
		wuqiweilinkedHashMap.put(1, "male");
		wuqiweilinkedHashMap.put(2, new StringReader("1058633117@qq.com"));
		arrayList.add(wuqiweilinkedHashMap);
		//believeusComDao.batchUpdate(sql, arrayList);
	}
}
