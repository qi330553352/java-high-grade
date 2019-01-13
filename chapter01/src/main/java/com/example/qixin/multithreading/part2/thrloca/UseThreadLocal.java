package com.example.qixin.multithreading.part2.thrloca;

/**类说明
 * 演示hreadLocal的使用 ThreadLocal 对内存消耗比较大
 */
public class UseThreadLocal {

    /*声明一个ThreadLocal类型的static变量，所有线程共享,并初始化为1*/
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    /**
     * 运行3个线程
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new TestThread(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }

    /**
     *类说明：测试线程，线程的工作是将ThreadLocal变量的值变化，并写回，看看线程之间是否会互相影响
     */
    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id){
            this.id = id;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            Integer s = threadLocal.get();//获得变量的值
            s = s+id;
            threadLocal.set(s);//将值写回变量
            System.out.println(Thread.currentThread().getName()+':'+threadLocal.get());
        }
    }

    public static void main(String[] args){
        UseThreadLocal test = new UseThreadLocal();
        test.StartThreadArray();
    }

}
