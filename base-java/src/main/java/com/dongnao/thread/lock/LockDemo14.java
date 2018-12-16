package com.dongnao.thread.lock;
/**
 * 
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����8:08:12
 * 
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo14 {

	public static void main(String[] args) {
		method1();
	}
	
	/**
	 * Lock�ı�׼�÷�
	 **/
	public static void method1(){
		Lock lock = new ReentrantLock();
		lock.lock(); //����
		try{
			//do some work.
		}finally{
			lock.unlock();//�ͷ���
		}
	}
}
