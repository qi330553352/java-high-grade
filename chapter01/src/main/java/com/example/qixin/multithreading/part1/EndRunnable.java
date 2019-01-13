package com.example.qixin.multithreading.part1;

/** 类说明：中断线程 Runnable
 * Thread.currentThread().isInterrupted()
 */
public class EndRunnable {

    /**
     * Thread.currentThread() 会将当前调用线程给返回回来
     */

    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName()+" am extends Thread");
            }
            System.out.println(Thread.currentThread().getName()+" am extends Thread: "+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable,"endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }
}
