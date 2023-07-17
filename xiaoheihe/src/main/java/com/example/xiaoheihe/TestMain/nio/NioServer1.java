package com.example.xiaoheihe.TestMain.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer1 {

    public static void main(String[] args) throws IOException {

        //1 得到一个serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        //3 配置非阻塞
        serverSocketChannel.configureBlocking(false);
        //4 得到一个Selector对象
        Selector selector = Selector.open();

        //5 向Selector注册ServerSocketChannel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6 开始工作
        while (true) {
            //6.1 监听客户端
            if (selector.select(1000) == 0) {
                System.out.println("等待1s,无客户端连接");
                continue;
            }

            //6.2 判断通道事件
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            //遍历通道
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    //客户端连接请求事件
                    //接受通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //配置非阻塞
                    socketChannel.configureBlocking(false);
                    //注册到selector
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("有client连接请求过来");

                }
                if (key.isReadable()) {
                    //读取客户端事件
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    socketChannel.read(buffer);
                    System.out.println("接受客户端数据" + new String(buffer.array()));
                }
                if (key.isWritable()){
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    ByteBuffer buffer = ByteBuffer.wrap("收到数据".getBytes());
                    socketChannel.write(buffer);
                    System.out.println("输出");
                }
                // 6.3 手动从集合中移除当前key,防止重复处理
                keyIterator.remove();
            }

        }
    }
}

