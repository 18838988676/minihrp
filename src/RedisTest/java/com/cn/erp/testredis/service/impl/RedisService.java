package com.cn.erp.testredis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.cn.erp.testredis.entity.RedisTestStudent;

@Service("redisService")
public class RedisService {
	@Autowired //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired  // RedisTemplate，可以进行所有的操作
        private RedisTemplate<Object,Object> redisTemplate;  
	
	public void set(String key, String value){
		stringRedisTemplate.opsForValue().set(key, value);
	}
	
	public void set(RedisTestStudent s){
		redisTemplate.opsForValue().set(s.getId(), s);
	}
	
	public String get(String key){
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	public RedisTestStudent getStudent(String key){
		return (RedisTestStudent) redisTemplate.opsForValue().get(key);
	}


}
