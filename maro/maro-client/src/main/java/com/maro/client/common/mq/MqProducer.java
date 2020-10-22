package com.maro.client.common.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import net.sf.json.JSONObject;

import java.io.IOException;

public class MqProducer {

    private String exchangeName;
    private String routingKey;
    private String queueName;
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;

    public void sendMsg(Object object) throws IOException {
        String message = "";
        if(connection == null){
            connection = factory.newConnection();
        }
        if(channel == null){
            channel = connection.createChannel();
            channel.exchangeDeclare(exchangeName, "topic", true);
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, exchangeName, routingKey);
        }
        if(!(object instanceof String)){
            message = JSONObject.fromObject(object).toString();
        }else{
            message = (String) object;
        }
        channel.basicPublish(exchangeName, routingKey, null, message.getBytes("UTF-8"));
    }

    public ConnectionFactory getFactory() {
        return factory;
    }

    public void setFactory(ConnectionFactory factory) {
        this.factory = factory;
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
