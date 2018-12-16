package com.dongnao.thread;

/**
 * @author Five老师
 * @createTime 2018年1月17日 下午4:37:01
 */
public class CreateThread8 {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            // 由cpu 来调用线程
            new ThreadA().start();
//			new Thread(new ThreadB()).start();
        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadA[" + Thread.currentThread() + "]  ");
        }

    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            System.out.println("ThreadB[" + Thread.currentThread() + "]  ");
        }
    }
}
