package net.sea4.demo.redis.pupsub.service;

import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import net.sea4.demo.redis.pupsub.dto.SampleMessage;
import org.springframework.data.redis.connection.ReactiveSubscription.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPubService {
<<<<<<< HEAD
	//private final RedisTemplate<String, Object> redisTemplate;

//	public void sendMessage(ChatMessage chatMessage) {
//		redisTemplate.convertAndSend("topic1", chatMessage);
//	}
=======

	private final RedisTemplate<String, Object> redisTemplate;

	public void publish(ChannelTopic topic, SampleMessage message) {
		redisTemplate.convertAndSend(topic.getTopic(), message);
	}
>>>>>>> 9faf0ad69ca4abed73f474fcee913c26b269bf2b
}
