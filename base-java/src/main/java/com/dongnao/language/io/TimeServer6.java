package com.dongnao.language.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Five��ʦ
 * @createTime 2017��11��13�� ����3:17:06
 */
public class TimeServer6 {
    public static void main(String[] args) {
        int port = 8080; //�����Ĭ�϶˿�
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
                // ��һֱ����˭��������û������ʱ��������������ס
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
