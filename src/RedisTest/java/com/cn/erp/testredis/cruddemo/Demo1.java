package com.cn.erp.testredis.cruddemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.util.SafeEncoder;

public class Demo1 {

    public static Jedis buildJedis() {
        String host = "127.0.0.1";// ip
        int port = 6380;// 默认端口
        Jedis jedis = new Jedis(host, port);
//        jedis.auth("tiger");// 配置通行证密码
        return jedis;
    }

    public static void main(String[] args) throws InterruptedException {
        boolean btemp = false;
        long ltemp = 0L;
        String value = null;
        List<String> values = null;
        Jedis jedis = buildJedis();

        // 删除测试值
        jedis.select(0);
        jedis.del("key3");
        jedis.select(1);
        jedis.del("key3");
        jedis.select(0);

        jedis.set("key", "cjw");// 创建key
        value = jedis.get("key");// 获取key
        System.out.println("value: " + value);// value: cjw
        jedis.del("key");// 删除key
        value = jedis.get("key");
        System.out.println("value: " + value);// value: null
        btemp = jedis.exists("key");
        System.out.println("key是否存在: " + btemp);// key是否存在: false
        jedis.set("key2", "我是key2的值");// 创建key
        jedis.expire("key2", 2);// 设置key的生存时间,单位为秒
        value = jedis.get("key2");
        System.out.println("value: " + value);// value: 我是key2的值
        System.out.println("线程休眠中--------------");
        Thread.sleep(2000);// 线程休眠2秒
        value = jedis.get("key2");
        System.out.println("value: " + value);// value: null
        // jedis.expireAt(key, unixTime) //设置生存时间,参数为时间戳这里不演示
        jedis.set("key3", "我是key3的值");// 创建key
        // KEYS * 匹配数据库中所有 key 。
        // KEYS h?llo 匹配 hello ， hallo 和 hxllo 等。
        // KEYS h*llo 匹配 hllo 和 heeeeello 等。
        // KEYS h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。
        Set<String> keys = jedis.keys("*");// 获取所有key,这里不迭代演示
        jedis.select(1);// jedis默认数据库为0,这里选择数据库为1
        value = jedis.get("key3");
        System.out.println("value: " + value);// value: null 原来在数据库0的key3找不到
        jedis.select(0);// 切换为0数据库
        jedis.move("key3", 1);// 将当前数据库的key3移动到数据库1里面
        value = jedis.get("key3");
        System.out.println("value: " + value);// value: null
        jedis.select(1);// 切换到1数据库
        jedis.expire("key3", 200);
        ltemp = jedis.ttl("key3");// 返回剩余秒数
        System.out.println("剩余生存时间: " + ltemp);
        
        System.out.println("========"+SafeEncoder.encode("key3"));
        
        
        ltemp = jedis.pttl("key3");// 返回剩余生存毫秒数
        
        System.out.println("剩余生存时间: " + ltemp);
        jedis.persist("key3");// 移除key3的生存时间,转为永久
        System.out.println("线程休眠中--------------");
        Thread.sleep(2000);
        value = jedis.get("key3");
        System.out.println("value: " + value);// value: 我是key3的值
        jedis.rename("key3", "key4");// 重命名key
        value = jedis.get("key4");
        System.out.println("value: " + value);// value: 我是key3的值
        jedis.renamenx("key4", "key3");// 当新key名没有被使用才改名称
        value = jedis.type("key3");
        System.out.println("key3的储存类型: " + value);// key3的储存类型: string
        jedis.set("key4", "10");// 创建key
        jedis.decr("key4");// 使key4的数值减1
        value = jedis.get("key4");
        System.out.println("value: " + value);// value: 9
        jedis.decrBy("key4", 5);// 使key4减去指定数值
        value = jedis.get("key4");
        System.out.println("value: " + value);// value: 4
        jedis.incr("key4");// 使key4的数值加1
        jedis.incrBy("key4", 5);// 加上指定数值
        value = jedis.get("key4");
        System.out.println("value: " + value);// value: 10
        List<String> keyList = jedis.mget("key3", "key4");// 查询多个key

        // hash表操作
        Map<String, String> userMap = new HashMap<String, String>();
        userMap.put("name", "小明");
        userMap.put("age", "16");
        jedis.hmset("key5", userMap);
        values = jedis.hmget("key5", "name");
        for (String str : values) {
            System.out.println("遍历key5的field的值: " + str);
            // 遍历key5的field的值: 小明
        }
        values = jedis.hmget("key5", "age");
        for (String str : values) {
            System.out.println("遍历key5的field的值: " + str);
            // 遍历key5的field的值: 16
        }
        values = jedis.hvals("key5");// 返回key5的所有field的值
        for (String str : values) {
            System.out.println("遍历key5的field的值: " + str);
            // 遍历key5的field的值: 16
            // 遍历key5的field的值: 小明
        }
        value = jedis.hget("key5", "name");// 获取指定key指定域的值
        System.out.println("value: " + value);// value: 小明
        jedis.hset("key5", "name", "小勇");// 创建hash表的值
        value = jedis.hget("key5", "name");// 获取指定key指定域的值
        System.out.println("value: " + value);// value: 小勇

        // redis还有很多数据类型这里就不一一尝试了
    }
}
// value: cjw
// value: null
// key是否存在: false
// value: 我是key2的值
// 线程休眠中--------------
// value: 我是key2的值
// value: null
// value: null
// 剩余生存时间: 2
// 剩余生存时间: 1999
// 线程休眠中--------------
// value: 我是key3的值
// value: 我是key3的值
// key3的储存类型: string
// value: 9
// value: 4
// value: 10
// 遍历key5的field的值: 小明
// 遍历key5的field的值: 16
// 遍历key5的field的值: 16
// 遍历key5的field的值: 小明
// value: 小明
// value: 小勇
