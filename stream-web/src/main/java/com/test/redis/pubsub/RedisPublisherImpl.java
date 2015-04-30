package com.test.redis.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class RedisPublisherImpl implements RedisPublisher {
	
	@Autowired
	private  RedisTemplate<String, Object> template;
	
	@Autowired
	private  ChannelTopic topic;
	

	
	public RedisPublisherImpl(){
		
	}
	
	public RedisPublisherImpl(final RedisTemplate<String, Object> template,
			final ChannelTopic topic) {
		this.template = template;
		this.topic = topic;
	}

	@Scheduled(fixedDelay = 2000)
	public void publish() {
		
		EventData data = new EventData(getRandomNumber(10, 60));
	
		template.convertAndSend(topic.getTopic(),
				 new Gson().toJson(data));
	}
	
	private Integer getRandomNumber(int min, int max) {
	    return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}
}