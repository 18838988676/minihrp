package com.cn.erp.testredis.cruddemo;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisTest {
	@Test
	public void testRedis() {
		// 连接localhost 默认端口 6379
		Jedis jedis   = new Jedis("localhost");
		Jedis jedis2   = new Jedis("localhost");
//		jedis.setex("予以故意1",  0, "我是111员");
		jedis.set("aa", "我是111员");
		jedis2.set("bb", "我是111员");
		System.out.println(jedis.get("aa"));
	}
}
