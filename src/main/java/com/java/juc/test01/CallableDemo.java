package com.java.juc.test01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author: Trae.Liu
 * @create: 2021-12-29 10:55
 * @description:
 */
public class CallableDemo  {
    public static void main(String[] args) throws Exception{
        CallAble c=new CallAble();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(c);

        new Thread(futureTask,"线程A").start();
        new Thread(futureTask,"线程B").start();
        Integer integer = futureTask.get();
        System.out.println("integer = " + integer);
    }
}
class CallAble implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("欢迎你调用call方法");
        return 6;
    }
}
