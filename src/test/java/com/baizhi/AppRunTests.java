package com.baizhi;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRunTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		User user = new User();
		user.setUsername("骚祥");
		user.setPassword("123456");
		User user2 = userMapper.selectOne(user);
		System.out.println(user2);
		System.out.println("----"+ userService);
		User user3 = userService.selectOne(user);
		System.out.println(user3);
	}

}
