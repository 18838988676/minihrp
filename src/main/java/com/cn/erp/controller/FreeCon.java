package com.cn.erp.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/free")
public class FreeCon {
	
	@RequestMapping("/index")
	public String  testName()  {
		System.out.println("dddfa");
		 return "/index";
	}
	
	@RequestMapping("/index2")
	public String  testName2()  {
		System.out.println("dddfa");
		 return "/a/a";
	}
	
	
	@RequestMapping("/testfree4")
	public String  testfree4(Map<String,Object> map)  {
		
		
		 return "testfree4";
	}
	

	@RequestMapping("/testfree3")
	public String  testfree3(Map<String,Object> map)  {
		List<Integer> aIntegers=new ArrayList<Integer>();
		aIntegers.add(321);
		aIntegers.add(111);
		aIntegers.add(987);
		map.put("list", aIntegers);
		List<Map<String, Object>> mapss=new ArrayList<Map<String, Object>>();
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("name", "6666dfadjskl");
		map2.put("age", "999877");
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("name", "000...");
		map3.put("age", "+++566");
		mapss.add(map3);
		mapss.add(map2);
		map.put("maps", mapss);
		
		
		map.put("bb", "123456565656");
		
		
		 return "testfree3";
	}
	
	@RequestMapping("/testfree2")
	public String  testfree2(Map<String,Object> map)  {
		
		map.put("name", "666");
		map.put("n1", 42);
		map.put("n2", 42);
		map.put("n3", 42);
		map.put("n4", 42);
		map.put("lastUpdated", new Date());
		map.put("foo", true);
		
		 return "testfree2";
	}
	
	
	@RequestMapping("/testfree1")
	public String  testfree(Map<String,Object> map)  {
		map.put("name", "[Angel -- 守护天使]");  
	       map.put("gender",1);//gender:性别，1：男；0：女；  
	       List<Map<String,Object>> friends =new ArrayList<Map<String,Object>>();  
	       Map<String,Object> friend = new HashMap<String,Object>();  
	       friend.put("name", "张三");  
	       friend.put("age", 20);  
	       friends.add(friend);  
	       friend = new HashMap<String,Object>();  
	       friend.put("name", "李四");  
	       friend.put("age", 22);  
	       friends.add(friend);  
	       map.put("friends", friends);  
		 return "testfree1";
	}
	
	
	
	
	

}
