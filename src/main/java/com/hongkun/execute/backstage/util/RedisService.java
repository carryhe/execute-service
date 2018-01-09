package com.hongkun.execute.backstage.util;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author HeXG
 * 操作redis的服务
 */
@Component
public class RedisService {

    /**
     * 对list的操作
     */

    /**
     * 向redis中存入对象
     * @param key
     * @param object
     */
    public void setListSingleObject(String key, Object object) {
        if (null!=object &&!"".equals(object)){
            Jedis jedis= RedisPool.getJedis();
            String temp= JSON.toJSONString(object);
            jedis.rpush(key,temp);
            RedisPool.returnResource(jedis);
        }

    }

    /**
     * 根据key来从redis中获取对象，并且移除
     * @param key
     * @return
     */
    public Object getListSingleObject(String key) {
        Jedis jedis =RedisPool.getJedis();
        String lpop = jedis.lpop(key);
        Object object = JSON.parseObject(lpop);
        RedisPool.returnResource(jedis);
        return object;
    }

    /**
     * 进行计数
     * @param key
     */
    public long setKey(String key) {
        Jedis jedis =RedisPool.getJedis();
        long incr = jedis.incr(key);
        RedisPool.returnResource(jedis);
        return incr;
    }

    /**
     * 从string中获取数值，根据key
     * @param key
     * @return
     */
    public String getStringValue(String key){
        Jedis jedis =RedisPool.getJedis();
        String object = jedis.get(key);
        RedisPool.returnResource(jedis);
        return object;
    }

    /**
     * 删除redis中的key
     * @param key
     * @return
     */
    public void removeKey(String key){
        Jedis jedis =RedisPool.getJedis();
        jedis.del(key);
        RedisPool.returnResource(jedis);
    }

    /**
     * 查询所有的key
     * @param key
     * @return
     */
    public Set<String> getAllKey(String key){
        Jedis jedis =RedisPool.getJedis();
        Set<String> keys = jedis.keys(key+"*");
        RedisPool.returnResource(jedis);
        return keys;
    }

    /**
     * 查询key是否存在
     * @param key
     * @return
     */
    public boolean existsKey(String key){
        Jedis jedis =RedisPool.getJedis();
        Boolean exists = jedis.exists(key);
        RedisPool.returnResource(jedis);
        return exists;
    }


    /**
     * 存入信息
     * string
     * @param key
     * @param value
     */
    public void setStringValue(String key,String value){
        Jedis jedis =RedisPool.getJedis();
        jedis.set(key,value);
        RedisPool.returnResource(jedis);
    }

}
