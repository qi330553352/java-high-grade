package com.example.qixin.multithreading.part1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import lombok.extern.log4j.Log4j2;

/** 类说明：新启线程的三种方式
 * extends Thread
 * implements Runnable
 * implements Callable<T>
 */
@Log4j2
public class NewThread {

    private static class UseThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" am extendes Thread");
        }
    }

    private static class UseRunable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" implements Runnable ");
        }
    }

    // 允许有返回值
    private static class UseCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+" implements Callable<String> ");
            return "CallResult";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseThread useThread = new UseThread();
        useThread.start();

        UseRunable useRunable = new UseRunable();
        new Thread(useRunable).start();

        UseCallable useCallable = new UseCallable();
        FutureTask<String> futureTask = new FutureTask<>(useCallable);//包装
        new Thread(futureTask).start();
        System.out.println("Get UseCallable result:"+futureTask.get()); //拿结果
    }
}
