package com.cn.erp.testredis.cruddemo2;  
  
import redis.clients.jedis.Jedis;  
  
public class PersonRedisSerializeTest {  
      
    public static void main(String[] args) {  
        PersonRedisSerializeTest test = new PersonRedisSerializeTest();  
        test.setObject(); //序列化  
        test.getObject(); //反序列化  
          
    }  
  
    /** 
     * 序列化写对象, 将Person对象写入Redis中 
     *  
     * 我们到命令行窗口中读取该对象，看看有没有写入成功： 
     *    redis 127.0.0.1:6379> get person:100 
     *    "\xac\xed\x00\x05sr\x00\x19com.jiangge.jrtest.Person\xfa\x13\xad$\x8e$\xfc\x80\x 
     *    02\x00\x02I\x00\x02idL\x00\x04namet\x00\x12Ljava/lang/String;xp\x00\x00\x00dt\x0 
     *    0\tyixiaohan" 
     * 可以取到序列化之后的值。 
     */  
    public void setObject() {  
        Jedis jedis=new Jedis("localhost");   
        jedis.set("person:100".getBytes(), SerializeUtil.serialize(new Person(100, "yixiaohan")));  
        jedis.set("person:101".getBytes(), SerializeUtil.serialize(new Person(101, "xiaowei")));  
    }  
      
      
    /** 反序列化取对象 */  
    public void getObject() {  
        Jedis jedis=new Jedis("localhost");   
        byte[] data100= jedis.get(("person:100").getBytes());  
        Person person100 = (Person) SerializeUtil.unserialize(data100);  
        System.out.println(String.format("person:100->id=%s,name=%s", person100.getId(), person100.getName()));  
          
        byte[] data101= jedis.get(("person:101").getBytes());  
        Person person101 = (Person) SerializeUtil.unserialize(data101);  
        System.out.println(String.format("person:101->id=%s,name=%s", person101.getId(), person101.getName()));  
    }  
      
      
}  