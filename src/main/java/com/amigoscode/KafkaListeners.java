package com.amigoscode;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

	@KafkaListener(topics = "amigoscode", groupId = "foo")
	public void listener(Message data) {
		System.out.println("Received Message -> " + data.toString());
	}
}
