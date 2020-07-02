package com.yibuyiyin.restful.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * Redis 配置类
 */
@Configuration
@Data
//@ConfigurationProperties(prefix = "redis.cluster")
@Slf4j
public class RedisConfig {

	// host
	@Value("${redis.host}")
	private String host;

	// port
	@Value("${redis.port}")
	private int port;

	// 密码
	@Value("${redis.password}")
	private String password;

	// 连接/读取数据超时时间
	@Value("${redis.timeout}")
	private int timeout;

	// 数据库
	@Value("${redis.database}")
	private int database;

	// 最大连接尝试次数
	@Value("${redis.max-attempts}")
	private int maxAttempts;

	// 资源池中的最大空闲连接数
	@Value("${redis.jedis.pool.max-idle}")
	private int maxIdle;

	// 资源池最大阻塞等待时间
	@Value("${redis.jedis.pool.max-wait}")
	private long maxWait;

	// 连接耗尽时是否阻塞
	@Value("${redis.jedis.pool.block-when-exhausted}")
	private boolean blockWhenExhausted;

	// 是否启用pool的jmx管理功能
	@Value("${redis.jedis.pool.jmx-enabled}")
	private boolean jmxEnabled;

	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = null;
		try {
			jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(maxIdle);
			jedisPoolConfig.setMaxWaitMillis(maxWait);
			jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
			jedisPoolConfig.setJmxEnabled(jmxEnabled);
		} catch (Exception e) {
			log.error("初始化JedisPoolConfig错误", e);
		}

		return jedisPoolConfig;
	}

	@Bean
	public JedisPool jedisPoolFactory(JedisPoolConfig jedisPoolConfig) {
		JedisPool jedisPool = null;
		try {
			jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
		} catch (Exception e) {
			log.error("初始化JedisPool失败", e);
		}
		return jedisPool;
	}
}