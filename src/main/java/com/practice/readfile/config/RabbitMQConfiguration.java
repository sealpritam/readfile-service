package com.practice.readfile.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
	
	@Autowired
	private CachingConnectionFactory cachingConnectionFactory;
	
	@Autowired
	private RabbitProperties rabbitProperties;
	
	
	
	

}
