package com.dongnao.thread.concurrentTools;

import java.util.concurrent.CountDownLatch;

/**
 * @author Five��ʦ
 * @createTime 2018��1��30�� ����9:26:35
 * @redame ����
 */
public class CountDownLatchDemo15 {
    private static final int THREAD_NUM = 10;
    private static CountDownLatch cdl = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) {
        // ģ�� 10 ���߳�ͬʱȥ����
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread = new Thread(new ThreadDemo(i));
            thread.start();
            cdl.countDown(); //countDownLatch��������ÿ�ε�������-1������ֵΪ0ʱ���������еȴ����̡߳�
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
                cdl.await(); //�ȴ��̣߳�ֱ������һ�����������ѡ�Ҳ���� countDown ��Ϊ0ʱ��������
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(a);//����ִ�е�����
        }
    }
}
