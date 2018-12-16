package com.dongnao.Interview.jvm.oom;

public class StackOomErrorDemo4 {

	    public void call(){
	    	//　double 最占内存，所以用double 来定义数据
		      Double d1 = 1.8787d;
		      Double d2 = 1.87897d;
		      Double d3 = 1.86787d;
		      Double d4 = 1.87887d;
		      Double d5 = 1.87787d;
		      Double d6 = 1.86787d;
		      Double d7 = 1.8767d;
		      Double d8 = 1.8767d;
		      Double d9 = 1.8767d;
		      Double d10 = 1.8767d;
		      Double d11 = 1.8787d;
		      Double d12 = 1.87897d;
		      Double d13 = 1.86787d;
		      Double d14 = 1.87887d;
		      Double d15 = 1.87787d;
		      Double d16 = 1.86787d;
		      Double d17 = 1.8767d;
		      Double d18 = 1.8767d;
		      Double d19 = 1.8767d;
		      Double d20 = 1.8767d;
	      try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(d1);
	      System.out.println(d2);
	      System.out.println(d3);
	      System.out.println(d4);
	      System.out.println(d5);
	      System.out.println(d6);
	      System.out.println(d7);
	      System.out.println(d8);
	      System.out.println(d9);
	      System.out.println(d10);
	      System.out.println(d11);
	      System.out.println(d12);
	      System.out.println(d13);
	      System.out.println(d14);
	      System.out.println(d15);
	      System.out.println(d16);
	      System.out.println(d17);
	      System.out.println(d18);
	      System.out.println(d19);
	      System.out.println(d20);
	    }
	    
	    public void stackLeakByThread(){
	    	while(true){
	    		// 不断实例化线程，
	    		new Thread(new Runnable() {
					@Override
					public void run() {
						call();
					}
				}).start();
	    		
	    	}
	    }
	 
	 
	    public static void main(String[] args) {
	    	StackOomErrorDemo4 soed = new StackOomErrorDemo4();
	    	soed.stackLeakByThread();

	    }
}
