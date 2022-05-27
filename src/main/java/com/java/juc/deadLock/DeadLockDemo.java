package com.java.juc.deadLock;


/**
 * 线程死锁示例
 *
 * @author liuhangfei
 */
public class DeadLockDemo {

    private static String resourceA = "A";
    private static String resourceB = "B";

    public static void main(String[] args) {
        deadLock();
    }

    public static void deadLock() {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("get resource a");
                    try {
                        Thread.sleep(3000);
                        synchronized (resourceB) {
                            System.out.println("get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB) {
                    System.out.println("get resources b");
                    synchronized (resourceA) {
                        System.out.println("get resource a");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
