package com.cn.erp.entity;

public class User {
		private String name1;
		private String pass1;
		private Integer age1;
		public String getName1() {
			return name1;
		}
		public void setName1(String name1) {
			this.name1 = name1;
		}
		public String getPass1() {
			return pass1;
		}
		public void setPass1(String pass1) {
			this.pass1 = pass1;
		}
		public Integer getAge1() {
			return age1;
		}
		public void setAge1(Integer age1) {
			this.age1 = age1;
		}
		@Override
		public String toString() {
			return "User [name1=" + name1 + ", pass1=" + pass1 + ", age1="
					+ age1 + "]";
		}
		
		

}
