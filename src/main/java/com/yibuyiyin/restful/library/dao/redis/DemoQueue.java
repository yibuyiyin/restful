package com.yibuyiyin.restful.library.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * 队列demo
 *
 * @author peng.yu
 */
@Component
public class DemoQueue {

    private String key = "queue_%s";

    @Autowired
    private JedisPool jedisPool;

    /**
     * push queue
     *
     * @param id
     * @param strs
     * @return
     */
    public synchronized Long push(Integer id, String... strs) {
        return jedisPool.getResource().lpush(getKey(id), strs);
    }

    /**
     * pop queue
     *
     * @param id
     * @return
     */
    public synchronized String pop(Integer id) {
        return jedisPool.getResource().rpop(getKey(id));
    }

    /**
     * get queue length
     *
     * @param id
     * @return
     */
    public Long len(Integer id) {
        return jedisPool.getResource().llen(getKey(id));
    }

    /**
     * get queue key
     *
     * @param id
     * @return
     */
    private String getKey(Integer id) {
        return String.format(key, id);
    }
}
