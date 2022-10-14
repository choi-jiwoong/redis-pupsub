package net.sea4.demo.redis.pupsub.service;

import lombok.RequiredArgsConstructor;
import net.sea4.demo.redis.pupsub.dto.SampleMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPubService {
	private final RedisTemplate<String, Object> redisTemplate;

	public void publish(ChannelTopic topic, SampleMessage message) {
		redisTemplate.convertAndSend(topic.getTopic(), message);
	}

}
