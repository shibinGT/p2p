package com.qhcs.security.cache;


import java.io.IOException;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.ser.SerializableUtils;


/**
 * 搞redis数据库的东西
 * 
 * @author Jon Chiang
 * @project video
 * @create_date 2014-5-6 下午5:35:07
 */
public class RedisSessionDAO extends AbstractSessionDAO {

   private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

   private RedisManager redisManager;
    
   	/**
	 * shiro-redis的session对象前缀
	 */
   private String keyPrefix = "shiro_session:";
    /**
     * 更新session,暂时没用到,不知道干嘛
     */
   @Override
   public void update(Session session) throws UnknownSessionException {
       try {
		this.saveSession(session);
	} catch (NotSerializableException e) {
		e.printStackTrace();
	}
   }
    
   	/**
	 * 保存序列化后的session
	 * 
	 * @param session
	 * @throws UnknownSessionException
	 * @throws NotSerializableException
	 */
   private void saveSession(Session session) throws UnknownSessionException, NotSerializableException{
       if(session == null || session.getId() == null){
           logger.error("session or session id is null");
           return;
       }
        
       byte[] key = getByteKey(session.getId());
       byte[] value = SerializableUtils.toByteArray(session);
       session.setTimeout(redisManager.getExpire()*1000);     
       this.redisManager.set(key, value, redisManager.getExpire());
   }

	/**
	 * 删除session
	 */
   @Override
   public void delete(Session session) {
       if(session == null || session.getId() == null){
           logger.error("session or session id is null");
           return;
       }
       redisManager.del(this.getByteKey(session.getId()));

   }

	/**
	 * 获取活跃的session
	 */
   @Override
   public Collection<Session> getActiveSessions() {
       Set<Session> sessions = new HashSet<Session>();
        
       Set<String> keys = redisManager.keys(this.keyPrefix + "*");
       if(keys != null && keys.size()>0){
           for(String key:keys){
               Session s=null;
			try {
				s = (Session)SerializableUtils.fromByteArray(redisManager.get(key.getBytes()));
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
               sessions.add(s);
           }
       }
        
       return sessions;
   }

	/**
	 * 将session保存到redis中,并返回sessionId
	 */
   @Override
   protected Serializable doCreate(Session session) {
       Serializable sessionId = this.generateSessionId(session);  
       this.assignSessionId(session, sessionId);
       try {
		this.saveSession(session);
	} catch (UnknownSessionException | NotSerializableException e) {
		e.printStackTrace();
	}
       return sessionId;
   }

	/**
	 * 通过sessionId获得Session
	 */
   @Override
   protected Session doReadSession(Serializable sessionId) {
       if(sessionId == null){
           logger.error("session id is null");
           return null;
       }
        
       Session s=null;
		try {
			s = (Session) SerializableUtils.fromByteArray(redisManager.get(this.getByteKey(sessionId)));
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
       return s;
   }
    
   /**
    * 获得byte[]型的key
    * @param key
    * @return
    */
   private byte[] getByteKey(Serializable sessionId){
       String preKey = this.keyPrefix + sessionId;
       return preKey.getBytes();
   }

   public RedisManager getRedisManager() {
       return redisManager;
   }

   public void setRedisManager(RedisManager redisManager) {
       this.redisManager = redisManager;
   }

   /**
    * Returns the Redis session key
    * prefix.
    * 返回shiro-redis的session对象前缀
    * @return The prefix
    */
   public String getKeyPrefix() {
       return keyPrefix;
   }

   /**
    * Sets the Redis sessions key 
    * prefix.
    * 设置shiro-redis的session对象前缀
    * @param keyPrefix The prefix
    */
   public void setKeyPrefix(String keyPrefix) {
       this.keyPrefix = keyPrefix;
   }
    
    
}