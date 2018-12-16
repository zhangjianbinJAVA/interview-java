package com.dongnao.thread.concurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����10:04:52
 * @redame դ��
 */
public class CyclicBarrierDemo16 {
    private static final int THREAD_NUM = 10;

    private static CyclicBarrier cb = new CyclicBarrier(THREAD_NUM);

    public static void main(String[] args) {
        // ģ��10���̲߳�������
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
                cb.await(); //�ȴ��̣߳�ֱ������һ�����������ѡ�
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(a);//����ִ�е�����
        }
    }
}
