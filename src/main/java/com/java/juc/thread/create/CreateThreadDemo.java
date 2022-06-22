package com.java.juc.thread.create;

import java.util.concurrent.*;

/**
 * 创建线程示例
 * @author liuhangfei
 */
public class CreateThreadDemo {

    public static void main(String[] args) {
        // 1. 继承Thread
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread1.start();

        // 2. 实现Runnable
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现Runnable");
            }
        });
        thread2.start();

        // 3. 实现Callable
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new Callable() {
            @Override
            public String call() {
                return "通过实现Callable接口";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
