package com.dongnao.thread.concurrentTools;

import java.util.concurrent.Exchanger;

/**
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����10:15:50
 * @redame ������
 */
public class ExchangerDemo18 {


    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        Thread fiveThread = new Thread(new FiveThread(exchanger));
        Thread lisonThread = new Thread(new LisonThread(exchanger));
        fiveThread.start();
        lisonThread.start();//�߳������ȴ������߳��֣��������ע�͵�ʱ����ǰһ���̻߳�һֱ����������
        // lison�߳�  ��� Five
        // five�߳�   ��� Lison
    }

    static class FiveThread implements Runnable {
        private Exchanger<String> exchanger;

        public FiveThread(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                // �� Five ����ȥ
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
                // �� Lison ����ȥ
                System.out.println(Thread.currentThread().getName() + " LisonThread : " + exchanger.exchange("Lison"));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
