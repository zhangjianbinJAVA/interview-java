package com.dongnao.thread;

/**
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����4:20:22
 */
public class StopThreadDemo11 {

    public static void main(String[] args) {
        TreadDemo target = new TreadDemo();
        target.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ֹͣ�߳�
        target.cannel();
    }

    static class TreadDemo extends Thread {
        private static volatile boolean stop = false;
        private int i = 0;

        @Override
        public void run() {
            System.out.println("�����߳�........" + Thread.currentThread().isInterrupted());

            // Thread.currentThread().isInterrupted() û��ʱ�����߳�����ʱ���ǲ���ֹͣ�̵߳�
            while (!stop && !Thread.currentThread().isInterrupted()) {
                i++;
                try {
                    synchronized (this) {
                        wait();//������
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i > 100) {
                    break;
                }
            }
            System.out.println("�����߳�........--->i=" + i);
        }

        public void cannel() {
            stop = true; // ͨ����־λ��ֹͣ�߳�
            interrupt(); // ��TreadDemo�̷߳����ж��ź�
        }
    }
}
