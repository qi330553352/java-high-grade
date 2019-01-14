package com.example.qixin.multithreading.part3.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 类说明：演示 Future 的使用
 */
public class UseFuture {

    private static class UseCallable implements Callable<Integer>{
        private int sum;
        @Override
        public Integer call() throws Exception {
            System.out.println("Callable子线程开始计算！");
            Thread.sleep(2000);
            for(int i=0 ;i<5000;i++){
                sum=sum+i;
            }
            System.out.println("Callable子线程计算结束！结果为: "+sum);
            return sum;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UseCallable useCallable = new UseCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(useCallable); //用FutureTask包装Callable
        new Thread(futureTask).start();//交给Thread去运行
        Random r = new Random();
        Thread.sleep(1000);
        if(r.nextBoolean()) {//用随机的方式决定是获得结果还是终止任务
            System.out.println("Get UseCallable result = "+futureTask.get());
        }else {
            System.out.println("中断计算。  ");
            futureTask.cancel(true);
        }
    }
}
