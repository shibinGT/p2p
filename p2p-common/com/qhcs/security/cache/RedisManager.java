package com.qhcs.security.cache;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class RedisManager {

	private static Logger logger = LoggerFactory.getLogger(RedisManager.class);

	private JedisCluster jedis;

	// 过期时间0表示key已经过期
	private int expire = 0;

	// 无参的构造函数
	public RedisManager() {

	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedis = jedisCluster;
	}

	/**
	 * get value from redis 获得byte[]型的key
	 * 
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key) {
		byte[] value = jedis.get(key);
		return value;
	}

	/**
	 * get value from redis根据key从Redis中获取对象
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		String value = jedis.get(key);
		return value;
	}

	/**
	 * 存儲String 键值对
	 * 
	 * @param key byte[] 类型
	 * @param value byte[]类型
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value) {

		jedis.set(key, value);
		if (this.expire != 0) {
			jedis.expire(key, this.expire);
		}

		return value;
	}

	/**
	 * 存儲String 键值对
	 * 
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public String set(String key, String value) {
		jedis.set(key, value);
		if (this.expire != 0) {
			jedis.expire(key, this.expire);
		}

		return value;
	}

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @param expire过期时间
	 * @return
	 */
	public byte[] set(byte[] key, byte[] value, int expire) {
		jedis.set(key, value);
		if (expire != 0) {
			jedis.expire(key, expire);
		}

		return value;
	}

	/**
	 * set
	 * 
	 * @param key
	 * @param value
	 * @param expire过期时间
	 * @return
	 */
	public String set(String key, String value, int expire) {
		jedis.set(key, value);
		if (expire != 0) {
			jedis.expire(key, expire);
		}

		return value;
	}

	/**
	 * 根据key来删除数据
	 * 
	 * @param key byte[]类型
	 */
	public void del(byte[] key) {

		jedis.del(key);

	}

	/**
	 * 根据key来删除数据
	 * 
	 * @param key
	 */
	public void del(String key) {

		jedis.del(key);

	}

	/**
	 * 刷新数据库
	 */
	public void flushDB() {

		jedis.flushDB();

	}

	/**
	 * 查询当前数据库
	 * 
	 * @return
	 */
	public Long dbSize() {
		Long dbSize = 0L;
		dbSize = jedis.dbSize();
		return dbSize;
	}

	/**
	 * 返回匹配pattern的所有Key
	 * 
	 * @param regex
	 * @return
	 */

	public Set<String> keys(String pattern) {
		logger.debug("Start getting keys...");
		Set<String> keys = new TreeSet<String>();
		Map<String, JedisPool> clusterNodes = jedis.getClusterNodes();
		for (String k : clusterNodes.keySet()) {
			logger.debug("Getting keys from: {}", k);
			JedisPool jp = clusterNodes.get(k);
			Jedis connection = jp.getResource();
			try {
				keys.addAll(connection.keys(pattern));
			} catch (Exception e) {
				logger.error("Getting keys error: {}", e);
			} finally {
				logger.debug("Connection closed.");
				connection.close();// 用完一定要close这个链接！！！
			}
		}
		logger.debug("Keys gotten!");
		return keys;
	}

	/**
	 * 获取超时时间
	 * 
	 * @return
	 */
	public int getExpire() {
		return expire;
	}

	/**
	 * 设置超时时间
	 * 
	 * @param expire
	 */
	public void setExpire(int expire) {
		this.expire = expire;
	}

}