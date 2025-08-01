package com.example.demo_redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {


    @Bean
    public RedisConnectionFactory getConnectionFactory(){

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                "redis-14354.c14.us-east-1-3.ec2.redns.redis-cloud.com", 14354);

        redisStandaloneConfiguration.setPassword("hel88tkcZQsX0a9LiLjWoItDdITqMXOO");

        RedisConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> getTemplate(){

        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(getConnectionFactory());
        template.setValueSerializer(new StringRedisSerializer());
        template.setKeySerializer(new JdkSerializationRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return template;
    }

    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }
}
