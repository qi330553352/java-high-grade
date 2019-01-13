package com.example.qixin.multithreading.part1;

/** 类说明：run方法中抛出了InterrputException异常的情况
 * 抛出 InterruptedException 后 isInterrupted() 会设置为false，但程序不会停止；
 * 应再次手动设置程序停止: interrupt();
 */
public class HasInterrputException {

    private static class UseThread extends Thread{
        UseThread(String name){

        }

        @Override
        public void run() {
            while (!isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrup flag is: "+isInterrupted());
                    interrupt();
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" I am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+" interrup flag is: "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(500);
        endThread.interrupt();
    }
}
