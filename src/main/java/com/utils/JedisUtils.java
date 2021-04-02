package com.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;

/**
 * @Author WeiWei Zhang
 * @Date 2020-07-14 17:37
 * 类说明：jedis工具类
 */
public class JedisUtils {

    private JedisPool pool = null;
    private String ip = "127.0.0.1";
    private int port = 6379;

    public JedisUtils() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(5);
            config.setMaxTotal(500);
            config.setMaxWaitMillis(100);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config,this.ip,this.port,10000,null);
        }
    }

    /**
     * 释放jedis连接
     * @param jedis
     */
    public static void releaseResource(Jedis jedis) {
        if (jedis != null) {
            jedis.quit();
            jedis.disconnect();
        }
    }

    /**
     * 通过key获取存储在redis中的value，并释放连接
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return value;
    }

    /**
     * 向redis存入key和value，并释放连接，key存在，则覆盖
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
            releaseResource(jedis);
        }
    }

    /**
     * 通过key设置field指定值，如果key不存在，则先创建
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(String key,String field,String value) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hset(key,field,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

    /**
     * 通过key设置field指定值，如果key不存在，则先创建；如果field已经存在，则返回0
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hsetnx(String key,String field,String value) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hsetnx(key,field,value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

    /**
     * 通过key设置hash的多个field
     * @param key
     * @param hash
     * @return
     */
    public String hmset(String key, Map<String,String> hash) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hmset(key,hash);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

    /**
     * 通过key  field获取value值
     * @param key
     * @param field
     * @return
     */
    public String hget(String key,String field) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hget(key,field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

    /**
     * 通过key  fields获取指定的value，如果没有对应的value，则返回null
     * @param key
     * @param field   可以是个String,也可以是String数组
     * @return
     */
    public List<String> hmget(String key, String... field) {
        Jedis jedis = null;
        List<String> result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hmget(key,field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

    /**
     * 通过key和field判断是否有指定的value存在
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(String key,String field) {
        Jedis jedis = null;
        Boolean result = null;
        try {
            jedis = pool.getResource();
            result = jedis.hexists(key,field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            releaseResource(jedis);
        }
        return result;
    }

}
