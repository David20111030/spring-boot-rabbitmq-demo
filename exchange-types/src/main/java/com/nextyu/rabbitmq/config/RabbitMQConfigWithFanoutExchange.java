package com.nextyu.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("fanout")
@Configuration
public class RabbitMQConfigWithFanoutExchange {

    public final static String QUEUE_NAME_APPLE = "fanout.exchange.queue.apple";
    public final static String QUEUE_NAME_BANANA = "fanout.exchange.queue.banana";
    public final static String QUEUE_NAME_ORANGE = "fanout.exchange.queue.orange";
    public final static String ROUTING_KEY_APPLE = "fanout.exchange.key.apple";
    public final static String ROUTING_KEY_BANANA = "fanout.exchange.key.banana";
    public final static String ROUTING_KEY_ORANGE = "fanout.exchange.key.orange";
    public final static String EXCHANGE_NAME = "fanout.exchange";

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

    // 创建一个 fanout 类型的交换器
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    // 把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding bindingApple(Queue queueApple, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueApple).to(fanoutExchange);
    }

    @Bean
    public Binding bindingBanana(Queue queueBanana, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueBanana).to(fanoutExchange);
    }

    @Bean
    public Binding bindingOrange(Queue queueOrange, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueOrange).to(fanoutExchange);
    }
    

}
