package com.maro.client.common.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

private final static String QUEUE_NAME = "rabbit.test";

public static void main(String[] args) throws Exception {

//连接到RabbitMQ服务器

ConnectionFactory factory = new ConnectionFactory();

factory.setHost("127.0.0.1");

factory.setPort(5672);

Connection connection = factory.newConnection();

Channel channel = connection.createChannel();

channel.queueDeclare(QUEUE_NAME, false, false, false, null);

for(int x = 0; x<10;x++) {

String message = "我是帅哥:" + x;

channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

}

//System.out.println(" [发送完毕] Sent '" + message + "'");

//channel.close();

connection.close();

}

}