package com.dongnao.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author Five老师
 * @createTime 2018年2月2日 下午8:30:39
 * @redame 读写锁实现
 */
public class ReadWriteLockDemo {

	static final Map<String, String> map = new HashMap<String, String>();
	static ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	static Lock r = rrwl.readLock(); //从读写锁中获得读锁
	static Lock w = rrwl.writeLock();//从读写锁中获得写锁
	
	public void put(){
		w.lock();
		try{
			//do some work.
		}finally{
			w.unlock();
		}
	}
	
	public void get(){
		r.lock();
		try{
			//do some work.
		}finally{
			r.unlock();
		}
	}
}
