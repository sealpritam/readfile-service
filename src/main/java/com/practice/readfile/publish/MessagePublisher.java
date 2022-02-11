package com.practice.readfile.publish;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MessagePublisher {
	
	String SEND_TO_DB_SERVICE = "sendToDBService";
	
	@Output(MessagePublisher.SEND_TO_DB_SERVICE)
	SubscribableChannel publishToDBService();

}
