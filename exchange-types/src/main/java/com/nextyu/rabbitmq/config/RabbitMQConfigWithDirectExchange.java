package com.nextyu.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("direct")
@Configuration
public class RabbitMQConfigWithDirectExchange {

    public final static String QUEUE_NAME_APPLE = "direct.exchange.queue.apple";
    public final static String QUEUE_NAME_BANANA = "direct.exchange.queue.banana";
    public final static String QUEUE_NAME_ORANGE = "direct.exchange.queue.orange";
    public final static String ROUTING_KEY_APPLE = "direct.exchange.key.apple";
    public final static String ROUTING_KEY_BANANA = "direct.exchange.key.banana";
    public final static String ROUTING_KEY_ORANGE = "direct.exchange.key.orange";
    public final static String EXCHANGE_NAME = "direct.exchange";

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

    // 创建一个 direct 类型的交换器
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding bindingApple(Queue queueApple, DirectExchange directExchange) {
        return BindingBuilder.bind(queueApple).to(directExchange).with(ROUTING_KEY_APPLE);
    }

    @Bean
    public Binding bindingBanana(Queue queueBanana, DirectExchange directExchange) {
        return BindingBuilder.bind(queueBanana).to(directExchange).with(ROUTING_KEY_BANANA);
    }

    @Bean
    public Binding bindingOrange(Queue queueOrange, DirectExchange directExchange) {
        return BindingBuilder.bind(queueOrange).to(directExchange).with(ROUTING_KEY_ORANGE);
    }


}
