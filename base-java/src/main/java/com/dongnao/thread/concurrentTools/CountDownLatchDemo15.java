package com.dongnao.thread.concurrentTools;

import java.util.concurrent.CountDownLatch;

/**
 * @author Five老师
 * @createTime 2018年1月30日 下午9:26:35
 * @redame 闭锁
 */
public class CountDownLatchDemo15 {
    private static final int THREAD_NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) {
        // 模拟 10 个线程同时去调用
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread = new Thread(new ThreadDemo(i));
            thread.start();
            cdl.countDown(); //countDownLatch计数器，每次调用数量-1，当数值为0时，唤醒所有等待的线程。
        }
    }

    static class ThreadDemo implements Runnable {
        private int a = 0;

        public ThreadDemo(int a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                cdl.await(); //等待线程，直到满足一定条件被唤醒。也就是 countDown 变为0时，被唤醒
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(a);//并发执行的任务
        }
    }
}
