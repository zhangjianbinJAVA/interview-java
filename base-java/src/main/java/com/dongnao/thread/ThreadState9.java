package com.dongnao.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����ѧԺ-Mark��ʦ
 * �������ڣ�2017/11/15
 * ����ʱ��: 17:12
 * �鿴�̵߳�״̬
 */
public class ThreadState9 {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new SleepAlways(), "SleepAlwaysThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // ʹ������Blocked�̣߳�һ����ȡ���ɹ�����һ��������
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
        new Thread(new Sync(), "SyncThread-1").start();
        new Thread(new Sync(), "SyncThread-2").start();
    }

    /**
     * ���̲߳��ϵĽ���˯��
     */
    static class SleepAlways implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    /**
     * ���߳���Waiting.classʵ���ϵȴ�
     */
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * ���߳���Blocked.classʵ���ϼ����󣬲����ͷŸ���
     */
    static class Blocked implements Runnable {
        public void run() {
            synchronized (Blocked.class) {
                while (true) {
                    SleepUtils.second(100);
                }
            }
        }
    }

    /**
     * ���̻߳�������ߺ����ͷ���
     */
    static class Sync implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                SleepUtils.second(3000);
            } finally {
                lock.unlock();
            }

        }

    }
}
