package com.example.qixin.multithreading.part2.syn;

import com.example.qixin.multithreading.tools.SleepTools;

/** 类说明：在同一个类上即有对象锁又有类锁
 * 1、验证类锁和对象锁之间的关联，其实两个不同的锁
 * 2、验证同一个类不同实例之间实例锁的关联，实例锁之间没有关联
 */
public class SynClassAndInstance {

    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println("TestClass is running...");
            synClass();
        }
    }

    private static class InstanceSyn implements Runnable{
        private SynClassAndInstance SynClassAndInstance;

        public InstanceSyn(SynClassAndInstance SynClassAndInstance) {
            this.SynClassAndInstance = SynClassAndInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..."+SynClassAndInstance);
            SynClassAndInstance.instance();
        }
    }

    private static class Instance2Syn implements Runnable{
        private SynClassAndInstance SynClassAndInstance;

        public Instance2Syn(SynClassAndInstance SynClassAndInstance) {
            this.SynClassAndInstance = SynClassAndInstance;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2 is running..."+SynClassAndInstance);
            SynClassAndInstance.instance2();
        }
    }

    private synchronized void instance(){
        SleepTools.second(3);
        System.out.println("synInstance is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended "+this.toString());
    }

    private synchronized void instance2(){
        SleepTools.second(3);
        System.out.println("synInstance2 is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 ended "+this.toString());
    }

    private static synchronized void synClass(){
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    public static void main(String[] args) {
        SynClassAndInstance synClassAndInstance = new SynClassAndInstance();
        Thread t1 = new SynClass();
        Thread t2 = new Thread(new InstanceSyn(synClassAndInstance));
        Thread t3 = new Thread(new Instance2Syn(synClassAndInstance));
        SynClassAndInstance synClassAndInstance2 = new SynClassAndInstance();
        Thread t4 = new Thread(new InstanceSyn(synClassAndInstance2));
        t2.start();
        t3.start();
        t4.start();
        SleepTools.second(1);
        t1.start();
    }

}
