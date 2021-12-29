package com.java.juc.test01;

/**
 * @author: Trae.Liu
 * @create: 2021-12-29 10:41
 * @description: 创建线程方式2-实现Runnable
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        for (int i = 0; i < 10; i++){
            System.out.println("我是主线程"+i);
        }
    }
}

class MyRunnable implements Runnable{

    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("我是线程"+i);
        }
    }
}
