package com.wcg.boot;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.transcoders.StringTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * @Author Miracle.wcg
 * @Date 2019-07-24 00:22
 */
public class FullMemcache {
    public static void main(String[] args) throws Exception {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.56.101:11211"));
        MemcachedClient client = builder.build();
        client.flushAll();
        //存储hello对应的world字符串
        if (!client.set("hello", 0, "world")) {
            System.err.println("set error");
        }
        //添加
        if (client.add("hello", 0, "dennis")) {
            System.err.println("Add error,key is existed");
        }
        //替换
        if (!client.replace("hello", 0, "dennis")) {
            System.err.println("replace error");
        }
        client.append("hello", " good");
        client.prepend("hello", "hello ");
        String name = client.get("hello", new StringTranscoder());
        System.out.println(name);
        //删除数据并且告诉memcached不用返回应答，因此这个方法不会等待应答直接返回，特别适合于批量处理
        client.deleteWithNoReply("hello");
    }
}
