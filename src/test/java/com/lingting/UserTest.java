package com.lingting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.lingting.model.User;
import com.lingting.service.UserService;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Log4j2
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		int key = 3;
		User user = userService.selectByKey(key);
		System.out.println(user.toString());
		log.info("info: {}", user.getUserName());
		log.error("error: {}", user.getUserName());
		log.debug("debug: {}", user.getUserName());
		log.warn("warn: {}", user.getUserName());
	}

}
