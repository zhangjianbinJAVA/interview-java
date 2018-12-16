package com.dongnao.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����9:27:06
 * 
 */
public class PoolDemo {
	public static void main(String[] args) {
		method4();
	}
	
	public static void method1(){
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100; i++) {
			int a = i;
			newSingleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("------------"+a);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		newSingleThreadExecutor.shutdown();
	}
	
	public static void method2(){
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			int a = i;
			newFixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("------------"+a);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		newFixedThreadPool.shutdown();
	}

	public static void method3(){
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			int a = i;
			newCachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("------------"+a);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		newCachedThreadPool.shutdown();
	}
	
	public static void method4(){
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
		/**
		 * schedule��������ִ��
		 * scheduleAtFixedRate������ִ�У��Կ�ʼʱ�����
		 * scheduleWithFixedDelay������ִ�У��Խ���ʱ�����
		 **/
		for (int i = 0; i < 3; i++) {
			int a = i;
			newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {
				@Override
				public void run() {
					System.out.println("------------"+a);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}, 1, 1, TimeUnit.SECONDS);
		}
//		newScheduledThreadPool.shutdown();
	}
}
