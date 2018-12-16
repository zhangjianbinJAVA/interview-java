package com.dongnao.thread.lock;

import com.dongnao.thread.SleepUtils;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/28
 * 创建时间: 20:45
 * 类锁和实例锁
 */
public class InstanceAndClass13 {

    //测试类锁
    private static class TestClassSyn extends Thread{
        @Override
        public void run() {
            System.out.println("TestClassSyn 准备获取类锁...");
            synClass();
        }
    }
    //锁类的方法
    private static synchronized void synClass(){
        SleepUtils.second(1); //阻塞一秒
        System.out.println("TestClassSyn 获取到类锁...");
        SleepUtils.second(10); //阻塞一秒
        System.out.println("TestClassSyn ended...");
        
    }
    /**
     * 
    private static void synClass(){
    	synchronized(InstanceAndClass13.class){
	        SleepUtils.second(1);
	        System.out.println("TestClass ended...");
	        SleepUtils.second(1);
    	}
    }
     **/
    
    //测试对象锁
    private static class TestInstanceSyn extends Thread{
        private InstanceAndClass13 instanceAndClass;

        public TestInstanceSyn(InstanceAndClass13 instanceAndClass) {
            this.instanceAndClass = instanceAndClass;
        }

        @Override
        public void run() {
            System.out.println("TestInstanceSyn 准备获取对象锁..."+instanceAndClass);
            instanceAndClass.synInstance();
        }

    }
    //锁对象的方法
    private synchronized void synInstance(){
        SleepUtils.second(3);
        System.out.println("TestInstanceSyn 得到对象锁...");
        SleepUtils.second(3);
        System.out.println("TestInstanceSyn ended");
    }

    //测试对象锁
    private static class TestInstance2Syn implements Runnable{
        private InstanceAndClass13 instanceAndClass;

        public TestInstance2Syn(InstanceAndClass13 instanceAndClass) {
            this.instanceAndClass = instanceAndClass;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2Syn 准备获取对象锁..."+instanceAndClass);
            instanceAndClass.synInstance2();
        }
    }
    //锁对象的方法
    private synchronized void synInstance2(){
        SleepUtils.second(3);
        System.out.println("TestInstance2Syn 得到对象锁...");
        SleepUtils.second(3);
        System.out.println("TestInstance2Syn ended");
    }


    public static void main(String[] args) {
        InstanceAndClass13 instanceAndClass = new InstanceAndClass13();
        Thread t1 = new TestClassSyn(); //类锁
        Thread t2 = new Thread(new TestInstanceSyn(instanceAndClass)); //对象锁
        Thread t3 = new Thread(new TestInstance2Syn(instanceAndClass)); //对象锁
        t2.start();
        t3.start();
//        SleepUtils.second(1);
        t1.start();
    }

}
