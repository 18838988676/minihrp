package com.cn.erp.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class StoreService {
	public void update(Object object1) throws Exception {
		Thread.sleep(14000);
		int a=1/0;
		System.out.println("11处理成功b000000000000000000u ");
	}

}
