package com.example.rabbitmq.rabbitmq.listener;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	static final String MY_QUEUE = "MyQueue";

	@Bean
	public Queue myQueue() {
		return new Queue( MY_QUEUE, true );
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(
				"localhost" );
		cachingConnectionFactory.setUsername( "guest" );
		cachingConnectionFactory.setPassword( "guest" );
		return cachingConnectionFactory;
	}

	@Bean
	public TopicExchange myExchange() {
		return ExchangeBuilder.topicExchange( "MyTopicExchange" ).durable( true ).build();
	}

	@Bean
	public Binding queueBinding() {
		return BindingBuilder.bind( myQueue() )
				.to( myExchange() )
				.with( "topic" );
	}

	@Bean
	SimpleMessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
		messageListenerContainer.setConnectionFactory( connectionFactory() );
		messageListenerContainer.setMessageListener( new RabbitMQMessageListener() );
		messageListenerContainer.setQueues( myQueue() );
		return messageListenerContainer;
	}

	public static String getQueue_name() {
		return MY_QUEUE;
	}
}
