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
    public final static String ROUTING_KEY_APPLE = "fruit.apple";
    public final static String ROUTING_KEY_BANANA = "fruit.banana";
    public final static String ROUTING_KEY_ORANGE = "fruit.orange";
    public final static String ROUTING_KEY = "fruit.apple";
    public final static String ROUTING_KEY_2 = "fruit.*";
    public final static String ROUTING_KEY_3 = "fruit#";
    public final static String EXCHANGE_NAME = "topic.exchange";

    // 创建队列
    @Bean
    public Queue queueApple() {
        return new Queue(QUEUE_NAME_APPLE);
    }

    @Bean
    public Queue queueBanana() {
        return new Queue(QUEUE_NAME_BANANA);
    }

    @Bean
    public Queue queueOrange() {
        return new Queue(QUEUE_NAME_ORANGE);
    }

    // 创建一个 topic 类型的交换器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
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
