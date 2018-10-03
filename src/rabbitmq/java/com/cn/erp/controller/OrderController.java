package com.cn.erp.controller;


import com.cn.erp.rabbitmqentity.Order;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.UUID;
 
/**
 * @author zhuzhe
 * @date 2018/6/7 9:48
 * @email 1529949535@qq.com
 */
@RequestMapping("/order")
@RestController
public class OrderController {
 
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    /**
     * 保存order , 同时需要向store服务发送通知减库存
     * @param order
     * @return
     */
    @RequestMapping("/save")
    public Order saveOrder(Order order){
    	System.out.println(order);
        Gson gson = new Gson();
        //将order转换为json字符串，便于传输
        String json = gson.toJson(order);
        String msgId = UUID.randomUUID().toString();
        /**
         * 发送消息
         * 指定消息交换机  "first_exchange"
         * 指定队列key    "queue_one_key1"
         */
        rabbitTemplate.convertAndSend("first_exchange", "queue_one_key1",
                json, new CorrelationData(msgId));
        
        rabbitTemplate.convertAndSend("first_exchange", "queue_one_key2",
                "這是測試2", new CorrelationData(msgId));
        
        rabbitTemplate.convertAndSend("first_exchange", "queue_one_key3",
                "這是測試3333333333333", new CorrelationData(msgId));
        return order;
    }
}
