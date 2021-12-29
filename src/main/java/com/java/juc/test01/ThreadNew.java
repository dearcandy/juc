package com.java.juc.test01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: Trae.Liu
 * @create: 2021-12-29 10:49
 * @description: 实现线程的方式三-实现callable接口
 */
public class ThreadNew {

    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("总和是"+ sum);
        } catch (Exception e) {
        }
    }


}

class NumThread implements Callable{

    public Object call() throws Exception {
        int sum=0;
        for(int i=1;i<=10;i++){
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}
