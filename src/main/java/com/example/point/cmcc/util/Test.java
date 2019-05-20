package com.example.point.cmcc.util;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

/**
 * @auther wangkaiguang
 * @date 2019/5/5
 */
public class Test {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("threa1 get locak1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("thread1 get lock2");
                    }
                }
                System.out.println("thread1 end");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("threa1 get locak2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("thread1 get lock2");
                    }
                }
                System.out.println("thread 2 end");
            }
        }.start();
    }
}
