package com.dongnao.thread.concurrentTools;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����10:52:02
 * @redame �ź���
 */
public class SemaphoreDemo17<T> {
    private final Semaphore space;//ͬʱֻ������ٸ��̷߳�����Դ
    private List queue = new LinkedList();

    public SemaphoreDemo17(int spaceCounts) {
        this.space = new Semaphore(spaceCounts);
    }

    public void put(T x) throws InterruptedException {
        space.acquire();  // �ź���������ͬʱ�������������߳̿��Է��������Դ
        synchronized (queue) {
            System.out.println("put a item " + x);
            queue.add(x);
        }
    }

    public T take() throws InterruptedException {
        T t;
        synchronized (queue) {
            t = (T) queue.remove(0);
            System.out.println("take a item " + t);
        }
        space.release();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        // ����ͬʱ��ֻ�������߳̿��Է�����Դ
        SemaphoreDemo17<String> demo = new SemaphoreDemo17<String>(2);
        demo.put("1");
        demo.put("2");
        //demo.put("3"); // �����ʱ������ǵ�3��û��ȥ put��ֻ�е�����takeʱ������������put
        demo.take();
        demo.put("3");
        demo.take();
        demo.take();

    }
}
