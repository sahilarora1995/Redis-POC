package com.example.jedis.Redis

import com.example.jedis.Model.User
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer

@SpringBootApplication
@ComponentScan(basePackages="com.example.jedis")
class RedisApplication {

	public @Value('${spring.redis.host}') String redisHost
	public @Value('${spring.redis.port}') String redisPort

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, User> redisTemplate() {
		final RedisTemplate<String, User> template = new RedisTemplate<String, User>();
		template.setConnectionFactory(redisConnectionFactory());
		//template.setValueSerializer(new GenericToStringSerializer<User>(User.class));
		System.out.println("Connection established ! ");
		return template;
	}
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
