package com.dongnao.thread;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/15
 * 创建时间: 17:12
 * sleep方法是否会释放锁
 */
public class SleepTest10 {
    //锁
    private Object lock = new Object();

    public static void main(String[] args) {
        SleepTest10 sleepTest = new SleepTest10();
        Thread threadA = sleepTest.new ThreadSleep();
        threadA.setName("ThreadSleep");
        Thread threadB = sleepTest.new ThreadNotSleep();
        threadB.setName("ThreadNotSleep");
        threadA.start();
        try {
            Thread.sleep(1000);
            System.out.println("RunTest slept!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
    }

    private class ThreadSleep extends Thread {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " will take the lock");
            try {

                //拿到锁以后，休眠
                synchronized (lock) {
                    System.out.println(threadName + " taking the lock");
                    Thread.sleep(5000); // 一直持有锁
//                    lock.wait(5000); // 等待时，锁的权限是交出去了，不一直持有锁
                    System.out.println("Finish the work: " + threadName);
                }

            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }

    private class ThreadNotSleep extends Thread {

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " will take the lock time=" + System.currentTimeMillis());
            //拿到锁以后不休眠
            synchronized (lock) {
                System.out.println(threadName + " taking the lock time=" + System.currentTimeMillis());
                System.out.println("Finish the work: " + threadName);
            }
        }
    }
}
