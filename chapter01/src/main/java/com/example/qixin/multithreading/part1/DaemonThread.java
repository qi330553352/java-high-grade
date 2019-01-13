package com.example.qixin.multithreading.part1;

/** 类说明：守护线程 setDaemon
 * 守护线程 finally 代码块中的代码不一定会被执行
 */
public class DaemonThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            try{
                while (!isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+" I am extends Thread "+Thread.currentThread().isInterrupted());
                }
            }finally {
                System.out.println("... ... finally ");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread = new UseThread();
        //useThread.setDaemon(true);
        useThread.start();
        Thread.sleep(5);
        //useThread.interrupt();
    }
}
