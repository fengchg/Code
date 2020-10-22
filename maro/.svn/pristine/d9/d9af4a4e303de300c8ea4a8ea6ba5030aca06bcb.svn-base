package com.maro.client.common.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by ganguixiang on 2018/6/3.
 */
public class Publisher {

    private static final String exchangeName = "rabbit.test";

    private static final String routingKey = "rabbit.test";

    private static final String queueName = "rabbit.test";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername("admin");
//        factory.setPassword("gbiac@2016");
//        factory.setVirtualHost("/");
        factory.setHost("127.0.0.1");
        factory.setPort(5672);

        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        channel.exchangeDeclare(exchangeName, "topic", true);

        channel.queueDeclare(queueName, true, false, false, null);

        channel.queueBind(queueName, exchangeName, routingKey);

        byte[] messageBodyBytes = "Hello, world!".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();

    }
}
