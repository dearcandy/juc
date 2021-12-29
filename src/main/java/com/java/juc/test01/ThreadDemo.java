package com.java.juc.test01;

/**
 * @author: Trae.Liu
 * @create: 2021-12-29 10:34
 * @description: 线程创建方式1-继承Thread
 */
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++){
            System.out.println("我是主线程"+ i);
        }
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("我是线程"+ i);
        }
    }
}
