package com.dongnao.thread.concurrentTools;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Five老师
 * @createTime 2018年2月2日 下午10:52:02
 * @redame 信号量
 */
public class SemaphoreDemo17<T> {
    private final Semaphore space;//同时只允许多少个线程访问资源
    private List queue = new LinkedList();

    public SemaphoreDemo17(int spaceCounts) {
        this.space = new Semaphore(spaceCounts);
    }

    public void put(T x) throws InterruptedException {
        space.acquire();  // 信号量，告诉同时，可以有两个线程可以访问这个资源
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
        // 定义同时，只有两个线程可以访问资源
        SemaphoreDemo17<String> demo = new SemaphoreDemo17<String>(2);
        demo.put("1");
        demo.put("2");
        //demo.put("3"); // 打开这个时，结果是第3个没有去 put，只有调用了take时，第三个才能put
        demo.take();
        demo.put("3");
        demo.take();
        demo.take();

    }
}
