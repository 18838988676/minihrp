package com.cn.erp.testredis.cruddemo;

import java.util.Set;

import org.junit.Test;

public class Test666 {

	// 添加
	@Test
	public void demo1() {
		String add = new DemoRedis().addBySen("ppp224444", "woaini");
		System.out.println(add);
		String add2 = new DemoRedis().addBySen("ppp66332", "woxiaa");
		System.out.println(add2);
	}

	// 添加
	@Test
	public void demo2() {
		String add = new DemoRedis().add("456", 42, "woaini");
		System.out.println(add);
	}

	// 显示
	@Test
	public void demo3() {
		new DemoRedis().show("123");
	}

	// 模糊查询
	@Test
	public void demo4() {
		new DemoRedis().showCompex("1");
	}

	// 删除
	@Test
	public void demo5() {
		String[] str = { "123", "12" };
		new DemoRedis().delete(str);
	}

	// 添加多设置key的超时个key-value
	@Test
	public void demo6() {
		String[] str = { "one", "name1", "two", "name2" };
		String add = new DemoRedis().addManyKey(str);
		System.out.println(add);
	}

	// 删除所有
	@Test
	public void demo7() {
		new DemoRedis().deleteAll();
	}

	// 设置key的超时 可以不在一开始存的时候定义
	@Test
	public void demo8() {
		new DemoRedis().setTimeOut("123", 9999);
	}

	// 查询key的时间，不存在时返回-2,存在没有设置时间返回-1，否则返回时间
	@Test
	public void demo9() {
		new DemoRedis().showTimeOut("12");
	}

	@Test
	public void demo10() {
		Set<String> keys = new DemoRedis().keys("123");
		System.out.println(keys);
	}
}
