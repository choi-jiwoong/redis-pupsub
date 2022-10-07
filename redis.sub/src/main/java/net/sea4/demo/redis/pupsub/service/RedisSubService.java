package net.sea4.demo.redis.pupsub.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubService implements MessageListener {
	public static List<String> messageList = new ArrayList<>();
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public void onMessage(Message message, byte[] pattern) {

	}
}
