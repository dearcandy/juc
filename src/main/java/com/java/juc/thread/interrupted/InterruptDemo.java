package com.java.juc.thread.interrupted;


/**
 * 线程中断示例
 * @author liuhangfei
 */
public class InterruptDemo {

    public static void main(String[] args) {
        // sleepThread 睡1000ms
        final Thread sleepThread = new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                super.run();
            }
        };
        // busyThread 死循环
        Thread busyThread = new Thread(){
            @Override
            public void run(){
                while (true) {
                }
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted()) {
        }
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
