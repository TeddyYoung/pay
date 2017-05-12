package com.aotu.dao.token.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * redis管理 抽象类
 * @author Teddy
 * @param <K>
 * @param <V>
 */
public abstract class AbstractBaseRedisDao {

	@Resource(name = "redisTemplate")
	protected RedisTemplate redisTemplate;

	/**
	 * 设置redisTemplate
	 * @param redisTemplate the redisTemplate to set
	 */
	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	/**
	 * 获取 RedisSerializer <br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}
}
