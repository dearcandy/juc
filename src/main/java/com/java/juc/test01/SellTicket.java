package com.java.juc.test01;

/**
 * @author: Trae.Liu
 * @create: 2021-12-31 15:33
 * @description:
 */
public class SellTicket implements Runnable {
    /**
     * 定义一个成员变量表示有100张票
     */
    private int tickets=100;

    @Override
    public void run(){
        while (true){
            if(tickets>0){
                try {
                    //通过sleep()方法来等待
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"正在出售第"+tickets--+"张票");
            }else{
                //System.out.println("");
            }
        }
    }
}


