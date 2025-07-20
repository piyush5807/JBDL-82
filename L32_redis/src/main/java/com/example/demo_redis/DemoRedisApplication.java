package com.example.demo_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
public class DemoRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisApplication.class, args);

//		String result = "Test String";
//
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		byte[] output = stringRedisSerializer.serialize(result);
//
//		JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
//		byte[] output2 = jdkSerializationRedisSerializer.serialize(result);
//
//		System.out.println(output);
//		System.out.println(output2);

	}

}
