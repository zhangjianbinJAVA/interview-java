package com.dongnao.Interview.jvm.model;

public class TicketRunnable1 implements Runnable {
    private int count = 100;// 100张票

    @Override
    public void run() {

        while (this.count > 0) { // 操作的count　在堆中，它是类变量，是线程共享的
            if (this.count > 0) {
                System.out.println(Thread.currentThread() + "售出第"
                        + (count--) + "张票");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        int i = 0; // i 是局部变量，在栈中，是线程私有的
        while (i < 100) {
            i++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("线程内部变量值为：" + i);
    }


    public static void main(String[] args) {
        TicketRunnable1 tr = new TicketRunnable1();
        //四个线程对应四个窗口  
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
