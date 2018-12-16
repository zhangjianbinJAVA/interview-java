package com.dongnao.language.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Five��ʦ
 * @createTime 2017��11��13�� ����4:56:39
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverChannel;
    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {
        try {
            // Selector ���ж����ͨ����һ��ʲô״̬
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port:" + port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while (iterator.hasNext()) {
                    selectionKey = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            if (selectionKey.isAcceptable()) {// ���ͨ���ǿ����ӵģ����������
                ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                SocketChannel client = server.accept();
                client.configureBlocking(false);
                // ע�ᵽselector���ȴ�����
                client.register(selector, SelectionKey.OP_READ);
            }
            if (selectionKey.isReadable()) { // ���ͨ���ǿɶ��ģ�������������������ж�����
                SocketChannel client = (SocketChannel) selectionKey.channel();
                ByteBuffer receivebuffer = ByteBuffer.allocate(1024);
                int count = client.read(receivebuffer);
                if (count > 0) {
                    receivebuffer.flip();
                    byte[] bytes = new byte[receivebuffer.remaining()]; //remaining()����
                    receivebuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server(Thread:" + Thread.currentThread() + ") receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                    doWrite(client, currentTime);
                } else if (count < 0) {
                    selectionKey.channel();
                    client.close();
                } else {

                }
            }
        }
    }

    private void doWrite(SocketChannel client, String currentTime) throws IOException {
        if (currentTime != null && currentTime.trim().length() > 0) {// ���ͨ���ǿ�д�ģ������д����
            ByteBuffer sendbuffer = ByteBuffer.allocate(1024);
            sendbuffer.put(currentTime.getBytes());
            sendbuffer.flip();
            client.write(sendbuffer);
            System.out.println("����������ͻ��˷�������--��" + currentTime);
        } else {
            System.out.println("û������");
        }
    }

}
