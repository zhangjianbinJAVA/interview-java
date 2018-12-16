package com.dongnao.thread.volatiletest;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/28
 * 创建时间: 20:29
 * 测试Volatile型变量的操作原子性
 */
public class VolatileThread12 implements Runnable {

    private volatile int a = 0;

    @Override
    public void run() {
        synchronized (this){ // 当用不用锁时，
            a=a+1;
            System.out.println(Thread.currentThread().getName()+"----"+a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a=a+1;
            System.out.println(Thread.currentThread().getName()+"----"+a);

        }
    }
}
