package com.microthings.monitor_management.cache;

import com.alibaba.fastjson.JSON;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tyd
 * @date 2020/5/20
 * @description ehcache作为一级缓存，redis作为二级缓存
 */
public class EhcacheRedisCache implements Cache{

    private static final Logger logger = LoggerFactory.getLogger(EhcacheRedisCache.class);

    private final String id;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**下面是ehcache相关*/

    private static CacheManager cacheManager = CacheManager.create();

    private static Ehcache ehcache = cacheManager.getCache("ObjectCaching");

    /**下面是redis相关*/

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");

    private static RedisTemplate<String,Object> redisTemplate = applicationContext.getBean(RedisTemplate.class);

    public EhcacheRedisCache(final String id){
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try{
            //先存入redis二级缓存
            if(null!=value){
                logger.info("Cache-L2>>>>>>>>>>>>>>>>>>>>putObject: \n key="+key+"\n value="+value);
                redisTemplate.opsForValue().set(key.toString(), value,2, TimeUnit.DAYS);
            }
            //再存入ehcache一级缓存
            if(null!=value){
                logger.info("Cache-L1>>>>>>>>>>>>>>>>>>>>putObject: \n key="+key+"\n value="+value);
                ehcache.put(new Element(key, value));
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("保存数据异常！");
        }
    }

    @Override
    public Object getObject(Object key) {
        try{
            //先查看ehcache是否有缓存
            Element cachedElement = ehcache.get(key);
            if (null!=cachedElement) {
                logger.info("Cache-L1>>>>>>>>>>>>>>>>>>>>getObject: key="+key);
                return cachedElement.getObjectValue();
            }
            //再查看redis是否有缓存
            if(null!=redisTemplate.opsForValue().get(key.toString())){
                logger.info("Cache-L2>>>>>>>>>>>>>>>>>>>>getObject: key="+key);

                //将redis中的缓存存入ehcache
                Object value = redisTemplate.opsForValue().get(key.toString());
                ehcache.put(new Element(key, value));
                logger.info("Cache-L1>>>>>>>>>>>>>>>>>>>>putObject: \n key="+key+"\n value="+redisTemplate.opsForValue().get(key.toString()));

                return redisTemplate.opsForValue().get(key.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取数据异常！");
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try{
            //ehcache
            if(null!=key){
                Object obj = getObject(key);
                ehcache.remove(key);
                return obj;
            }
            //redis
            if(null!=key){
                return redisTemplate.expire(key.toString(),1,TimeUnit.DAYS);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取数据异常！");
        }
        return null;
    }

    @Override
    public void clear() {

        //ehcache
        ehcache.removeAll();
        logger.info("Cache-L1>>>>>>>>>>>>>>>>>>>>clear: 清除了" + ehcache.getSize() + "个对象");

        //redis
        Long size=redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Long size = redisConnection.dbSize();
                //连接清除数据
                redisConnection.flushDb();
                redisConnection.flushAll();
                return size;
            }
        });
        logger.info("Cache-L2>>>>>>>>>>>>>>>>>>>>clear: 清除了" + size + "个对象");
    }

    @Override
    public int getSize() {
        //ehcache+redis
        return this.getEhcacheSize()+this.getRedisSize();
    }

    public int getEhcacheSize(){
        //ehcache
        return ehcache.getSize();
    }

    public int getRedisSize() {
        //redis
        Long size = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.dbSize();
            }
        });
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    /**定时任务(10秒一次) 使ehcache同步redis的缓存*/
    public static void checkCacheValidity(){
        for(int i=0;i<ehcache.getKeys().size();i++){
            try{
                Object key = ehcache.getKeys().get(i);
                Object valueEhcache = ehcache.get(key).getObjectValue();
                Object valueRedis = redisTemplate.opsForValue().get(key.toString());
                String valueEhcacheJson = JSON.toJSONString(valueEhcache);
                String valueRedisJson = JSON.toJSONString(valueRedis);
                if(!(valueEhcacheJson.equals(valueRedisJson)) || (null==valueRedis)){
                    ehcache.remove(key);
                    logger.debug("Cache-L1>>>>>>>>>>>>>>>>>>>>清理无效ehcache缓存");
                }
            }catch (Exception e){
            }
        }
    }
}
