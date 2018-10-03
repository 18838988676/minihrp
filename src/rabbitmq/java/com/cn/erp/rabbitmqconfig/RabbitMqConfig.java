package com.cn.erp.rabbitmqconfig;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * RabbitMq配置
 * @author zhuzhe
 * @date 2018/5/25 13:37
 * @email 1529949535@qq.com
 */
@Configuration
public class RabbitMqConfig {
 
    /**
     * key: queue在该direct-exchange中的key值，当消息发送给direct-exchange中指定key为设置值时，
     * 消息将会转发给queue参数指定的消息队列
     */
    /** 队列key1*/
    public static final String ROUTING_KEY_1 = "queue_one_key1";
    
    /** 队列key2*/
    public static final String ROUTING_KEY_2 = "queue_one_key2";
    
    /** 队列key3*/
    public static final String ROUTING_KEY_3 = "queue_one_key3";
    
 
    @Autowired
    private QueueConfig queueConfig;
 
    @Autowired
    private ExchangeConfig exchangeConfig;
 
    /**
     * 将消息队列1和交换机1进行绑定,指定队列key1
     */
    @Bean
    public Binding binding_one() {
        return BindingBuilder.bind(queueConfig.firstQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTING_KEY_1);
    }
    
    
    /**
     * 将消息队列2和交换机1进行绑定,指定队列key2
     */
    @Bean
    public Binding binding_two() {
        return BindingBuilder.bind(queueConfig.secondQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTING_KEY_2);
    }
    
    
    /**
     * 将消息队列3和交换机1进行绑定,指定队列key3
     */
    @Bean
    public Binding binding_thread() {
        return BindingBuilder.bind(queueConfig.thirdQueue()).to(exchangeConfig.directExchange()).with(RabbitMqConfig.ROUTING_KEY_3);
    }
    
    
    
    
}
