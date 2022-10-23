package net.sea4.demo.redis.pupsub.config.redis;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableCaching
public class RedisConfig {


	@Value("${redis.session.host}")
	private String host;

	@Value("${redis.session.port}")
	private Integer port;

	@Value("${redis.session.password}")
	private String password;

	@Value("${redis.session.ssl}")
	private Boolean ssl;


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

	@Bean
	public RedisTemplate<String, Object> redisSessionTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}
}
