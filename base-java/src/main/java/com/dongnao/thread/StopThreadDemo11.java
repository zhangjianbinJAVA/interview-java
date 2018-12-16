package com.dongnao.thread;

/**
 * @author Five老师
 * @createTime 2018年2月2日 下午4:20:22
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
        // 停止线程
        target.cannel();
    }

    static class TreadDemo extends Thread {
        private static volatile boolean stop = false;
        private int i = 0;

        @Override
        public void run() {
            System.out.println("进入线程........" + Thread.currentThread().isInterrupted());

            // Thread.currentThread().isInterrupted() 没有时，当线程阻塞时，是不会停止线程的
            while (!stop && !Thread.currentThread().isInterrupted()) {
                i++;
                try {
                    synchronized (this) {
                        wait();//阻塞了
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i > 100) {
                    break;
                }
            }
            System.out.println("结束线程........--->i=" + i);
        }

        public void cannel() {
            stop = true; // 通过标志位来停止线程
            interrupt(); // 向TreadDemo线程发出中断信号
        }
    }
}
