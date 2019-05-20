package com.example.point.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther wangkaiguang
 * @date 2019/5/20
 */
public class demo {



    public static void main(String[] args) throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        if (lock1.tryLock(1, TimeUnit.SECONDS)){
            if (lock2.tryLock(1,TimeUnit.SECONDS)){
                System.out.println("获取锁2");
            }
        }
        if (lock2.tryLock(1, TimeUnit.SECONDS)){
            if (lock1.tryLock(1,TimeUnit.SECONDS)){
                System.out.println("获取锁1");
            }
        }



    }
}
