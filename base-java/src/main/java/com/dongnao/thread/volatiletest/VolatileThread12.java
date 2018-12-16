package com.dongnao.thread.volatiletest;

/**
 * ����ѧԺ-Mark��ʦ
 * �������ڣ�2017/11/28
 * ����ʱ��: 20:29
 * ����Volatile�ͱ����Ĳ���ԭ����
 */
public class VolatileThread12 implements Runnable {

    private volatile int a = 0;

    @Override
    public void run() {
        synchronized (this){ // ���ò�����ʱ��
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
