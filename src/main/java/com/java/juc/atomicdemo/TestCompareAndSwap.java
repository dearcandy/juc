package com.java.juc.atomicdemo;

/**
 * @ClassName TestCompareAndSwap
 * @Description 模拟CAS算法
 * @Author DearCandy
 * @Date 2021/12/23 1:51
 * @Version 1.0.0
 **/
public class TestCompareAndSwap {

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                public void run() {
                    int expectValue = cas.getValue();
                    boolean b = cas.compareAndSet(expectValue, (int)(Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}

class CompareAndSwap{
    private int value;

    // 获取内存值
    public synchronized int getValue(){
        return value;
    }

    // 比较并交换
    public synchronized int compareAndSwap(int expectValue, int newValue){
        int oldValue = value;

        if (oldValue == expectValue){
            this.value = newValue;
        }

        return oldValue;
    }

    // 是否
    public synchronized boolean compareAndSet(int expectValue, int newValue){
        return expectValue == compareAndSwap(expectValue, newValue);
    }
}