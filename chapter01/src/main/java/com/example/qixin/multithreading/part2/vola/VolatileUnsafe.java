package com.example.qixin.multithreading.part2.vola;

import com.example.qixin.multithreading.tools.SleepTools;
import com.sun.corba.se.spi.oa.ObjectAdapter;

/**
 * 类说明：
 * 验证Volatile没有原子性
 * 什么时候使用 volatile 关键字：
 * 有一个变量只有一个线程修改它，其它线程都是读操作
 */
public class VolatileUnsafe {
    private static class VolatileVar implements Runnable {
        private final Object o = new Object();
        private volatile int a = 0;

        @Override
        public void run() {
            synchronized (o) {
                a = a + 1;
                System.out.println(Thread.currentThread().getName() + ":----" + a);
                SleepTools.ms(100);
                a = a + 1;
                System.out.println(Thread.currentThread().getName() + ":----" + a);
            }
        }
    }

    public static void main(String[] args) {

        VolatileVar v = new VolatileVar();

        Thread t1 = new Thread(v);
        Thread t2 = new Thread(v);
        Thread t3 = new Thread(v);
        Thread t4 = new Thread(v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
