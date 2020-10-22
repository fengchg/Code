package com.maro.client.common.mq;

import com.maro.client.common.net.HttpHelper;
import com.rabbitmq.client.*;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MqCustomerListener implements Runnable{
    private ObjectMapper objectMapper = new ObjectMapper();
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private String exchangeName;
    private String routingKey;
    private String queueName;
    private String url;
    private String user;
    private String pass;

    private boolean start = false;

    public void start(){
        if(!start) {
            Thread thread = new Thread(this);
            thread.start();
            start = true;
        }

    }

    @Override
    public void run() {
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName, "topic", true);
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, exchangeName, routingKey);
            channel.basicConsume(queueName, false, "myConsumerTag", getDefaultConsumer(channel));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private DefaultConsumer getDefaultConsumer(final Channel channel){
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {
                try{
                    String serverorderDTOJson = new String(body);
                    boolean flag = false;
                    JSONObject map = new JSONObject();
                    map.put("message", serverorderDTOJson);
                    map.put("user", user);
                    map.put("pass", pass);
                    String result = HttpHelper.doPost(url, map, "utf-8");
                    if (result != null && !result.isEmpty()) {
                        if (result.contains("\"success\":true")) {
                            flag = true;
                            channel.basicAck(envelope.getDeliveryTag(),false);
                        }
                    }
                    if(!flag){
                        channel.basicReject(envelope.getDeliveryTag(),true);
                        Thread.sleep(10000);
                    }
                }catch (Exception e){
                    try {
                        channel.basicReject(envelope.getDeliveryTag(),true);
                        Thread.sleep(10000);
                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
                    } catch (IOException e1) {
//                        e1.printStackTrace();
                    }
                }
            }
        };
        return defaultConsumer;
    }

    public ConnectionFactory getFactory() {
        return factory;
    }

    public void setFactory(ConnectionFactory factory) {
        this.factory = factory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
