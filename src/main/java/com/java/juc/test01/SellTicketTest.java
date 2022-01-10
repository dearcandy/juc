package com.java.juc.test01;

/**
 * @author: Trae.Liu
 * @create: 2021-12-31 15:34
 * @description:
 */
public class SellTicketTest {

    public static void main(String[] args) {
        SellTicket st = new SellTicket();

        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
