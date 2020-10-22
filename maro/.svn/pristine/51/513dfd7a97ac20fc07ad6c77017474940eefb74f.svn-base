package com.maro.client.common.mq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {

private final static String QUEUE_NAME = "rabbit.test";

public static void main(String[] args) throws IOException, TimeoutException {

ConnectionFactory factory = new ConnectionFactory();

   factory.setHost("127.0.0.1");

   Connection connection = factory.newConnection();

   final Channel channel = connection.createChannel();

   channel.queueDeclare(QUEUE_NAME, false, false, false, null);

   System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

   

   DefaultConsumer consumer = new DefaultConsumer(channel) {

   	 public void handleDelivery(String consumerTag, Envelope envelope,

								AMQP.BasicProperties properties, byte[] body)

   	     throws IOException {

   	   String message = new String(body, "UTF-8");

   	   System.out.println(" [x] Received '" + message + "'");

		 channel.basicReject(envelope.getDeliveryTag(), true);

   	 }

   	};

   	channel.basicConsume(QUEUE_NAME, true, consumer);

}

}