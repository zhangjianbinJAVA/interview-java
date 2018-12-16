package com.dongnao.thread.concurrentTools;

import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����10:36:38
 * @redame դ��
 */
public class CyclicBarrierCount16 {
    private static CyclicBarrier cb = new CyclicBarrier(5, new CountThread());
    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

    /**
     * ��դ���е������̶߳�ִ�е������Ϻ� ִ�е�Runnable�̡߳�
     **/
    private static class CountThread implements Runnable {
        @Override
        public void run() {
            int result = 0;
            for (Entry<String, Integer> workmap : map.entrySet()) {
                result = result + workmap.getValue();
            }
            System.out.println("result:" + result);
        }
    }

    private static class WorkThread implements Runnable {
        private Random t = new Random();

        @Override
        public void run() {
            int r = t.nextInt(1000);
            map.put(Thread.currentThread().getId() + "", r);
            System.out.println("map add " + r);
            try {
                cb.await(); // �߳������������������̵߳�����
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new WorkThread());
            thread.start();
        }
    }
}
