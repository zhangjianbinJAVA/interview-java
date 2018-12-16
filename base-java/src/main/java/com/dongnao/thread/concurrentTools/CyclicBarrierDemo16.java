package com.dongnao.thread.concurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Five老师
 * @createTime 2018年2月2日 下午10:04:52
 * @redame 栅栏
 */
public class CyclicBarrierDemo16 {
    private static final int THREAD_NUM = 10;

    private static CyclicBarrier cb = new CyclicBarrier(THREAD_NUM);

    public static void main(String[] args) {
        // 模拟10个线程并发访问
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread = new Thread(new ThreadDemo(i));
            thread.start();
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
                cb.await(); //等待线程，直到满足一定条件被唤醒。
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(a);//并发执行的任务
        }
    }
}
