package com.dongnao.thread.volatiletest;

/**
 * ����ѧԺ-Mark��ʦ
 * �������ڣ�2017/11/28
 * ����ʱ��: 20:31
 */
public class VolatileTest12 {
    public static void main(String[] args) {
        VolatileThread12 volatileThread = new VolatileThread12();

        Thread t1 = new Thread(volatileThread);
        Thread t2 = new Thread(volatileThread);
        Thread t3 = new Thread(volatileThread);
        Thread t4 = new Thread(volatileThread);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
