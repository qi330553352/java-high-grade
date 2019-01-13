package com.example.qixin.multithreading.part1;

/** 类说明：如何中断线程 Thread
 * interrupt()
 */
public class EndThread {

    private static class UseThread extends Thread {
        public UseThread(String name){

        }

        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println(Thread.currentThread().getName()+"am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+"am extends Thread: "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
