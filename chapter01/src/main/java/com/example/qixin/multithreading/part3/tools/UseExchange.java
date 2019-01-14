package com.example.qixin.multithreading.part3.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/** 类说明：演示Exchanger用法
 */
public class UseExchange {

    private static final Exchanger<Set<String>> exchange = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setA = new HashSet<>();//存放数据的容器
                try {
                	/*添加数据
                	 * set.add(.....)
                	 * */
                    setA = exchange.exchange(setA);//交换set
                	/*处理交换后的数据*/
                } catch (InterruptedException e) {
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setB = new HashSet<>();//存放数据的容器
                try {
                	/*添加数据
                	 * set.add(.....)
                	 * set.add(.....)
                	 * */
                    setB = exchange.exchange(setB);//交换set
                	/*处理交换后的数据*/
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }
}
