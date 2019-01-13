package com.example.qixin.multithreading.part2.syn;

/** 类说明：线程间的共享
 * 验证多线程的变量共享,synchronized关键字可以保证程序有正确的行为
 */
public class SynTest {
    //共享变量
    private int age = 100000; //初始100000
    //递增方法
    private synchronized void add(){ //实例方法 锁的是对象的实例 对象锁
        age ++;
    }
    //递减方法
    private synchronized void remove(){
        age --;
    }
    private synchronized int getAge(){
        return age;
    }

    private static synchronized void add2(){ //静态方法/类方法 类锁

    }

    private static class TestThread extends Thread{
        private SynTest synTest;
        TestThread(SynTest synTest, String name){
            super(name);
            this.synTest=synTest;
        }

        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                synTest.add();
            }
            System.out.println(Thread.currentThread().getName()+" age = "+synTest.getAge());
        }
    }

    public static void main(String[] args){
        SynTest synTest = new SynTest();
        Thread endThread = new TestThread(synTest,"endThread");
        endThread.start();
        for(int i=0;i<100000;i++){
            synTest.remove();
        }
        System.out.println(Thread.currentThread().getName()+" main = "+synTest.getAge());
    }
}
