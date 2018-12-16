package com.dongnao.thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author Five��ʦ
 * @createTime 2018��2��2�� ����8:30:39
 * @redame ��д��ʵ��
 */
public class ReadWriteLockDemo {

	static final Map<String, String> map = new HashMap<String, String>();
	static ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	static Lock r = rrwl.readLock(); //�Ӷ�д���л�ö���
	static Lock w = rrwl.writeLock();//�Ӷ�д���л��д��
	
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
