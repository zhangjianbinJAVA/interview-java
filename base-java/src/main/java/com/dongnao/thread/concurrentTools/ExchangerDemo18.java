package com.dongnao.thread.concurrentTools;

import java.util.concurrent.Exchanger;

/**
 * @author Five老师
 * @createTime 2018年2月2日 下午10:15:50
 * @redame 交换者
 */
public class ExchangerDemo18 {


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        Thread fiveThread = new Thread(new FiveThread(exchanger));
        Thread lisonThread = new Thread(new LisonThread(exchanger));
        fiveThread.start();
        lisonThread.start();//线程阻塞等待交换者出现，如果这里注释掉时，则前一个线程会一直阻塞在这里
        // lison线程  输出 Five
        // five线程   输出 Lison
    }

    static class FiveThread implements Runnable {
        private Exchanger<String> exchanger;

        public FiveThread(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                // 将 Five 传出去
                System.out.println(Thread.currentThread().getName() + " FiveThread : " + exchanger.exchange("Five"));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    static class LisonThread implements Runnable {
        private Exchanger<String> exchanger;

        public LisonThread(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                // 将 Lison 传出去
                System.out.println(Thread.currentThread().getName() + " LisonThread : " + exchanger.exchange("Lison"));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
