package com.cn.erp.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.entity.DispensingEntity;
import com.cn.erp.service.DispensingService;

/**
 * 疾病档案
 *
 * @author wmc
 * @email 18838988676@gmail.com
 * @date 2018-08-18 20:19:54
 */
@RestController
@RequestMapping("/dispensingController")
public class DispensingController {
	
	@Autowired
	private DispensingService dispensingService;
	
	/*
	 * 
	 */
	
	
	public void findAll(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("/find")
	public DispensingEntity testDispensingEntity(){
		return dispensingService.findall("1");
	}
	
	@ResponseBody
	@RequestMapping("/ins")
	public DispensingEntity insert(){
		dispensingService.inser();
		return dispensingService.findall("1");
	}
	
	

}
