package net.sea4.demo.redis.pupsub.config.redis;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
=======
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
<<<<<<< HEAD
=======
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Slf4j
@Configuration
<<<<<<< HEAD
=======
@EnableCaching
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
public class RedisConfig {

	@Value("${redis.session.host}")
	private String host;

	@Value("${redis.session.port}")
	private Integer port;

	@Value("${redis.session.password}")
	private String password;

	@Value("${redis.session.ssl}")
	private Boolean ssl;

<<<<<<< HEAD

=======
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host, port);
		if (StringUtils.isNotEmpty(password)) {
			redisStandaloneConfiguration.setPassword(password);
		}
		redisStandaloneConfiguration.setDatabase(0);

		return new LettuceConnectionFactory(redisStandaloneConfiguration, getLettuceClientConfiguration());
	}

	private LettuceClientConfiguration getLettuceClientConfiguration() {
		if (ssl) {
			return LettuceClientConfiguration.builder()
				.useSsl()
				.disablePeerVerification()
				.and()
				.commandTimeout(Duration.ofSeconds(2))
				.shutdownTimeout(Duration.ofSeconds(20))
				.build();
		}

		return LettuceClientConfiguration.builder()
			.commandTimeout(Duration.ofSeconds(2))
			.shutdownTimeout(Duration.ofSeconds(20))
			.build();
	}


<<<<<<< HEAD
	@Bean
	public RedisTemplate<String, Object> redisSessionTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
=======
	// redis를 경청하고 있다가 메시지 발행(publish)이 오면 Listener가 처리합니다.
	@Bean
	public RedisMessageListenerContainer RedisMessageListener(RedisConnectionFactory connectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		return container;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplateForObject(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
		return redisTemplate;
	}
}
