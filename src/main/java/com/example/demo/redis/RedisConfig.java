package com.example.demo.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    // 在缓存对象集合中，缓存是以 key-value 的形式保存的
    // 如果没有指定缓存的 key，则 Spring Boot 会使用SimpleKeyGenerator 生成 key
    @Bean
    public KeyGenerator keyGenerator(){
        // 定义缓存数据 key 的生成策略
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName());
            sb.append(method.getName());
            for (Object obj : objects) {
                sb.append(obj);
            }
            return sb.toString();
        };
    }

    // 缓存管理器 2.x 版本
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory){
        RedisCacheManager cacheManager = RedisCacheManager.create(connectionFactory);
        return cacheManager;
    }

    // 注册成 Bean 被 Spring 管理，如果没有这个 Bean，则 Redis 可视化工具中的中文内容（key 或 value）都会
    // 以二进制存储，不易检查
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory){
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(factory);
//        return stringRedisTemplate;
//    }
}
