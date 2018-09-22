package com.cn.erp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.erp.entity.User;



@RestController
@RequestMapping("/t1")
public class QController {
	
	
	//第一种，表单的name属性值必须和接受的参数同名。否则，接收到的参数为null，但不报错
		@RequestMapping("/buxiangtong")
		public void test1(String  t1name,String t1password,Integer  t1age) {
			System.out.println(t1name);
			System.out.println(t1password);
			System.out.println(t1age);
		}
		
		//第二种，表单的name属性值必须和接收对象的属性同名。否则，接收到的参数为null，但不报错
//		 注意1：即使我们的Action使用第二种方式（选用User类对象作为参数），前台界面也不能写成user.username ，
//		后台这样会接收失败，得到的值是null。这一点如果没记错的话，应该和Struts2是不一样的
		@RequestMapping("/xiangtong")
		public void test2(User user) {
			System.out.println(user);
		}
		
		
		//params： 指定request中必须包含某些参数值是，才让该方法处理。
		//href="/t1/t3?age=22"  可以访问  ，href="/t1/t3" 不能访问
		@RequestMapping(params="age",value="/t3")
		public void test3(String age) {
			System.out.println(age);
			//22
		}
		
		
		//@PathVariable   用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出uri模板中的变量作为参数。如：
		 @RequestMapping(value="/user/{userId}/roles/{roleId}",method = RequestMethod.GET)  
	     public String getLogin(@PathVariable("userId") String userId,  @PathVariable("roleId") String roleId){  
	         System.out.println("User Id : " + userId);  
	         System.out.println("Role Id : " + roleId);  
	         return "hello";  
	    //<a href="/t1/user/thisUserId/roles/thisRoleID">t4</a>
//	         User Id : thisUserId
//	         Role Id : thisRoleID
		 }  
		
		//@requestParam  主要用于在SpringMVC后台控制层获取参数，类似一种是request.getParameter("name")，
//		 它有三个常用参数：defaultValue = "0", required = false, value = "isApp"；defaultValue 表示设置默认值，
//		 required 铜过boolean设置是否是必须要传入的参数，value 值表示接受的传入的参数类型。
		
		 	@RequestMapping(params="age",value="/t4")
			public void test4(@RequestParam(name="age") String age,@RequestParam(name="add",required=false) String address) {
		 		System.out.println(age);
		 		System.out.println(address);
		 		
//		 		<a href="/t1/t4?age=654&add='***--****'">@requestParam</a>  age 与 add和  name是一一对应的   ，如果不对应 则报错 ，除非 required=false  或加上defaultValue

				/*<form action="/t1/t4" method="post">
					<input type="text"  name="age">
					<input type="text"  name="add">
					<input type="text"  name="age1">
					<input type="submit" name="提交">
				</form>
				也可让表单传入值，但  age 和  add可以传入
				*/
			}
		

}
