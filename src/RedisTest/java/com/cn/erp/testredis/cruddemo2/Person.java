package com.cn.erp.testredis.cruddemo2;  
  
import java.io.Serializable;  
  
@SuppressWarnings("serial")  
public class Person implements Serializable {  
    private int id;  
    private String name;  
  
    public Person() {  
    }  
  
    public Person(int id, String name) {  
        super();  
        this.id = id;  
        this.name = name;  
    }  
  
    public int getId() {  
        return id;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
}  