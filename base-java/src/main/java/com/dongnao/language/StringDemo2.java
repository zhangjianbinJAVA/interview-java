package com.dongnao.language;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

/**
 * @author Five老师
 * @createTime 2018年1月17日 上午10:18:16
 * @readme String\StringBuffer\StringBuilder对比
 * <p>
 * 性能差别：StringBuilder > StringBuffer > String；
 * String对字符串的操作（修改、拼接）其实是在创建新的对象，效率低下；
 * StringBuffer 线程安全、StringBuilder 线程不安全
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
        System.out.println("String 类型做" + num + "次追加耗时" + (endTime - startTime));
    }

    public static void stringbufferDemo() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        StringBuffer str = new StringBuffer("abc");
        for (int i = 0; i < num; i++) {
            str.append("-abc" + i);
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("StringBuffer 类型做" + num + "次追加耗时" + (endTime - startTime));
    }

    public static void stringbuilderDemo() {
        long startTime = Calendar.getInstance().getTimeInMillis();
        StringBuilder str = new StringBuilder("abc");
        for (int i = 0; i < num; i++) {
            str.append("-abc" + i);
        }
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("StringBuilder 类型做" + num + "次追加耗时" + (endTime - startTime));
    }

    static final int THREAD_NUM = 100;
    static CountDownLatch cdl = new CountDownLatch(THREAD_NUM);
    static StringBuilder sb = new StringBuilder();

    /**
     * 测试并发下StringBuilder与StringBuffer的安全性
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
