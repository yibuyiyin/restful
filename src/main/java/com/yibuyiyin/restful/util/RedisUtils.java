package com.yibuyiyin.restful.util;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

/**
 * Redis工具类
 */
public class RedisUtils {

    @Autowired
    private JedisPool jedisPool;

    public static String getRedisKey(final String keyPrefix, final String... others) {
        final StringBuilder sb = new StringBuilder(keyPrefix);
        if (ArrayUtils.isNotEmpty(others)) {
            for (final String str : others) {
                sb.append("_").append(str);
            }
        }
        return sb.toString();
    }

}

