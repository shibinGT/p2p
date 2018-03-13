package com.qhcs.security.cache;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {
	
	private static JedisPool pool;
	
	private JedisUtils(){
		
	}
	
	static{
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(20);
		config.setMinIdle(5);
		//1.创建连接池
		pool = new JedisPool(config, "192.168.1.170", 7001);
	}
	
	
	public static Jedis getJedis(){
		return pool.getResource();
	}

}
