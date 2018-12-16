package com.dongnao.Interview.jvm.oom;

public class StackOverFlowErrorDemo3 {

	 private static int index = 1;
	 
	    public void call(){
	        index++;
	        call();
	    }

	    public static void main(String[] args) {
	    	StackOverFlowErrorDemo3 mock = new StackOverFlowErrorDemo3();
	        try {
	            mock.call();
	        }catch (Throwable e){
	            System.out.println("Stack deep : "+index);
	            e.printStackTrace();
	        }
	    }
}
