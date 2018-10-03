package com.cn.erp.controller;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
import java.io.IOException;
 
/**
 * 负责接收处理订单服务发送的消息
 * @author zhuzhe
 * @date 2018/6/7 10:09
 * @email 1529949535@qq.com
 */
@Slf4j     
@Component
public class OrderConsumer {
 
    /*对列名称*/
    public final String QUEUE_NAME1 = "first-queue";
 
    /**
     * queues  指定从哪个队列（queue）订阅消息
     * @param message
     * @param channel
     */
    @RabbitListener(queues = {QUEUE_NAME1})
    public void handleMessage(Message message,Channel channel) throws IOException {
        try {
            // 处理消息
            System.out.println("OrderConsumer {} handleMessage :"+message);
            System.out.println(new String(message.getBody()));
        }catch (Exception e){
        }
    }
}
