package com.amigoscode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/v1/messages")
public class MessageController {

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		Message message = new Message(request.message(), LocalDateTime.now());
		kafkaTemplate.send("amigoscode", message);
	}
}
