package com.dongnao.language;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

/**
 * @author Five��ʦ
 * @createTime 2018��1��17�� ����10:18:16
 * @readme String\StringBuffer\StringBuilder�Ա�
 * <p>
 * ���ܲ��StringBuilder > StringBuffer > String��
 * String���ַ����Ĳ������޸ġ�ƴ�ӣ���ʵ���ڴ����µĶ���Ч�ʵ��£�
 * StringBuffer �̰߳�ȫ��StringBuilder �̲߳���ȫ
 */
public class StringDemo2 {
    private static int num = 5000;

    public static void main(String[] args) {
        stringDemo();
        stringbufferDemo();
        stringbuilderDemo();
//		stringBuilderSync();
    }

    public static void stringDemo() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        String str = "abc";
        for (int i = 0; i < num; i++) {
            str += "-abc" + i;
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("String ������" + num + "��׷�Ӻ�ʱ" + (endTime - startTime));
    }

    public static void stringbufferDemo() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        StringBuffer str = new StringBuffer("abc");
        for (int i = 0; i < num; i++) {
            str.append("-abc" + i);
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("StringBuffer ������" + num + "��׷�Ӻ�ʱ" + (endTime - startTime));
    }

    public static void stringbuilderDemo() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        StringBuilder str = new StringBuilder("abc");
        for (int i = 0; i < num; i++) {
            str.append("-abc" + i);
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("StringBuilder ������" + num + "��׷�Ӻ�ʱ" + (endTime - startTime));
    }

    static final int THREAD_NUM = 100;
    static CountDownLatch cdl = new CountDownLatch(THREAD_NUM);
    static StringBuilder sb = new StringBuilder();

    /**
     * ���Բ�����StringBuilder��StringBuffer�İ�ȫ��
     **/
    public static void stringBuilderSync() {
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new SbSyncThread(i)).start();
            cdl.countDown();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    static class SbSyncThread implements Runnable {
        private int a = 0;

        public SbSyncThread(int a) {
            super();
            this.a = a;
        }

        @Override
        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.append(a + "-");
        }

    }
}
