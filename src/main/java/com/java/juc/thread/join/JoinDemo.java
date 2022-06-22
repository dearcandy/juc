package com.java.juc.thread.join;


/**
 * join 方法简单示例
 * @author liuhangfei
 */
public class JoinDemo {

    private static final int END_INDEX = 10;

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 1; i <= END_INDEX; i++) {
            Thread curThread = new JoinThread(previousThread);
            curThread.start();
            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
