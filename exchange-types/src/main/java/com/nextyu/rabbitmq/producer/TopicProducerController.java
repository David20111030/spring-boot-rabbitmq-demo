package com.nextyu.rabbitmq.producer;

import cn.hutool.core.lang.Console;
import com.nextyu.rabbitmq.config.RabbitMQConfigWithTopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("topic")
@RestController
public class TopicProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMessage")
    public Object sendMessage() {
        new Thread(() -> {
            int count = 1;
            for (int i = 0; i < count; i++) {
                String value = "apple " + i;
                Console.log("apple send message {}", value);
                rabbitTemplate.convertAndSend(RabbitMQConfigWithTopicExchange.EXCHANGE_NAME, RabbitMQConfigWithTopicExchange.ROUTING_KEY_APPLE, value);
            }

            for (int i = 0; i < count; i++) {
                String value = "banana " + i;
                Console.log("banana send message {}", value);
                rabbitTemplate.convertAndSend(RabbitMQConfigWithTopicExchange.EXCHANGE_NAME, RabbitMQConfigWithTopicExchange.ROUTING_KEY_BANANA, value);
            }


            for (int i = 0; i < count; i++) {
                String value = "orange " + i;
                Console.log("orange send message {}", value);
                rabbitTemplate.convertAndSend(RabbitMQConfigWithTopicExchange.EXCHANGE_NAME, RabbitMQConfigWithTopicExchange.ROUTING_KEY_ORANGE, value);
            }
        }).start();
        return "ok";
    }

}
