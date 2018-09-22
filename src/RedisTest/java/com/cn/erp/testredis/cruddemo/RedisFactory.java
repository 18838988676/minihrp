package com.cn.erp.testredis.cruddemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis工厂类
 * 
 * @author Administrator
 *         C:\Users\Administrator\.m2\repository\redis\clients\jedis\2.8.0\jedis
 *         -2.8.0.jar
 */
public class RedisFactory {
	// 最大链接数
	private int maxTotal = 10;
	// 最大空闲线程
	private int maxIdle = 5;
	// 最小空闲数
	private int minIdle = 0;
	// 最大等待时间
	private int maxWaitMillis = 1000;
	// 连接池管理对象
	private static JedisPool jedisPool;
	// 地址
	private String url;
	// 端口
	private int port;
	// 密码
	private String passWold;
	// 读取超时时间
	private int timeOut = 1000;
	//
	private static RedisFactory obj = new RedisFactory();

	private RedisFactory() {

	}

	public static RedisFactory CreateRedisFactory() {
		return obj;
	}

	/**
	 * 创建链接池对象
	 */
	private synchronized void createJedsiPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		// 最大链接数
		config.setMaxTotal(maxTotal);
		// 最大空闲线程
		config.setMaxIdle(maxIdle);
		// 最大等待时间
		config.setMaxWaitMillis(maxWaitMillis);
		// 最小空闲数
		config.setMinIdle(minIdle);
		this.jedisPool = new JedisPool(config, url, port, timeOut, passWold);
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public synchronized Jedis getJedis() {
		if (jedisPool == null) {
			createJedsiPool();
		}
		// 当线程数用完进行等待
		if (jedisPool.getNumActive() >= maxTotal) {
			while (true) {
				try {
					Thread.sleep(500);
					if (jedisPool.getNumActive() < maxTotal)
						break;
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		return jedisPool.getResource();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPassWold() {
		return passWold;
	}

	public void setPassWold(String passWold) {
		this.passWold = passWold;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

}