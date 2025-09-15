package org.aptech.t2311e.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration // todo : bean configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> initRedisTemplate(RedisConnectionFactory connectionFactory){
        System.err.println("Init bean redis connection template");
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // todo : step1 : connect to redis
        redisTemplate.setConnectionFactory(connectionFactory);
        // config how to serializer redis key and value
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

}
