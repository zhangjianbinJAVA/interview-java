package com.dongnao.thread;

/**
 * ����ѧԺ-Mark��ʦ
 * �������ڣ�2017/11/15
 * ����ʱ��: 17:12
 * sleep�����Ƿ���ͷ���
 */
public class SleepTest10 {
    //��
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

                //�õ����Ժ�����
                synchronized (lock) {
                    System.out.println(threadName + " taking the lock");
                    Thread.sleep(5000); // һֱ������
//                    lock.wait(5000); // �ȴ�ʱ������Ȩ���ǽ���ȥ�ˣ���һֱ������
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
            //�õ����Ժ�����
            synchronized (lock) {
                System.out.println(threadName + " taking the lock time=" + System.currentTimeMillis());
                System.out.println("Finish the work: " + threadName);
            }
        }
    }
}
