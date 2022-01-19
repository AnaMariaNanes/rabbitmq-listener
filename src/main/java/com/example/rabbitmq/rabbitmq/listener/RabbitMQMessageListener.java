package com.example.rabbitmq.rabbitmq.listener;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageListener implements MessageListener {

	@Override
	public void onMessage( final Message message ) {
		System.out.println( "message = [" + new String( message.getBody() ) + "]" );
	}

	@Override
	public void containerAckMode( final AcknowledgeMode mode ) {
		MessageListener.super.containerAckMode( mode );
	}

	@Override
	public void onMessageBatch( final List<Message> messages ) {
		MessageListener.super.onMessageBatch( messages );
	}
}
