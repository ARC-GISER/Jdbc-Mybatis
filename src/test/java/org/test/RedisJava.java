package org.test;


import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * Explain:测试RedisPool
 */
public class RedisJava {

    public static void main(String[] args) {
        RedisPool.getJedis().set("name","张龙");
        System.out.println(RedisPool.getJedis().get("name"));
    }

}
