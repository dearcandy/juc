package com.java.juc.test01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author: Trae.Liu
 * @create: 2021-12-31 15:08
 * @description: FutureTask-Test
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "coming......");
                return 1024;
            }
        });

        new Thread(futureTask).start();
        //1.果futureTask.get()放到main线程前面,会导致main线程阻塞
        //Object o = futureTask.get();

        /*Object o = futureTask.get();//不见不散,只要出现了get()方法就会阻塞
        System.out.println("不见不散,只要出现了get()方法就会阻塞,获取到的值为:"+o);*/
        //2.过时不候
        //        System.out.println(Thread.currentThread().getName()+"\t"+"线程来了.....");
        //        Object o2 = futureTask.get(2L, TimeUnit.SECONDS);
        //3.使用轮询
        while (true) {
            if (futureTask.isDone()) {
                System.out.println("使用轮询来解决,值为:" + futureTask.get());
                break;
            } else {
                System.out.println("阻塞中**********");
            }
        }

    }


}


