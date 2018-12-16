package com.dongnao.language.nio;
/**
 * 
 * @author Five��ʦ
 * @createTime 2017��11��13�� ����4:54:54
 * 
 */
public class TimeServer7 {

	public static void main(String[] args) {
		int port=8080; //�����Ĭ�϶˿�
		if(args != null && args.length>0){
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}
