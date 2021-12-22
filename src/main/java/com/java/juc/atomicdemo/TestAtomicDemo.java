package com.java.juc.atomicdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName TestAtomicDemo
 * @Description 测试i++原子性问题
 * @Author DearCandy
 * @Date 2021/12/23 1:15
 * @Version 1.0.0
 **/
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++){
            new Thread(atomicDemo).start();
        }
    }



}

class AtomicDemo implements Runnable{

    private AtomicInteger serialNumber = new AtomicInteger();

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}


//class AtomicDemo implements Runnable{
//
//    private int serialNumber = 0;
//
//    public void run() {
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
//    }
//
//    public int getSerialNumber(){
//        return serialNumber++;
//    }
//}
