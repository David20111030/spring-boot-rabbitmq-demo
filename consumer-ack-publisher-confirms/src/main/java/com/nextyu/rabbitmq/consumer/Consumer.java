package com.nextyu.rabbitmq.consumer;

import cn.hutool.core.lang.Console;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class Consumer implements ChannelAwareMessageListener {

    @Autowired
    private MessageConverter messageConverter;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        long deliveryTag = messageProperties.getDeliveryTag();
        Boolean redelivered = messageProperties.getRedelivered();
        Console.log("consume message = {} , deliveryTag = {} , redelivered = {}"
                , messageConverter.fromMessage(message), deliveryTag, redelivered);

        channel.basicAck(deliveryTag, false);

//        channel.basicNack(deliveryTag, false, false);
//        channel.basicReject(deliveryTag,false);

    }
}

