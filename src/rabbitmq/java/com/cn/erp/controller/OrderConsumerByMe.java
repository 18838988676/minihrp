package com.cn.erp.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.rabbitmqentity.Order;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@RequestMapping("/getorder")
@RestController
public class OrderConsumerByMe {
	  /*对列名称*/
    public final String QUEUE_NAME1 = "first-queue";
    
    /*对列名称*/
    public final String QUEUE_NAME2 = "second-queue";
	
	  @Autowired
	    private RabbitTemplate rabbitTemplate;
	  @Autowired
	    private StoreService storeService;
	
	@RequestMapping("/order1")
	public Object testName()  {
	 Message message=	rabbitTemplate.receive(QUEUE_NAME2);
        try {
        	int a=1/0;
			storeService.update(new Gson().fromJson(new String(message.getBody()),Order.class));
		
        }  catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		return message;
		
	}

}
