package com.example.rabbitmq.rabbitmq.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqListenerApplication implements CommandLineRunner {

	@Override
	public void run( String... strings ) {
	}

	public static void main( String[] args ) {
		SpringApplication.run( RabbitmqListenerApplication.class, args );
	}
}
