package com.example.qixin.multithreading.part2.vola;

import com.example.qixin.multithreading.tools.SleepTools;

/**
 * volatile 最轻量的同步机制
 * 如果在一个变量上声明了 volatile 关键字，多个线程要使用 这个变量时就要使用有 volatile 声明的变量，
 * 不要使用考贝到自己工作区的变量; volatile 只是读取同步，不保证写同步
 */
public class UseVola {

    private volatile int age = 100000;

    private static class TestThread extends Thread {
        private UseVola synTest;

        TestThread(UseVola synTest, String name) {
            super(name);
            this.synTest = synTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                synTest.add();
            }
            System.out.println(Thread.currentThread().getName()
                    + " age =  " + synTest.getAge());
        }
    }

    private synchronized void add() {
        age++;
    }

    private synchronized int getAge() {
        return age;
    }

    public static void main(String[] args) throws InterruptedException {
        UseVola synTest = new UseVola();
        Thread endThread = new TestThread(synTest, "endThread");
        endThread.start();
        SleepTools.ms(2);
        System.out.println(Thread.currentThread().getName() + " age =  " + synTest.getAge());

    }
}
