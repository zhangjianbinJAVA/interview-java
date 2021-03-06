package com.dongnao.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Five老师
 * @createTime 2018年2月2日 下午8:41:20
 */
public class ConditionDemo {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * Condition的标准用法
     *
     * @throws InterruptedException
     **/
    public void waitMethod() throws InterruptedException {
        lock.lock();
        try {
            //do some work.
            System.out.println("do some work begin");
            condition.await(); //线程等待
            System.out.println("do some work end");
        } finally {
            lock.unlock();
        }
    }

    public void nodifyMethod() {
        lock.lock();
        try {
            System.out.println("do signal");
            condition.signal(); //线程释放
//			condition.signalAll();//尽量少使用
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionDemo cd = new ConditionDemo();
        ThreadWait threadWait = new ThreadWait(cd);
        ThreadSignal threadSignal = new ThreadSignal(cd);
        threadWait.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        threadSignal.start();
    }

    static class ThreadWait extends Thread {
        ConditionDemo cd = null;

        public ThreadWait(ConditionDemo cd) {
            this.cd = cd;
        }

        @Override
        public void run() {
            try {
                cd.waitMethod();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static class ThreadSignal extends Thread {
        ConditionDemo cd = null;

        public ThreadSignal(ConditionDemo cd) {
            this.cd = cd;
        }

        @Override
        public void run() {
            cd.nodifyMethod();
        }
    }
}
