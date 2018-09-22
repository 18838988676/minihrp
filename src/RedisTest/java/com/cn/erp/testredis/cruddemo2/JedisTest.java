package com.cn.erp.testredis.cruddemo2;  
  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Set;  
  
import redis.clients.jedis.Jedis;  
  
public class JedisTest {  
      
    public static void main(String[] args) {  
          
        JedisTest jrd = new JedisTest();  
        jrd.test();  
    }  
      
        public void test(){  
            Jedis  jedis = new Jedis("localhost"); //连接redis  Jedis jedis = new Jedis("134.152.244.234",6379);    
//          redis.auth("redis"); //验证密码  
              
//          jedis.flushAll(); //删除所有key  
//          Set keys = jedis.keys("*");  
//          System.out.println(keys);  
              
            jedis.set("test", "helloword!");  
            jedis.set("foo", "foovaluehehehehe!");  
            String value = jedis.get("test");  
            System.out.println(value);  
              
              
            //列出所有的key，查找特定的key如：redis.keys("foo")  
            Set keys = jedis.keys("*");  
            Iterator t1 = keys.iterator() ;  
            while(t1.hasNext()){  
                Object obj1 = t1.next();  
                System.out.println(obj1);  
            }  
              
            //DEL 移除给定的一个或多个key。如果key不存在，则忽略该命令。  
            Long delResult = jedis.del("name1");  
            System.out.println("delResult ==>" + delResult);  
              
            //TTL 返回给定key的剩余生存时间(time to live)(以秒为单位)  
            Long ttlResult = jedis.ttl("foo");  
            System.out.println("ttlResult ==>" + ttlResult);  
              
            //PERSIST key 移除给定key的生存时间。  
            Long persistResult = jedis.persist("foo");  
            System.out.println("persistResult ==>" + persistResult);  
              
            //EXISTS 检查给定key是否存在。     
            Boolean existsResult = jedis.exists("foo");  
            System.out.println("existsResult ==>" + existsResult);  
              
            //MOVE key db  将当前数据库(默认为0)的key移动到给定的数据库db当中。如果当前数据库(源数据库)和给定数据库(目标数据库)有相同名字的给定key，或者key不存在于当前数据库，那么MOVE没有任何效果。  
            jedis.move("foo", 1);//将foo这个key，移动到数据库1  
              
            //RENAME key newkey  将key改名为newkey。当key和newkey相同或者key不存在时，返回一个错误。当newkey已经存在时，RENAME命令将覆盖旧值。  
            jedis.rename("foo", "foonew");  
              
            //TYPE key 返回key所储存的值的类型。  
            System.out.println("key所储存的值的类型 ==>" + jedis.type("test"));//none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)  
                
            //EXPIRE key seconds 为给定key设置生存时间。当key过期时，它会被自动删除。  
            jedis.expire("foo", 5);//5秒过期  
            //EXPIREAT EXPIREAT的作用和EXPIRE一样，都用于为key设置生存时间。不同在于EXPIREAT命令接受的时间参数是UNIX时间戳(unix timestamp)。  
              
            //一般SORT用法 最简单的SORT使用方法是SORT key。  
            jedis.lpush("sort", "1");  
            jedis.lpush("sort", "4");  
            jedis.lpush("sort", "6");  
            jedis.lpush("sort", "3");  
            jedis.lpush("sort", "0");  
              
            List list = jedis.sort("sort"); //默认是升序  
            for(int i=0;i<list.size();i++){  
                System.out.println(list.get(i));  
            }  
  
              
            //----------- STRING------------------//   
            //SET key value将字符串值value关联到key。  
            jedis.set("name", "yixiaohan");  
            jedis.set("id", "007");  
            jedis.set("address", "beijing");  
              
            //SETEX key seconds value将值value关联到key，并将key的生存时间设为seconds(以秒为单位)。  
            jedis.setex("foo", 5, "haha");  
              
            //MSET key value [key value ...]同时设置一个或多个key-value对。  
            jedis.mset("kevin","111","keso","222");  
               
            //redis.flushAll();清空所有的key  
            System.out.println("dbSize ==>" + jedis.dbSize());//dbSize是多少个key的个数  
              
            //APPEND key value如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。  
            System.out.println("append before==>" + jedis.get("foo"));  
            jedis.append("foo", "00");//如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。  
            System.out.println("append after==>" + jedis.get("foo"));  
              
            //GET key 返回key所关联的字符串值  
            String getResult = jedis.get("name");  
            System.out.println("getResult==>" + getResult);  
              
            //MGET key [key ...] 返回所有(一个或多个)给定key的值, 如果key不存在,则返回null  
            List getList = jedis.mget("address","name", "myboss");  
            for(int i=0; i<getList.size(); i++){  
                System.out.println(getList.get(i));  
            }  
              
              
            //DECR key 将key中储存的数字值减一。  
            //DECRBY key decrement 将key所储存的值减去减量decrement。  
            //INCR key 将key中储存的数字值增一。  
            //INCRBY key increment 将key所储存的值加上增量increment。  
              
              
            System.out.println("\n" + "==============Hash 操作(key field value)================");  
            //HSET key field value将哈希表key中的域field的值设为value。  
            jedis.hset("website", "google", "www.google.cn");  
            jedis.hset("website", "baidu", "www.baidu.com");  
            jedis.hset("website", "sina", "www.sina.com");  
              
              
            //HMSET key field value [field value ...] 同时将多个field - value(域-值)对设置到哈希表key中。  
            Map<String,String> map = new HashMap<String,String>();  
            map.put("cardid", "123456");  
            map.put("username", "yixiaohan");  
            jedis.hmset("hash", map);  
              
            //HGET key field返回哈希表key中给定域field所对应的值。  
            System.out.println("哈希表key中给定域field所对应的值==>" + jedis.hget("hash", "username"));  
              
            //HMGET key field [field ...]返回哈希表key中，一个或多个给定域的值。  
            List hlist = jedis.hmget("website","google","baidu","sina");  
            for(int i=0;i<hlist.size();i++){  
                System.out.println("hmget()返回哈希表key中，一个或多个给定域的值==> " + hlist.get(i));  
            }  
              
            //HGETALL key返回哈希表key中，所有的域和值。  
            Map<String,String> allmap = jedis.hgetAll("hash");  
            for(Map.Entry entry: allmap.entrySet()) {  
                 System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");  
            }  
              
            //HDEL key field [field ...]删除哈希表key中的一个或多个指定域。  
            //HLEN key 返回哈希表key中域的数量。  
            //HEXISTS key field查看哈希表key中，给定域field是否存在。  
            //HINCRBY key field increment为哈希表key中的域field的值加上增量increment。  
            //HKEYS key返回哈希表key中的所有域。  
            //HVALS key返回哈希表key中的所有值。  
              
              
            System.out.println("\n" + "==================== LIST 操作 =====================");   
            //LPUSH key value [value ...]将值value插入到列表key的表头。//LPUSH puts the new value at the start of the list  
            jedis.lpush("mylist", "abc");  
            jedis.lpush("mylist", "xzc");  
            jedis.lpush("mylist", "erf");  
            jedis.lpush("mylist", "bnh");  
              
            //LRANGE key start stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。下标(index)参数start和stop都以0为底，  
            //也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。  
            //你也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。  
            List listy = jedis.lrange("mylist", 0, -1);//LRANGE mylist 0 -1  ==> 其中 -1 返回所有的值.  
            for(int i=0;i<listy.size();i++){  
                System.out.println(listy.get(i));  
            }  
              
            System.out.println("列表key的长度==>" + jedis.llen("mylist"));  
            //LLEN key返回列表key的长度。  
            //LREM key count value根据参数count的值，移除列表中与参数value相等的元素。  
              
              
            System.out.println("\n" + "===========  SET 操作 =====================");  
            //SADD key member [member ...]将member元素加入到集合key当中。  
            jedis.sadd("testSet", "s1");  
            jedis.sadd("testSet", "s2");  
            jedis.sadd("testSet", "s3");  
            jedis.sadd("testSet", "s4");  
            jedis.sadd("testSet", "s5");  
              
            //SREM key member移除集合中的member元素。  
            jedis.srem("testSet", "s5");  
              
            //SMEMBERS key返回集合key中的所有成员。  
            Set set = jedis.smembers("testSet");  
            Iterator ite=set.iterator() ;  
            while(ite.hasNext()){  
                Object obj1=ite.next();  
                System.out.println(obj1);  
            }  
              
            //SISMEMBER key member判断member元素是否是集合key的成员。是（true），否则（false）  
            boolean isInSet = jedis.sismember("testSet", "s4");  
            System.out.println("sismember()判断member元素是否是集合key的成员==>" + isInSet);  
              
            //SCARD key返回集合key的基数(集合中元素的数量)。  
            //SMOVE source destination member将member元素从source集合移动到destination集合。  
               
            //SINTER key [key ...]返回一个集合的全部成员，该集合是所有给定集合的交集。  
            //SINTERSTORE destination key [key ...]此命令等同于SINTER，但它将结果保存到destination集合，而不是简单地返回结果集  
            //SUNION key [key ...]返回一个集合的全部成员，该集合是所有给定集合的并集。  
            //SUNIONSTORE destination key [key ...]此命令等同于SUNION，但它将结果保存到destination集合，而不是简单地返回结果集。  
            //SDIFF key [key ...]返回一个集合的全部成员，该集合是所有给定集合的差集 。  
            //SDIFFSTORE destination key [key ...]此命令等同于SDIFF，但它将结果保存到destination集合，而不是简单地返回结果集。  
              
        }  
          
    }  