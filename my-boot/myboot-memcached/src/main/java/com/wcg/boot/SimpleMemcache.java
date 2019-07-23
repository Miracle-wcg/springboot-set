package com.wcg.boot;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author Miracle.wcg
 * @Date 2019-07-24 00:18
 */
public class SimpleMemcache {
    public static void main(String[] args) {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.56.101:11211"));
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient = builder.build();

            memcachedClient.set("hello", 0, "Hello,xmemcached");
            String value = memcachedClient.get("hello");
            System.out.println("hello=" + value);
            memcachedClient.delete("hello");
            value = memcachedClient.get("hello");
            System.out.println("hello=" + value);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
        } catch (InterruptedException e) {
            // ignore
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //close memcached client
            memcachedClient.shutdown();
        } catch (IOException e) {
            System.err.println("Shutdown MemcachedClient fail");
            e.printStackTrace();
        }
    }
}
