package cn.believeus.userservice.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import cn.believeus.model.Tuser;
import cn.believeus.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUserService {
	@Resource
	private BaseService userService;
	@Test
	public void TestgetUserById(){
		 Tuser user = userService.getUserById(Tuser.class, 1);
		 Assert.notNull(user);
	}
	@Test
	public void getUserCountTest(){
		String hql="FROM Tuser where id=1";
		Long count = userService.getUserCount(hql);
		Assert.notNull(count);
	
	}
	
}