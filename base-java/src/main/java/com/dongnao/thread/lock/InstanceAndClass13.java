package com.dongnao.thread.lock;

import com.dongnao.thread.SleepUtils;

/**
 * ����ѧԺ-Mark��ʦ
 * �������ڣ�2017/11/28
 * ����ʱ��: 20:45
 * ������ʵ����
 */
public class InstanceAndClass13 {

    //��������
    private static class TestClassSyn extends Thread{
        @Override
        public void run() {
            System.out.println("TestClassSyn ׼����ȡ����...");
            synClass();
        }
    }
    //����ķ���
    private static synchronized void synClass(){
        SleepUtils.second(1); //����һ��
        System.out.println("TestClassSyn ��ȡ������...");
        SleepUtils.second(10); //����һ��
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
    
    //���Զ�����
    private static class TestInstanceSyn extends Thread{
        private InstanceAndClass13 instanceAndClass;

        public TestInstanceSyn(InstanceAndClass13 instanceAndClass) {
            this.instanceAndClass = instanceAndClass;
        }

        @Override
        public void run() {
            System.out.println("TestInstanceSyn ׼����ȡ������..."+instanceAndClass);
            instanceAndClass.synInstance();
        }

    }
    //������ķ���
    private synchronized void synInstance(){
        SleepUtils.second(3);
        System.out.println("TestInstanceSyn �õ�������...");
        SleepUtils.second(3);
        System.out.println("TestInstanceSyn ended");
    }

    //���Զ�����
    private static class TestInstance2Syn implements Runnable{
        private InstanceAndClass13 instanceAndClass;

        public TestInstance2Syn(InstanceAndClass13 instanceAndClass) {
            this.instanceAndClass = instanceAndClass;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2Syn ׼����ȡ������..."+instanceAndClass);
            instanceAndClass.synInstance2();
        }
    }
    //������ķ���
    private synchronized void synInstance2(){
        SleepUtils.second(3);
        System.out.println("TestInstance2Syn �õ�������...");
        SleepUtils.second(3);
        System.out.println("TestInstance2Syn ended");
    }


    public static void main(String[] args) {
        InstanceAndClass13 instanceAndClass = new InstanceAndClass13();
        Thread t1 = new TestClassSyn(); //����
        Thread t2 = new Thread(new TestInstanceSyn(instanceAndClass)); //������
        Thread t3 = new Thread(new TestInstance2Syn(instanceAndClass)); //������
        t2.start();
        t3.start();
//        SleepUtils.second(1);
        t1.start();
    }

}
