package com.dongnao.language;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author Five��ʦ
 * @createTime 2018��1��17�� ����10:00:52
 * @readme List���϶Ա�
 */
public class ListDemo4 {

	private static final int THREAD_NUM=100;
	private static CountDownLatch cdl = new CountDownLatch(THREAD_NUM);
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); //����ȫ
//		List<String> list = new Vector<String>(); //��ȫ
//		List<String> list = new LinkedList<String>(); //����ȫ
		list.add("abc");
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(new ThreadDemo(list)).start();
			cdl.countDown();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
//		for (String string : list) {
//			System.out.println(string);
//		}
	}
	
	static class ThreadDemo implements Runnable{
		List<String> list;
		public ThreadDemo(List<String> list) {
			this.list = list;
		}

		@Override
		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add("abc"+Thread.currentThread().getId());
		}
	}
}
