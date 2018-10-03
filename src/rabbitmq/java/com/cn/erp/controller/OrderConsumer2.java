package com.cn.erp.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/getorder")
@RestController
public class OrderConsumer2 {
	  /*对列名称*/
    public final String QUEUE_NAME1 = "first-queue";
    
    /*对列名称*/
    public final String QUEUE_NAME2 = "second-queue";
	
	  @Autowired
	    private RabbitTemplate rabbitTemplate;
	 
	
	@RequestMapping("/order1")
	public Object testName() {
	 Message message=	rabbitTemplate.receive(QUEUE_NAME2);
		System.out.println(message);
		
		return message;
		
	}

}
