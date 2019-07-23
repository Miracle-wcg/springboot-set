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
        //连接服务
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.56.101:11211"));
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient = builder.build();
            //存储数据是通过set方法，它有三个参数：
            //第一个是存储的key名称，
            //第二个是expire时间（单位秒），超过这个时间,memcached将这个数据替换出去，0表示永久存储（默认是一个月），
            //第三个参数就是实际存储的数据，可以是任意的java可序列化类型。
            memcachedClient.set("hello", 0, "Hello,xmemcached");
            //获取存储的数据
            String value = memcachedClient.get("hello");

            //等待3秒超时，如果3秒超时就抛出TimeutException，用户需要自己处理这个异常
            //通过调用CountDownLatch.await(timeout)方法实现等待
            //value = memcachedClient.get("hello", 3000);

            //更新缓存数据的超时时间5s
            //memcachedClient.touch("hello", 5000);

            //支持原子操作 > 1.3.6 verison
            //memcachedClient.getAndTouch("hello",5000);
            System.out.println("hello=" + value);

            //删除存储的数据
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
