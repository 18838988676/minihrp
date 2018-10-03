package com.cn.erp.testredis.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.erp.testredis.entity.RedisTestStudent;
import com.cn.erp.testredis.service.impl.RedisService;


//springboot 整合redis 测试
@Controller
@RequestMapping("/RedisTest")
public class RedisTest {
	@Autowired
	private RedisService service;//com.cn.erp.testredis.service.impl

	@RequestMapping("/aa")
	public void contextLoads() {
		service.set("myname", "chhliu");
		RedisTestStudent s = new RedisTestStudent();
		s.setId("001");
		s.setName("chhliu");
		s.setGrade("一年级");
		s.setAge("28");
		service.set(s);

		String name = service.get("myname");
		System.out.println("name:" + name);

		RedisTestStudent stu = service.getStudent("001");
		System.out.println(stu);
	}
}
