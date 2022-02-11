package com.practice.readfile.publish.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.practice.readfile.publish.MessagePublisher;

@Component
@EnableBinding(MessagePublisher.class)
public class DataPublish {
	
	@Autowired
	private MessagePublisher messagePublisher;
	
	public boolean sendToDBService(String message) {
		return messagePublisher.publishToDBService().send(MessageBuilder.withPayload(message).build());
	}
	
}
