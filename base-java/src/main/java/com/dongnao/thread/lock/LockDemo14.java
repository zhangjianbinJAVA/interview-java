package com.dongnao.thread.lock;
/**
 * 
 * @author Five老师
 * @createTime 2018年2月2日 下午8:08:12
 * 
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo14 {

	public static void main(String[] args) {
		method1();
	}
	
	/**
	 * Lock的标准用法
	 **/
	public static void method1(){
		Lock lock = new ReentrantLock();
		lock.lock(); //加锁
		try{
			//do some work.
		}finally{
			lock.unlock();//释放锁
		}
	}
}
