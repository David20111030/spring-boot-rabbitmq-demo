package com.nextyu.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("topic")
@Configuration
public class RabbitMQConfigWithTopicExchange {

    public final static String QUEUE_NAME_APPLE = "topic.exchange.queue.apple";
    public final static String QUEUE_NAME_BANANA = "topic.exchange.queue.banana";
    public final static String QUEUE_NAME_ORANGE = "topic.exchange.queue.orange";
    public final static String ROUTING_KEY_APPLE = "topic.exchange.key.apple";
    public final static String ROUTING_KEY_BANANA = "topic.exchange.key.banana";
    public final static String ROUTING_KEY_ORANGE = "topic.exchange.key.orange";
    public final static String ROUTING_KEY = "topic.exchange.key.*";
    public final static String ROUTING_KEY_2 = "topic.#";
    public final static String ROUTING_KEY_3 = "topic.*.key.*";
    public final static String EXCHANGE_NAME = "topic.exchange";

    // 创建队列
    @Bean
    public Queue queueApple() {
        return new Queue(QUEUE_NAME_APPLE, false, false, true);
    }

    @Bean
    public Queue queueBanana() {
        return new Queue(QUEUE_NAME_BANANA, false, false, true);
    }

    @Bean
    public Queue queueOrange() {
        return new Queue(QUEUE_NAME_ORANGE, false, false, true);
    }

    // 创建一个 topic 类型的交换器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME, false, true);
    }

    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding bindingApple(Queue queueApple, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueApple).to(topicExchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingBanana(Queue queueBanana, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueBanana).to(topicExchange).with(ROUTING_KEY_2);
    }

    @Bean
    public Binding bindingOrange(Queue queueOrange, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueOrange).to(topicExchange).with(ROUTING_KEY_3);
    }


}
