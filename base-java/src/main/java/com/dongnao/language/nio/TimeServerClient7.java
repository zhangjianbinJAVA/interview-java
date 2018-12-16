package com.dongnao.language.nio;
/**
 * 
 * @author Five老师
 * @createTime 2017年11月13日 下午5:21:33
 * 
 */
public class TimeServerClient7 {
	
	public static void main(String[] args) {
		int port=8080; //服务端默认端口
		if(args != null && args.length>0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		new Thread(new TimeClientHandler("127.0.0.1", port), "NIO-TimeServerClient6-001").start();
	}
}
