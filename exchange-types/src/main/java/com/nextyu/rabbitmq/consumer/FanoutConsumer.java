package com.nextyu.rabbitmq.consumer;

import cn.hutool.core.lang.Console;
import com.nextyu.rabbitmq.config.RabbitMQConfigWithFanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("fanout")
@Component
public class FanoutConsumer {

    @RabbitListener(queues = RabbitMQConfigWithFanoutExchange.QUEUE_NAME_APPLE)
    public void consumeMessage1(String message) {
        Console.log("apple consume message {}", message);
    }

    @RabbitListener(queues = RabbitMQConfigWithFanoutExchange.QUEUE_NAME_BANANA)
    public void consumeMessage2(String message) {
        Console.log("banana consume message {}", message);
    }

    @RabbitListener(queues = RabbitMQConfigWithFanoutExchange.QUEUE_NAME_ORANGE)
    public void consumeMessage3(String message) {
        Console.log("orange consume message {}", message);
    }
}
