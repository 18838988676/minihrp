package com.cn.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.entity.DispensingEntity;
import com.cn.erp.service.DispensingService;


@RestController
@RequestMapping("/demo")
public class DispensingController1 {
	
	@Autowired
	private DispensingService dispensingService;
	
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
