package com.maro.client.common.mq;

import com.rabbitmq.client.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class MqCustomer {
    private static final String exchangeName = "rabbitMQ.out";

    private static final String routingKey = "rabbitMQ.out";

    private static final String queueName = "rabbitMQ.out";


    public static void main(String[] args) throws Exception {
        ConsumerThread consumerThread = new ConsumerThread();
        Thread thread = new Thread(consumerThread);
        thread.start();

    }

    static class ConsumerThread implements Runnable {

        @Override
        public void run() {
            try {
                ConnectionFactory factory = new ConnectionFactory();
                factory.setHost("127.0.0.1");
                factory.setPort(5672);

                Connection conn = factory.newConnection();
                final Channel channel = conn.createChannel();

                channel.exchangeDeclare(exchangeName, "topic", true);

                channel.queueDeclare(queueName, true, false, false, null);

                channel.queueBind(queueName, exchangeName, routingKey);
                boolean autoAck = false;
                channel.basicConsume(queueName, autoAck, "myConsumerTag",
                        new DefaultConsumer(channel) {
                            int i=0;
                            @Override
                            public void handleDelivery(String consumerTag,
                                                       Envelope envelope,
                                                       AMQP.BasicProperties properties,
                                                       byte[] body)
                                    throws IOException {
                                String routingKey = envelope.getRoutingKey();
                                String contentType = properties.getContentType();
                                long deliveryTag = envelope.getDeliveryTag();
                                // (process the message components here ...)
//                        channel.basicAck(deliveryTag, false);
                                String message = new String(body);
                                System.out.println(message);
                                if(i>=10) {
                                    channel.basicAck(deliveryTag,false);
                                }else {
                                    channel.basicReject(deliveryTag, true);
                                }
                                i++;
                            }
                        });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
