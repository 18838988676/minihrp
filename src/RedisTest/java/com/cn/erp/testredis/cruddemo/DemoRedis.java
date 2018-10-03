package com.cn.erp.testredis.cruddemo;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

public class DemoRedis {
	/**
	 * 获取jedis对象
	 * 
	 * @return
	 */
	/*Jedis getJedis() {
		JedisPoolConfig config = new JedisPoolConfig();
		JedisPool s = new JedisPool(config, "127.0.0.1", 6388);
		Jedis je = s.getResource();
		return je;
	}*/
	
	//获取哨兵模式的jedis
	Jedis getJedis() {
			Set<String> sentinels = new HashSet<String>();  
	        String hostAndPort1 = "127.0.0.1:6389";  
	        sentinels.add(hostAndPort1);         
	        JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool("wredis6380zz",sentinels);  
	        Jedis jedis = null;  
	            jedis = redisSentinelJedisPool.getResource();  
		return jedis;
	}
	
	

	/**
	 * 添加
	 * 
	 * @param key
	 * @param value
	 */
	String add(String key, String value) {
		Jedis jedis = getJedis();
		String str = jedis.set(key, value);
		return str;
	}
	
	
	String addBySen(String key, String value) {
		Jedis jedis = getJedis();
		String str = jedis.set(key, value);
		return str;
	}
	
	
	

	/**
	 * 添加 带时间范围
	 * 
	 * @param key
	 * @param value
	 */
	String add(String key, int seconds, String value) {
		Jedis jedis = getJedis();
		String str = jedis.setex(key, seconds, value);
		return str;
	}

	/**
	 * 显示
	 * 
	 * @param key
	 */
	void show(String key) {
		Jedis jedis = getJedis();
		System.out.println("取出的值是：" + jedis.get(key));
	}

	/**
	 * 模糊查询
	 * 
	 * @param str
	 */
	void showCompex(String str) {
		Jedis jedis = getJedis();
		System.out.println("模糊查询key:" + jedis.keys(str));
	}

	/**
	 * 删除
	 * 
	 * @param str
	 */
	void delete(String[] str) {
		Jedis jedis = getJedis();
		System.out.println("返回值为：" + jedis.del(str));
	}

	/**
	 * 添加多个key-value
	 * 
	 * @param str
	 * 
	 */
	String addManyKey(String[] str) {
		/*
		 * 格式：跟json差不多，区别就是把 : 转成 ， String str[]=new
		 * String[]{"one","name1","two","name2"};
		 */
		Jedis jedis = getJedis();
		String mset = jedis.mset(str);
		return mset;

	}

	/**
	 * 删除所有
	 */
	void deleteAll() {
		System.out.println(getJedis().flushDB());
	}

	/**
	 * 设置key的超时
	 * 
	 * @param key
	 * @param time
	 */
	void setTimeOut(String key, int time) {

		System.out.println(getJedis().expire(key, time));
	}

	/**
	 * 查询key的时间，不存在时返回-2,存在没有设置时间返回-1，否则返回时间
	 * 
	 * @param key
	 */
	void showTimeOut(String key) {
		
		System.out.println(getJedis().pttl(key));
	}

	/**
	 * return stringRedisTemplate.keys("*" + pattern + "*");
	 */

	public Set<String> keys(String pattern) {

		return getJedis().keys("*" + pattern + "*");
		// return getJedis().keys("?" + pattern);
		// return stringRedisTemplate.keys("[" + pattern + "]");
	}
}
