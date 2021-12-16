package com.java.juc.volatilekey;

/**
 * @ClassName TestVolatile
 * @Description 测试内存可见性
 * @Author DearCandy
 * @Date 2021/12/16 22:36
 * @Version 1.0.0
 **/
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();

        while (true) {
            if (demo.isFlag()) {
                System.out.println("----------------");
                break;
            }
        }
    }

}

class ThreadDemo implements Runnable {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }
}
