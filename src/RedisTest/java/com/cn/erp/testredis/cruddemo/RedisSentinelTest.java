package com.cn.erp.testredis.cruddemo;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class RedisSentinelTest {

public static void main(String[] args) {  
        Set<String> sentinels = new HashSet<String>();  
        String hostAndPort1 = "127.0.0.1:6389";  
        sentinels.add(hostAndPort1);          String clusterName = "wredis6380zz" ;   
        JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName,sentinels);  
        Jedis jedis = null;  
        try {  
            jedis = redisSentinelJedisPool.getResource();  
            jedis.set("呜呜对对对呜呜", "aaa");  
            System.out.println(jedis.get("key"));  
            System.out.println(jedis.get("bbb"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            jedis.close();  
        }  
        redisSentinelJedisPool.close();  
    }  


}
