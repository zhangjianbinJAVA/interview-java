package com.dongnao.language.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Five老师
 * @createTime 2017年11月13日 下午3:17:06
 */
public class TimeServer6 {
    public static void main(String[] args) {
        int port = 8080; //服务端默认端口
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket = null;
            while (true) {
                // 会一直监听谁链接它，没有连接时，会在这里阻塞住
                socket = server.accept();
                new Thread(new TimeServerHandler6(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                System.out.println("The time server is close.");
                try {
                    server.close();
                    server = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
