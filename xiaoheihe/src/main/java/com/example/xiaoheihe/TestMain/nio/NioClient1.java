package com.example.xiaoheihe.TestMain.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient1 {

    public static void main(String[] args) throws IOException {
        //1 得到一个Socker连接
        SocketChannel socketChannel = SocketChannel.open();
        //2 配置非阻塞
        socketChannel.configureBlocking(false);
        //3 绑定端口ip
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
        //4连接
        if (!socketChannel.connect(socketAddress)) {
            while (!socketChannel.finishConnect()) {
                //nio非阻塞式
                System.out.println("客户端: 因为连接需要时间，客户端不会阻塞，可以做个计算工作...");
            }
        }
        //写入数据

        ByteBuffer byteBuffer = ByteBuffer.wrap("Hello Netty!!!".getBytes());
        socketChannel.write(byteBuffer);

        System.in.read();
        System.out.println("客户端完成工作");
    }
}
