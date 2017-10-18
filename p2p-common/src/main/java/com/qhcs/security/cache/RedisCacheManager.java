package com.qhcs.security.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
public class RedisCacheManager implements CacheManager {
 
    private static final Logger logger = LoggerFactory.getLogger(RedisCacheManager.class);
 
	// fast lookup by name map 通過名字快速查找
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
 
    private RedisManager redisManager;
 
    /**
	 * The Redis key prefix for caches定義redis緩存前綴
	 */
    private String keyPrefix = "shiro_redis_cache:";
 
    /**
	 * 
	 * Returns the Redis session keys prefix.
	 * 
	 * @return The prefix 返回前綴
	 */
    public String getKeyPrefix() {
        return keyPrefix;
    }
 
    /**
	 * Sets the Redis sessions key prefix.
	 * 
	 * @param keyPrefix
	 *            The prefix 設置前綴
	 */
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

	/**
	 * 通过name获取RedisCache实例
	 */
    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("获取名称为: " + name + " 的RedisCache实例");
 
        Cache c = caches.get(name);
 
        if (c == null) {
 
            // initialize the Redis manager instance
         //   redisManager.init();
 
			// create a new cache instance 創建RedisCache實例
            c = new RedisCache<K, V>(redisManager, keyPrefix);
 
			// add it to the cache collection 添加到緩存集合里
            caches.put(name, c);
        }
        return c;
    }
 
    public RedisManager getRedisManager() {
        return redisManager;
    }
 
    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }
 
}